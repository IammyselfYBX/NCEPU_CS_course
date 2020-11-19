﻿
// ******* Repeater MANAGER ******** //
$axure.internal(function($ax) {
    var _repeaterManager = {};
    $ax.repeater = _repeaterManager;

    //This is a mapping of current editItems
    var repeaterToEditItems = {};
    //This is a mapping of current filters
    var repeaterToFilters = {};
    // This is a mapping of current sorts
    var repeaterToSorts = {};
    // This is a mapping of repeater page info
    var repeaterToPageInfo = {};

    //Hopefully this can be simplified, but for now I think 3 are needed.
    //This is the data set that is owned by this repeater. The repeater may or may not reference this data set, and others can reference it.
    var repeaterToLocalDataSet = {};
    //This is the data set referenced by the repeater. It is not a copy of the local data set, but a reference to a local data set (or eventually a global data set could be referenced).
    var repeaterToCurrentDataSet = {};
    //This is a copy of the current data set, that is replaced whenever a set or refresh is done.
    var repeaterToActiveDataSet = {};
    var _loadRepeaters = function() {
        $ax(function(obj) {
            return obj.type == 'repeater';
        }).each(function(obj, repeaterId) {
            repeaterToLocalDataSet[repeaterId] = $ax.deepCopy(obj.data);
            repeaterToLocalDataSet[repeaterId].props = obj.dataProps;
            repeaterToEditItems[repeaterId] = [];

            _initPageInfo(obj, repeaterId);

            _setRepeaterDataSet(repeaterId, repeaterId);

        });
    };
    _repeaterManager.load = _loadRepeaters;

    var _loaded = {};
    var _initRepeaters = function() {
        $ax(function(obj, repeaterId) {
            return obj.type == 'repeater' && !_loaded[repeaterId];
        }).each(function(obj, repeaterId) {
            _refreshRepeater(repeaterId);
        });
    };
    _repeaterManager.init = _initRepeaters;

    var repeatersHaveNewDataSet = [];
    var _setRepeaterDataSet = function(repeaterId, dataSetId) {
        //TODO: No idea about how global data sets will be handled...
        repeaterToCurrentDataSet[repeaterId] = repeaterToLocalDataSet[dataSetId];
        repeaterToActiveDataSet[repeaterId] = repeaterToCurrentDataSet[repeaterId];
        repeaterToFilters[repeaterId] = [];
        repeaterToSorts[repeaterId] = [];


        // Not using this currently
        //        if(repeatersHaveNewDataSet.indexOf(repeaterId) == -1) repeatersHaveNewDataSet[repeatersHaveNewDataSet.length] = repeaterId;
    };
    _repeaterManager.setDataSet = _setRepeaterDataSet;

    var _refreshRepeater = function(repeaterId, eventInfo) {
        // Don't show if you have a parent rdos thats limboed.
        var rdoPath = $ax.getPathFromScriptId(repeaterId);
        var view = $ax.adaptive.currentViewId;
        var chain = $ax.adaptive.getAdaptiveIdChain(view);
        var testView = view;
        // Check each parent rdo through appropriate views to see if you are limboed
        while (rdoPath.length > 0) {
            var testingChain = testView;
            var rdoObj = $obj($ax.getScriptIdFromPath(rdoPath));
            var style = testView ? rdoObj.adaptiveStyles && rdoObj.adaptiveStyles[testView] : rdoObj.style;
            if(style && typeof (style.limbo) != 'undefined') {
                if(style.limbo) {
                    removeItems(repeaterId);
                    return;
                }
                // Otherwise this chain is good, move up rdo again
                testingChain = false;
            }

            if(testingChain) {
                var viewIndex = chain.indexOf(testView);
                testView = viewIndex == 0 ? '' : chain[viewIndex - 1];
            } else {
                $ax.splice(rdoPath, rdoPath.length - 1, 1);
                testView = view;
            }
        }

        _loaded[repeaterId] = true;
        $ax.action.refreshStart(repeaterId);
        $ax.style.ClearCacheForRepeater(repeaterId);

        if($ax.visibility.limboIds[repeaterId]) {
            removeItems(repeaterId);
            $ax.dynamicPanelManager.fitParentPanel(repeaterId);
            return;
        }

        var path = $ax.getPathFromScriptId(repeaterId);
        path.pop();

        if(eventInfo) {
            eventInfo = $ax.eventCopy(eventInfo);
        }

        var obj = $ax.getObjectFromScriptId(repeaterId);

        var html = $('#' + repeaterId + '_script').html();
        //        var container = $('<div></div>');
        //        container.html(html);
        //        container.attr('id', '' + repeaterId + '_container');
        //        container.css({ position: 'absolute' });
        //        container.offset({ left: -obj.x, top: -obj.y });

        var div = $('<div></div>');
        div.html(html);

        var top = 0;
        var left = 0;

        //If there is no wrap, then set it to be above the number of rows
        var propMap = obj.repeaterPropMap;
        var viewId = $ax.adaptive.currentViewId || '';
        var wrap = _getAdaptiveProp(propMap, 'wrap', viewId);
        var vertical = _getAdaptiveProp(propMap, 'vertical', viewId);
        var offset = propMap[viewId];
        var xOffset = offset.width + _getAdaptiveProp(propMap, 'horizontalSpacing', viewId);
        var yOffset = offset.height + _getAdaptiveProp(propMap, 'verticalSpacing', viewId);
        div.css({
            width: offset.width,
            height: offset.height
        });

        var background = _getAdaptiveProp(propMap, 'backColor', viewId);
        _applyColorCss(background, div);
        var hasAltColor = _getAdaptiveProp(propMap, 'hasAltColor', viewId);
        var altDiv = div;
        if(hasAltColor) altDiv = _applyColorCss(hasAltColor ? _getAdaptiveProp(propMap, 'altColor', viewId) : background, div.clone());

        var orderedIds = getOrderedIds(repeaterId, eventInfo);

        // Hide repeater, if shown, while updating.
        var shown = $ax.visibility.IsIdVisible(repeaterId);
        if(shown) document.getElementById(repeaterId).style.visibility = 'hidden';

        var bounds = _getVisibleDataBounds(repeaterToPageInfo[repeaterId], orderedIds.length);
        var start = bounds[0];
        var end = bounds[1];
        var useAlt = false;

        var resized = $ax.getItemIdsForRepeater(repeaterId).length != (end - start);

        //clean up old items as late as possible
        removeItems(repeaterId);

        var i = 0;
        var ids = [];
        for(var pos = start; pos < end; pos++) {
            var itemId = orderedIds[pos];

            var itemElementId = _createElementId(repeaterId, itemId);
            $ax.addItemIdToRepeater(itemId, repeaterId);

            ids.push(itemElementId);
            var processId = function(full, prop, id, suffix) {
                var elementId = _createElementId('u' + id, itemId);
                //If there is a suffix (ex. _img), then don't push the id.
                if(!suffix) ids.push(elementId);
                return prop + '="' + elementId + '"';
            };

            var copy = (useAlt ? altDiv : div).clone();
            useAlt = !useAlt;
            copy.attr('id', itemElementId);
            copy.html(div.html().replace(/(id|for)="?u([0-9]+(_[_a-z0-9]*)?)"?/g, processId));

            copy.css({
                'position': 'absolute',
                'top': top + 'px',
                'left': left + 'px',
                'width': obj.width + 'px',
                'height': obj.height + 'px'
            });
            $('#' + repeaterId).append(copy);

            i++;
            if(wrap != -1 && i % wrap == 0) {
                if(vertical) {
                    top = 0;
                    left += xOffset;
                } else {
                    left = 0;
                    top += yOffset;
                }
            } else if(vertical) top += yOffset;
            else left += xOffset;
        }

        var query = $ax(function(diagramObject, elementId) {
            // All objects with the repeater as their parent, except the repeater itself.
            var scriptId = _getScriptIdFromElementId(elementId);
            return $ax.getParentRepeaterFromScriptId(scriptId) == repeaterId && scriptId != repeaterId;
        });
        if(viewId) $ax.adaptive.applyView(viewId, query);
        else {
            var limbo = {};
            var hidden = {};
            query.each(function(diagramObject, elementId) {
                // sigh, javascript. we need the === here because undefined means not overriden
                if(diagramObject.style.visible === false) hidden[elementId] = true;
                //todo: **mas** check if the limboed widgets are hidden by default by the generator
                if(diagramObject.style.limbo) limbo[elementId] = true;
            });
            $ax.visibility.addLimboAndHiddenIds(limbo, hidden, query);
            $ax.dynamicPanelManager.updatePercentPanelCache(query);
        }
        $ax.annotation.InitializeAnnotations(query);

        for(var index = 0; index < ids.length; index++) {
            var id = ids[index];
            var childObj = $obj(id);
            var childJobj = $jobj(id);
            var childItemId = _getItemIdFromElementId(id);
            if(obj.repeaterPropMap.isolateRadio && childObj.type == 'radioButton') {
                var input = $jobj(_applySuffixToElementId(id, '_input'));
                input.attr('name', _createElementId(input.attr('name'), childItemId));
                if($ax.ieColorManager) $ax.ieColorManager.applyBackground($ax('#' + id));
            }
            if(obj.repeaterPropMap.isolateSelection && childJobj.attr('selectiongroup')) {
                childJobj.attr('selectiongroup', _createElementId(childJobj.attr('selectiongroup'), childItemId));
            }
            $ax.initializeObjectEvents($ax('#' + id));
            $ax.dynamicPanelManager.initFitPanels($ax('#' + id));
            $ax.style.initializeObjectTextAlignment($ax('#' + id));
            $ax.applyHighlight($ax('#' + id), true);
        }

        //$ax.event.raiseSyntheticEvent(itemElementId, 'onLoad', true);
        //$ax.loadDynamicPanelsAndMasters(obj.objects, path, itemId);

        // Now load
        for(pos = start; pos < end; pos++) {
            itemId = orderedIds[pos];
            itemElementId = _createElementId(repeaterId, itemId);

            $ax.event.raiseSyntheticEvent(itemElementId, 'onItemLoad', true);
            $ax.loadDynamicPanelsAndMasters(obj.objects, path, itemId);
        }

        // Reshow repeater if it was originally shown (load is complete by now)
        if(shown) document.getElementById(repeaterId).style.visibility = 'visible';

        $ax.dynamicPanelManager.fitParentPanel(repeaterId);

        // If number of items changed, you need to resize the repeater
        if(resized) {
            var count = end - start;

            // When getting assume not vertical first. Get how many items wide and high it is.
            var yCount = wrap == -1 ? 1 : Math.ceil(count / wrap);
            var xCount = wrap == -1 ? count : count % wrap;
            if(xCount == 0) xCount = wrap;
            // Now swap if vertical
            if(vertical) {
                var temp = xCount;
                xCount = yCount;
                yCount = temp;
            }

            // xOffset includes, the spacing, but first time that should be ignored. So just add the width/height once, and all the other times add the offset.
            $jobj(repeaterId).css('width', offset.width + (xCount - 1) * xOffset);
            $jobj(repeaterId).css('height', offset.height + (yCount - 1) * yOffset);
        }

        // Right now we assume only one refresh at a time. If we can manually trigger refreshes, that may possibly change.
        $ax.action.refreshEnd();
    };
    _repeaterManager.refreshRepeater = _refreshRepeater;

    _repeaterManager.refreshAllRepeaters = function() {
        $ax('*').each(function(diagramObject, elementId) {
            if(diagramObject.type != 'repeater') return;

            _initPageInfo(diagramObject, elementId);
            _refreshRepeater(elementId, $ax.getEventInfoFromEvent($ax.getjBrowserEvent()));
        });
    };

    _repeaterManager.refreshRepeaters = function(ids, eventInfo) {
        for(var i = 0; i < ids.length; i++) _refreshRepeater(ids[i], eventInfo);
    };

    var _initPageInfo = function(obj, elementId) {
        var pageInfo = {};
        var map = obj.repeaterPropMap;

        var currentViewId = $ax.adaptive.currentViewId || '';
        var itemsPerPage = _getAdaptiveProp(map, 'itemsPerPage', currentViewId);
        if(itemsPerPage == -1) pageInfo.noLimit = true;
        else {
            pageInfo.itemsPerPage = itemsPerPage;
            pageInfo.currPage = _getAdaptiveProp(map, 'currPage', currentViewId);
        }
        repeaterToPageInfo[elementId] = pageInfo;
    };

    var _applyColorCss = function(json, div) {
        var args = json.r + ', ' + json.g + ', ' + json.b;
        var background = json.a == 0 ? '' : json.a == 1 ? 'rgb(' + args + ')' : 'rgba(' + args + ', ' + json.a + ')';
        if($ax.ieColorManager && json.a != 0 && json.a != 1) {
            var ieColor = $ax.ieColorManager.getColorFromArgb(json.a * 255, json.r, json.g, json.b, true);
            if(ieColor) background = ieColor;
        }
        div.css('background-color', background);
        return div;
    };

    var _getAdaptiveProp = _repeaterManager.getAdaptiveProp = function(map, prop, viewId) {
        var viewChain = $ax.adaptive.getAdaptiveIdChain(viewId);
        for(var i = viewChain.length - 1; i >= 0; i--) {
            viewId = viewChain[i];
            var viewProps = map[viewId];
            if(viewProps.hasOwnProperty(prop)) return viewProps[prop];
        }

        var base = map[''];
        if(base.hasOwnProperty(prop)) return base[prop];
        return map['default'][prop];
    };

    _repeaterManager.getItemCount = function(repeaterId) {
        var data = repeaterToActiveDataSet[repeaterId].length;
        var info = repeaterToPageInfo[repeaterId];
        if(!info.noLimit) {
            var start = Math.min(data, info.itemsPerPage * info.currPage);
            var end = Math.min(data, start + info.itemsPerPage);
            data = end - start;
        }
        return data;
    };

    _repeaterManager.setDisplayProps = function(obj, repeaterId, itemIndex) {
        var data = repeaterToActiveDataSet[repeaterId];
        var info = repeaterToPageInfo[repeaterId];
        var start = 0;
        var end = data.length;
        if(!info.noLimit) {
            start = Math.min(end, info.itemsPerPage * (info.currPage - 1));
            end = Math.min(end, start + info.itemsPerPage);
        }
        var count = end - start;
        var index = -1;
        for(var i = 0; i < count; i++) {
            if(data[start + i].index == itemIndex) index = i + 1;
        }
        if(index == -1) return;
        obj.index = index;
        obj.isfirst = index == 1;
        obj.islast = index == end - start;
        obj.iseven = index % 2 == 0;
        obj.isodd = index % 2 == 1;
    };

    var _getVisibleDataBounds = function(pageInfo, count) {
        var retval = [0, count];
        if(!pageInfo.noLimit) {
            var end = pageInfo.itemsPerPage * pageInfo.currPage;
            var start = end - pageInfo.itemsPerPage;

            // If past the end, move to last page
            if(start >= count) {
                pageInfo.currPage = Math.floor((count - 1) / pageInfo.itemsPerPage) + 1;
                if(pageInfo.currPage <= 0) pageInfo.currPage = 1;

                end = pageInfo.itemsPerPage * pageInfo.currPage;
                start = end - pageInfo.itemsPerPage;
            }
            end = Math.min(end, count);
            retval[0] = start;
            retval[1] = end;
        }
        return retval;
    };

    _repeaterManager.getVisibleDataCount = function(repeaterId) {
        var bounds = _getVisibleDataBounds(repeaterToPageInfo[repeaterId], repeaterToActiveDataSet[repeaterId].length);
        return bounds[1] - bounds[0];
    };

    _repeaterManager.getDataCount = function(repeaterId) {
        return repeaterToCurrentDataSet[repeaterId].length;
    };

    var _getFilteredDataCount = _repeaterManager.getFilteredDataCount = function(repeaterId) {
        return repeaterToActiveDataSet[repeaterId].length;
    };

    _repeaterManager.getPageCount = function(repeaterId) {
        var info = repeaterToPageInfo[repeaterId];
        return info.noLimit ? 1 : Math.ceil(_getFilteredDataCount(repeaterId) / info.itemsPerPage);
    };

    _repeaterManager.getPageIndex = function(repeaterId) {
        var info = repeaterToPageInfo[repeaterId];
        return info.noLimit ? 1 : info.currPage;
    };

    var getActiveDataSet = function(repeaterId) {
        var active = $ax.deepCopy(repeaterToCurrentDataSet[repeaterId]);
        // Set up 1 indexing each item.
        for(var i = 0; i < active.length; i++) active[i].index = i + 1;
        return active;
    };

    var getOrderedIds = function(repeaterId, eventInfo) {
        var data = repeaterToActiveDataSet[repeaterId] = getActiveDataSet(repeaterId);

        // Filter first so less to sort
        applyFilter(repeaterId, data, eventInfo);

        // Sort next
        var sorts = repeaterToSorts[repeaterId] || [];
        if(sorts.length != 0 && data.length > 1) {
            // TODO: Make this generic and factor out if we want to use it elsewhere...
            // Compare is a function that takes 2 arguments, and returns a number. A high number means the second should go first
            // Otherwise the first stays first.
            var mergesort = function(list, start, end, compare) {
                var middle = Math.floor((start + end) / 2);
                if(middle - start > 1) mergesort(list, start, middle, compare);
                if(end - middle > 1) mergesort(list, middle, end, compare);
                var index1 = start;
                var index2 = middle;
                var tempList = [];
                while(index1 < middle && index2 < end) {
                    tempList[tempList.length] = list[compare(list[index1], list[index2]) > 0 ? index2++ : index1++];
                }
                while(index1 < middle) tempList[tempList.length] = list[index1++];
                while(index2 < end) tempList[tempList.length] = list[index2++];

                // transfer from temp list to the real list.
                for(var i = 0; i < tempList.length; i++) list[start + i] = tempList[i];
            };
            // Compare is the tie breaking function to us if necessary.
            var getComparator = function(columnName, ascending, type, compare) {
                // If this needs to be sped up, break up into several smaller functions conditioned off of type
                return function(row1, row2) {
                    // If column undefined, no way to measure this, so call it a tie.
                    if(row1[columnName] === undefined || row2[columnName] === undefined) return 0;

                    var text1 = row1[columnName].text;
                    var text2 = row2[columnName].text;

                    // This means we are case insensitive, so lowercase everything to kill casing
                    if(type == 'Text') {
                        text1 = text1.toLowerCase();
                        text2 = text2.toLowerCase();
                    }

                    //If tied, go to tie breaker
                    if(text1 == text2) {
                        if(compare) return compare(row1, row2);
                        // Actually a tie.
                        return 0;
                    }
                    if(type == 'Text' || type == 'Text (Case Sensitive)') {
                        if(text1 < text2 ^ ascending) return 1;
                        else return -1;
                    } else if(type == 'Number') {
                        var num1 = Number(text1);
                        var num2 = Number(text2);

                        if(isNaN(num1) && isNaN(num2)) return 0;
                        if(isNaN(num1) || isNaN(num2)) return isNaN(num1) ? 1 : -1;
                        if(num1 < num2 ^ ascending) return 1;
                        else return -1;
                    } else if(type == 'Date - YYYY-MM-DD' || type == 'Date - MM/DD/YYYY') {
                        var func = type == 'Date - YYYY-MM-DD' ? getDate1 : getDate2;
                        var date1 = func(text1);
                        var date2 = func(text2);
                        if(!date1.valid && !date2.valid) return 0;
                        if(!date1.valid || !date2.valid) return date1.valid ? -1 : 1;
                        var diff = date2.year - date1.year;
                        if(diff == 0) diff = date2.month - date1.month;
                        if(diff == 0) diff = date2.day - date1.day;
                        if(diff == 0) return 0;
                        return diff > 0 ^ ascending ? 1 : -1;
                    }
                    console.log('unhandled sort type');
                    return 0;
                };
            };
            var compareFunc = null;
            for(var i = 0; i < sorts.length; i++) compareFunc = getComparator(sorts[i].columnName, sorts[i].ascending, sorts[i].sortType, compareFunc);

            mergesort(data, 0, data.length, compareFunc);
        }

        var ids = [];
        for(i = 0; i < data.length; i++) ids[i] = data[i].index;

        return ids;
    };

    var getDate1 = function(text) {
        var date = { valid: false };
        var sections = text.split('-');
        if(sections.length == 1) sections = text.split('/');
        if(sections.length != 3) return date;
        date.year = Number(sections[0]);
        date.month = Number(sections[1]);
        date.day = Number(sections[2]);
        date.valid = !isNaN(date.year);
        date.valid &= !isNaN(date.month) && date.month > 0 && date.month <= 12;
        date.valid &= !isNaN(date.day) && date.day > 0 && date.day <= daysPerMonth(date.month, date.year);
        return date;
    };

    var getDate2 = function(text) {
        var date = { valid: false };
        var sections = text.split('-');
        if(sections.length == 1) sections = text.split('/');
        if(sections.length != 3) return date;
        date.month = Number(sections[0]);
        date.day = Number(sections[1]);
        date.year = Number(sections[2]);
        date.valid = !isNaN(date.year);
        date.valid &= !isNaN(date.month) && date.month > 0 && date.month <= 12;
        date.valid &= !isNaN(date.day) && date.day > 0 && date.day <= daysPerMonth(date.month, date.year);
        return date;
    };

    var daysPerMonth = function(month, year) {
        if(month == 9 || month == 4 || month == 6 || month == 11) return 30;
        if(month != 2) return 31;

        if(year % 4 != 0) return 28;
        if(year % 100 != 0) return 29;
        return year % 400 == 0 ? 29 : 28;
    };

    var applyFilter = function(repeaterId, data, eventInfo) {
        var dataFiltered = [];
        var filters = repeaterToFilters[repeaterId] || [];
        if(filters.length != 0) {
            var oldSrc = eventInfo.srcElement;
            var oldThis = eventInfo.thiswidget;

            outer:
            for(var i = 1; i <= data.length; i++) {
                for(var j = 0; j < filters.length; j++) {
                    eventInfo.targetElement = _createElementId(repeaterId, i);
                    eventInfo.srcElement = filters[j].thisId;
                    eventInfo.thiswidget = $ax.getWidgetInfo(eventInfo.srcElement);

                    if($ax.expr.evaluateExpr(filters[j].filter, eventInfo) != 'true') continue outer;
                }
                dataFiltered[dataFiltered.length] = data[i - 1];
            }

            for(i = 0; i < dataFiltered.length; i++) data[i] = dataFiltered[i];
            while(data.length > dataFiltered.length) data.pop();

            eventInfo.srcElement = oldSrc;
            eventInfo.thiswidget = oldThis;
        }
    };

    var _addFilter = function(repeaterId, label, filter, thisId) {
        var filterList = repeaterToFilters[repeaterId];
        if(!filterList) repeaterToFilters[repeaterId] = filterList = [];

        var filterObj = { filter: filter, thisId: thisId };
        if(label) filterObj.label = label;
        filterList[filterList.length] = filterObj;
    };
    _repeaterManager.addFilter = _addFilter;

    var _removeFilter = function(repeaterId, label) {
        var filterList = repeaterToFilters[repeaterId];
        // If no list, nothing to remove
        if(!filterList) return;

        // If no label, remove everything
        if(!label) {
            repeaterToFilters[repeaterId] = [];
            return;
        }

        for(var i = filterList.length - 1; i >= 0; i--) {
            var filterObj = filterList[i];
            if(filterObj.label && filterObj.label == label) $ax.splice(filterList, i, 1);
        }
    };
    _repeaterManager.removeFilter = _removeFilter;

    var _addSort = function(repeaterId, label, columnName, ascending, toggle, sortType) {
        var sortList = repeaterToSorts[repeaterId];
        if(!sortList) repeaterToSorts[repeaterId] = sortList = [];

        for(var i = 0; i < sortList.length; i++) {
            if(columnName == sortList[i].columnName) {
                var lastSortObj = $ax.splice(sortList, i, 1)[0];
                if(toggle) ascending = !lastSortObj.ascending;
                break;
            }
        }

        var sortObj = { columnName: columnName, ascending: ascending, sortType: sortType };

        if(label) sortObj.label = label;
        sortList[sortList.length] = sortObj;
    };
    _repeaterManager.addSort = _addSort;

    var _removeSort = function(repeaterId, label) {
        var sortList = repeaterToSorts[repeaterId];
        // If no list, nothing to remove
        if(!sortList) return;

        // If no label, remove everything
        if(!label) {
            repeaterToSorts[repeaterId] = [];
            return;
        }

        for(var i = sortList.length - 1; i >= 0; i--) {
            var sortObj = sortList[i];
            if(sortObj.label && sortObj.label == label) $ax.splice(sortList, i, 1);
        }
    };
    _repeaterManager.removeSort = _removeSort;

    var _setRepeaterToPage = function(repeaterId, type, value, eventInfo) {
        var pageInfo = repeaterToPageInfo[repeaterId];
        // page doesn't matter if there is no limit.
        if(pageInfo.noLimit) return;

        var dataSet = repeaterToActiveDataSet[repeaterId];
        if(!dataSet) dataSet = repeaterToCurrentDataSet[repeaterId];
        var lastPage = Math.max(1, Math.ceil(dataSet.length / pageInfo.itemsPerPage));

        if(type == 'Value') {
            var val = Number($ax.expr.evaluateExpr(value, eventInfo));
            // if invalid, default to 1, otherwise, clamp the value
            if(isNaN(val)) val = 1;
            else if(val < 1) val = 1;
            else if(val > lastPage) val = lastPage;

            pageInfo.currPage = val;
        } else if(type == 'Previous') {
            if(pageInfo.currPage > 1) pageInfo.currPage--;
        } else if(type == 'Next') {
            if(pageInfo.currPage < lastPage) pageInfo.currPage++;
        } else if(type == 'Last') {
            pageInfo.currPage = lastPage;
        } else {
            console.log('Unknown type');
        }
    };
    _repeaterManager.setRepeaterToPage = _setRepeaterToPage;

    var _setNoItemLimit = function(repeaterId) {
        var pageInfo = repeaterToPageInfo[repeaterId];
        delete pageInfo.currPage;
        delete pageInfo.itemsPerPage;
        pageInfo.noLimit = true;
    };
    _repeaterManager.setNoItemLimit = _setNoItemLimit;

    var _setItemLimit = function(repeaterId, value, eventInfo) {
        var pageInfo = repeaterToPageInfo[repeaterId];

        if(pageInfo.noLimit) {
            pageInfo.noLimit = false;
            pageInfo.currPage = 1;
        }

        var oldTarget = eventInfo.targetElement;
        eventInfo.targetElement = repeaterId;
        var itemLimit = Number($ax.expr.evaluateExpr(value, eventInfo));
        eventInfo.targetElement = oldTarget;
        if(isNaN(itemLimit)) itemLimit = 20;
        else if(itemLimit < 1) itemLimit = 1;
        pageInfo.itemsPerPage = itemLimit;
    };
    _repeaterManager.setItemLimit = _setItemLimit;

    var removeItems = function(repeaterId) {
        var elementIds = $ax.getChildElementIdsForRepeater(repeaterId);
        for(var i = 0; i < elementIds.length; i++) $('#' + elementIds[i]).remove();
        $ax.visibility.clearLimboAndHiddenIds(elementIds);
        $ax.clearItemsForRepeater(repeaterId);
    };

    var _getDataFromDataSet = function(repeaterId, itemId, propName, type) {
        var itemNum = Number(itemId) - 1;
        // Default to obj with text as empty string, as we don't generate the data for empty props
        var data = repeaterToCurrentDataSet[repeaterId][itemNum][propName] || { text: '' };
        //For now text is always the default. May change this to depend on context.
        return type == 'data' && data.type != 'text' ? data : (type && data[type]) || data['text'];
    };
    _repeaterManager.getData = _getDataFromDataSet;

    _repeaterManager.hasData = function(id, propName) {
        if(!_getItemIdFromElementId(id)) return false;
        var repeaterId = $ax.getParentRepeaterFromScriptId(_getScriptIdFromElementId(id));
        return Boolean(repeaterToCurrentDataSet[repeaterId] && repeaterToCurrentDataSet[repeaterId].props.indexOf(propName) != -1);
    };

    var _addItemToDataSet = function(repeaterId, row, itemEventInfo) {
        itemEventInfo.data = true;
        var oldTarget = itemEventInfo.targetElement;
        itemEventInfo.targetElement = repeaterId;
        var dataSet = repeaterToLocalDataSet[repeaterId];

        for(var propName in row) {
            if(!row.hasOwnProperty(propName)) continue;
            var prop = row[propName];
            if(prop.type == 'literal') {
                var retval = $ax.expr.evaluateExpr(prop.literal, itemEventInfo);
                if(typeof (retval) == 'string') retval = { type: 'text', text: retval };
                row[propName] = retval;
            }
        }

        itemEventInfo.targetElement = oldTarget;
        dataSet[dataSet.length] = row;
        itemEventInfo.data = false;
    };
    _repeaterManager.addItem = _addItemToDataSet;

    var _deleteItemsFromDataSet = function(repeaterId, eventInfo, type, rule) {
        var dataSet = repeaterToCurrentDataSet[repeaterId];
        var items;

        // Should always be this, marked, or rule.
        if(type == 'this') items = [_getItemIdFromElementId(eventInfo.srcElement)];
        else if(type == 'marked') items = repeaterToEditItems[repeaterId];
        else {
            // This should be rule
            var visibleData = repeaterToCurrentDataSet[repeaterId];
            var items = [];
            var oldTarget = eventInfo.targetElement;
            for(var i = 0; i < visibleData.length; i++) {
                var index = i + 1;
                eventInfo.targetElement = _createElementId(repeaterId, index);
                if($ax.expr.evaluateExpr(rule, eventInfo).toLowerCase() != 'true') continue;
                items.push(index);
            }
            eventInfo.targetElement = oldTarget;
        }
        // Want them decending
        items.sort(function(a, b) { return b - a; });

        for(i = 0; i < items.length; i++) {
            var itemId = items[i];
            $ax.splice(dataSet, itemId - 1, 1);
        }
        repeaterToEditItems[repeaterId] = [];
    };
    _repeaterManager.deleteItems = _deleteItemsFromDataSet;

    var _updateEditItemsInDataSet = function(repeaterId, propMap, eventInfo, type, rule) {
        var oldTarget = eventInfo.targetElement;
        var dataSet = repeaterToCurrentDataSet[repeaterId];
        var items;

        // Should always be this, marked, or rule.
        if(type == 'this') items = [_getItemIdFromElementId(eventInfo.srcElement)];
        else if(type == 'marked') items = repeaterToEditItems[repeaterId];
        else {
            // This should be rule
            var currData = repeaterToCurrentDataSet[repeaterId];
            var items = [];
            var oldTarget = eventInfo.targetElement;
            for(var i = 0; i < currData.length; i++) {
                var index = i + 1;
                eventInfo.targetElement = _createElementId(repeaterId, index);
                if($ax.expr.evaluateExpr(rule, eventInfo).toLowerCase() != 'true') continue;
                items.push(index);
            }
            eventInfo.targetElement = oldTarget;
        }

        eventInfo.data = true;
        for(var prop in propMap) {
            if(!propMap.hasOwnProperty(prop)) continue;
            for(var i = 0; i < items.length; i++) {
                var data = propMap[prop];
                var item = items[i];
                if(data.type == 'literal') {
                    eventInfo.targetElement = _createElementId(repeaterId, item);
                    data = $ax.expr.evaluateExpr(data.literal, eventInfo);
                    if(typeof (data) == 'object' && data.isWidget) data = data.text;
                    if(typeof (data) == 'string') data = { type: 'text', text: data };
                }
                dataSet[item - 1][prop] = data;
            }
        }
        eventInfo.targetElement = oldTarget;
        eventInfo.data = false;
    };
    _repeaterManager.updateEditItems = _updateEditItemsInDataSet;

    var _getAllItemIds = function(repeaterId) {
        var retval = [];
        var currDataSet = repeaterToCurrentDataSet[repeaterId];
        for(var i = 0; i < currDataSet.length; i++) retval.push(i + 1);
        return retval;
    };
    _repeaterManager.getAllItemIds = _getAllItemIds;

    var _addEditItemToRepeater = function(repeaterId, itemIds) {
        for(var i = 0; i < itemIds.length; i++) {
            var itemId = Number(itemIds[i]);
            var items = repeaterToEditItems[repeaterId];
            if(items.indexOf(itemId) == -1) items[items.length] = itemId;
        }
    };
    _repeaterManager.addEditItems = _addEditItemToRepeater;

    var _removeEditItemFromRepeater = function(repeaterId, itemIds) {
        for(var i = 0; i < itemIds.length; i++) {
            var itemId = itemIds[i];
            var items = repeaterToEditItems[repeaterId];
            var index = items.indexOf(Number(itemId));
            if(index != -1) $ax.splice(items, index, 1);
        }
    };
    _repeaterManager.removeEditItems = _removeEditItemFromRepeater;

    _repeaterManager.isEditItem = function(repeaterId, itemId) {
        var items = repeaterToEditItems[repeaterId];
        return items.indexOf(Number(itemId)) != -1;
    };

    var _createElementId = function(scriptId, itemId) {
        if(!itemId) return scriptId;
        var i = scriptId.indexOf('_');
        var sections = i > -1 ? [scriptId.substring(0, i), scriptId.substring(i + 1)] : [scriptId];
        var retval = sections[0] + '-' + itemId;
        return sections.length > 1 ? retval + '_' + sections[1] : retval;
    };
    _repeaterManager.createElementId = _createElementId;

    var _getElementId = function(scriptId, childId) {
        var elementId = scriptId;
        if($ax.getParentRepeaterFromScriptId(scriptId)) {
            // Must be in the same item as the child
            var itemId = $ax.repeater.getItemIdFromElementId(childId);
            elementId = $ax.repeater.createElementId(scriptId, itemId);
        }
        return elementId;
    };
    _repeaterManager.getElementId = _getElementId;

    var _getScriptIdFromElementId = function(elementId) {
        if(!elementId) return elementId;
        var sections = elementId.split('-');
        var retval = sections[0];
        if(sections.length <= 1) return retval;
        sections = sections[1].split('_');
        return sections.length > 1 ? retval + '_' + sections[1] : retval;
    };
    _repeaterManager.getScriptIdFromElementId = _getScriptIdFromElementId;

    var _getItemIdFromElementId = function(elementId) {
        var sections = elementId.split('-');
        if(sections.length < 2) return '';
        sections = sections[1].split('_');
        return sections[0];
    };
    _repeaterManager.getItemIdFromElementId = _getItemIdFromElementId;

    // TODO: Just inline this if we keep it this way.
    var _applySuffixToElementId = function(id, suffix) {
        return id + suffix;
        //        return _createElementId(_getScriptIdFromElementId(id) + suffix, _getItemIdFromElementId(id));
    };
    _repeaterManager.applySuffixToElementId = _applySuffixToElementId;

    //    var _getRepeaterSize = function(repeaterId) {
    //        var itemCount = ($ax.getItemIdsForRepeater(repeaterId) || []).length;
    //        if(itemCount == 0) return { width: 0, height: 0 };

    //        var repeater = $obj(repeaterId);
    //        // Width and height per item;
    //        var width = repeater.width;
    //        var height = repeater.height;

    //        var viewId = $ax.adaptive.currentViewId || '';
    //        var widthIncrement = width + _getAdaptiveProp(repeater.repeaterPropMap, 'horizontalSpacing', viewId);
    //        var heightIncrement = height + _getAdaptiveProp(repeater.repeaterPropMap, 'verticalSpacing', viewId);

    //        var wrap = _getAdaptiveProp(repeater.repeaterPropMap, 'wrap', viewId);
    //        var vertical = _getAdaptiveProp(repeater.repeaterPropMap, 'vertical', viewId);

    //        if(wrap == -1 || itemCount <= wrap) {
    //            if(vertical) height += heightIncrement * (itemCount - 1);
    //            else width += widthIncrement * (itemCount - 1);
    //        } else {
    //            var primaryDim = wrap;
    //            var secondaryDim = Math.ceil(itemCount / primaryDim);

    //            if(vertical) {
    //                height += heightIncrement * (primaryDim - 1);
    //                width += widthIncrement * (secondaryDim - 1);
    //            } else {
    //                width += widthIncrement * (primaryDim - 1);
    //                height += heightIncrement * (secondaryDim - 1);
    //            }
    //        }
    //        return { width: width, height: height };
    //    };
    //    _repeaterManager.getRepeaterSize = _getRepeaterSize;

});

// ******* Dynamic Panel Manager ******** //
$axure.internal(function($ax) {
    // TODO: Probably a lot of the dynamic panel functions from pagescript should be moved here at some point...
    var _dynamicPanelManager = $ax.dynamicPanelManager = {};

    var _isIdFitToContent = _dynamicPanelManager.isIdFitToContent = function(id) {
        var obj = $obj(id);
        if(!obj || obj.type != 'dynamicPanel' || !obj.fitToContent) return false;

        var jobj = $jobj($ax.visibility.GetPanelState(id));
        return jobj.css('position') == 'relative';
    };

    var _fitParentPanel = function(widgetId) {
        // Find parent panel if there is one.
        var parentPanelInfo = getParentPanel(widgetId);
        if(!parentPanelInfo) return;

        var parentId = parentPanelInfo.parent;
        if(_updateFitPanel(parentId, parentPanelInfo.state)) _fitParentPanel(parentId);
    };
    _dynamicPanelManager.fitParentPanel = _fitParentPanel;

    _dynamicPanelManager.initialize = function() {
        _dynamicPanelManager.initFitPanels($ax('*'));

        $axure.resize(_handleResize);
    };

    _dynamicPanelManager.initFitPanels = function(query) {
        var fitToContent = [];
        query.each(function(obj, elementId) {
            if(obj.type == 'dynamicPanel' && obj.fitToContent) fitToContent[fitToContent.length] = elementId;
        });
        for(var i = fitToContent.length - 1; i >= 0; i--) {
            var panelId = fitToContent[i];
            var stateCount = $obj(panelId).diagrams.length;
            for(var j = 0; j < stateCount; j++) {
                // Traverse through children to find what size it should be.
                var stateId = $ax.repeater.applySuffixToElementId(panelId, '_state' + j);
                var stateContentId = stateId + '_content';
                var stateQuery = $jobj(stateId);
                var size = getContainerSize(stateContentId);
                if(!$obj(panelId).percentWidth) stateQuery.width(size.width);
                stateQuery.height(size.height);
            }
        }
    };

    var percentPanelToLeftCache = [];
    var percentPanelsInitialized = false;
    var _handleResize = function() {
        if(percentPanelsInitialized) {
            for(var key in percentPanelToLeftCache) {
                //could optimize to only update non-contained panels
                _updatePanelPercentWidth(key);
            }
        } else {
            $ax('*').each(function(obj, elementId) {
                if(_isPercentWidthPanel(obj)) _updatePanelPercentWidth(elementId);
            });
            percentPanelsInitialized = true;
        }
    };

    var _isPercentWidthPanel = _dynamicPanelManager.isPercentWidthPanel = function(obj) {
        return obj && obj.type == 'dynamicPanel' && obj.percentWidth;
    };

    _dynamicPanelManager.updatePanelContentPercentWidth = function(elementId) {
        //        if(_isPercentWidthPanel($obj(elementId))) return;
        var stateChildrenQuery = $jobj(elementId).children('.panel_state');
        stateChildrenQuery.children('.panel_state_content').each(
            function() {
                $(this).children('.ax_dynamic_panel').each(
                    function() { _updatePanelPercentWidth(this.id); }
                );
            }
        );
    };

    _dynamicPanelManager.updatePercentPanelCache = function(query) {
        query.each(function(obj, elementId) {
            if(_isPercentWidthPanel(obj)) {
                if(_updatePercentPanelToLeftCache(obj, elementId, true)) {
                    _updatePanelPercentWidth(elementId);
                }
            }
        });
    };

    _dynamicPanelManager.resetFixedPanel = function(obj, domElement) {
        if(obj.fixedHorizontal == 'center') domElement.style.marginLeft = "";
        if(obj.fixedVertical == 'middle') domElement.style.marginTop = "";
    };

    _dynamicPanelManager.resetAdaptivePercentPanel = function(obj, domElement) {
        if(!_isPercentWidthPanel(obj)) return;

        if(obj.fixedHorizontal == 'center') domElement.style.marginLeft = "";
        else if(obj.fixedHorizontal == 'right') domElement.style.width = "";
    };

    var _updatePercentPanelToLeftCache = function(obj, elementId, overwrite) {
        var wasUpdated = false;
        var jObj = $jobj(elementId);
        if(percentPanelToLeftCache[elementId] == undefined || overwrite) {
            if(obj.fixedHorizontal == 'center') percentPanelToLeftCache[elementId] = Number(jObj.css('margin-left').replace("px", ""));
            else if(obj.fixedHorizontal == 'right') percentPanelToLeftCache[elementId] = jObj.width() + Number(jObj.css('right').replace("px", ""));
            else percentPanelToLeftCache[elementId] = Number(jObj.css('left').replace("px", ""));
            wasUpdated = true;
        }

        if(obj.fixedHorizontal == 'right' && _isIdFitToContent(elementId)) {
            var fitWidth = getContainerSize($ax.visibility.GetPanelState(elementId) + '_content').width;
            percentPanelToLeftCache[elementId] = fitWidth + Number(jObj.css('right').replace("px", ""));
            wasUpdated = true;
        }
        return wasUpdated;
    };

    var _updatePanelPercentWidth = _dynamicPanelManager.updatePanelPercentWidth = function(elementId) {
        var obj = $obj(elementId);
        if(!_isPercentWidthPanel(obj)) return;

        _updatePercentPanelToLeftCache(obj, elementId, false);

        var width;
        var x;

        if(obj.fixedHorizontal) {
            x = 0;
            width = $(window).width();
        } else {
            var parentPanelInfo = getParentPanel(elementId);
            if(parentPanelInfo) {
                var parentId = parentPanelInfo.parent;
                width = $jobj(parentId).width();
                var parentObj = $obj(parentId);
                if(parentObj.percentWidth) {
                    var stateId = $ax.repeater.applySuffixToElementId(parentId, '_state' + parentPanelInfo.state);
                    var stateContentId = stateId + '_content';
                    x = -Number($jobj(stateContentId).css('margin-left').replace("px", ""));
                } else x = 0;
            } else {
                var parentRepeater = $ax.getParentRepeaterFromScriptId($ax.repeater.getScriptIdFromElementId(elementId));
                if(parentRepeater) {
                    var itemId = $ax.repeater.getItemIdFromElementId(elementId);
                    var itemContainerId = $ax.repeater.createElementId(parentRepeater, itemId);
                    x = 0;
                    width = $jobj(itemContainerId).width();
                } else {
                    var $window = $(window);
                    width = $window.width();
                    var bodyLeft = Number($('body').css('left').replace("px", ""));
                    var bodyWidth = Number($('body').css('width').replace("px", ""));
                    var isCenter = $ax.adaptive.getPageStyle().pageAlignment == 'center';
                    width = Math.max(width, bodyWidth);
                    x = isCenter ? -(width - bodyWidth) / 2 - bodyLeft : 0;
                }
            }
        }

        var jObj = $jobj(elementId);
        if(obj.fixedHorizontal == 'left') jObj.css('left', x + 'px');
        else if(obj.fixedHorizontal == 'center') {
            jObj.css('left', x + 'px');
            jObj.css('margin-left', 0 + 'px');
        } else jObj.css('left', x + 'px');

        jObj.css('width', width + 'px');

        var panelLeft = percentPanelToLeftCache[elementId];
        var stateChildrenQuery = jObj.children('.panel_state');
        stateChildrenQuery.css('width', width + 'px');

        if(obj.fixedHorizontal == 'center')
            stateChildrenQuery.children('.panel_state_content').css('left', '50%').css('margin-left', panelLeft + 'px');
        else if(obj.fixedHorizontal == 'right')
            stateChildrenQuery.children('.panel_state_content').css('left', width - panelLeft + 'px');
        else stateChildrenQuery.children('.panel_state_content').css('margin-left', panelLeft - x + 'px');
    };

    _dynamicPanelManager.updateAllFitPanels = function() {
        var fitToContent = [];
        $ax('*').each(function(obj, elementId) {
            if(obj.type == 'dynamicPanel' && obj.fitToContent) fitToContent[fitToContent.length] = elementId;
        });
        for(var i = fitToContent.length - 1; i >= 0; i--) {
            var panelId = fitToContent[i];
            var stateCount = $obj(panelId).diagrams.length;
            for(var j = 0; j < stateCount; j++) {
                $ax.dynamicPanelManager.setFitToContentCss(panelId, true);
                _updateFitPanel(panelId, j, true);
            }
        }
    };

    _dynamicPanelManager.setFitToContentCss = function(elementId, fitToContent, oldWidth, oldHeight) {

        if($ax.dynamicPanelManager.isIdFitToContent(elementId) == fitToContent) return;

        var panel = $jobj(elementId);
        var stateCss;
        var scrollbars = $obj(elementId).scrollbars;

        if(fitToContent) {
            panel.attr('style', '');
            stateCss = {};
            stateCss.position = 'relative';
            if(scrollbars != 'none') {
                stateCss.overflow = 'visible';
                stateCss['-webkit-overflow-scrolling'] = 'visible';
            }
            if(scrollbars == 'verticalAsNeeded') {
                stateCss['overflow-x'] = 'visible';
                stateCss['-ms-overflow-x'] = 'visible';
            } else if(scrollbars == 'horizontalAsNeeded') {
                stateCss['overflow-y'] = 'visible';
                stateCss['-ms-overflow-y'] = 'visible';
            }
            panel.children().css(stateCss);
        } else {
            var panelCss = { width: oldWidth, height: oldHeight };
            stateCss = { width: oldWidth, height: oldHeight };
            panelCss.overflow = 'hidden';
            stateCss.position = 'absolute';
            if(scrollbars != 'none') {
                stateCss.overflow = 'auto';
                stateCss['-webkit-overflow-scrolling'] = 'touch';
            }
            if(scrollbars == 'verticalAsNeeded') {
                stateCss['overflow-x'] = 'hidden';
                stateCss['-ms-overflow-x'] = 'hidden';
            } else if(scrollbars == 'horizontalAsNeeded') {
                stateCss['overflow-y'] = 'hidden';
                stateCss['-ms-overflow-y'] = 'hidden';
            }
            panel.css(panelCss);
            panel.children().css(stateCss);
        }
    };

    // TODO: [ben] This should be used in a lot more places...
    var _getPanelJobj = _dynamicPanelManager.getPanelJobj = function(id) {
        // Try for container first
        var container = $jobj(id + '_container');
        return container.length ? container : $jobj(id);
    };

    var _getShownState = function(id) {
        var obj = $obj(id);
        if(!obj || obj.type != 'dynamicPanel') return $jobj(id);

        var children = $jobj(id).children();
        for(var i = 0; i < children.length; i++) {
            var child = children[i];
            if(child && child.style && child.style.display != 'none') return $jobj(child.id);
        }

        return $jobj(id);
    };

    var _getClamp = function(id) {
        var obj = $obj(id);
        if(!obj) return _getPanelJobj(id);
        if(obj.type == 'dynamicPanel') return _getShownState(id);
        return $jobj(id);
    };

    var _updateFitPanel = function(panelId, stateIndex, initializingView) {
        if(!panelId) return false;

        // Only fit if fitToContent is true
        if(!$ax.dynamicPanelManager.isIdFitToContent(panelId)) return false;

        // Traverse through children to find what size it should be.
        var stateId = $ax.repeater.applySuffixToElementId(panelId, '_state' + stateIndex);
        var stateContentId = stateId + '_content';
        var stateQuery = $jobj(stateId);
        var size = getContainerSize(stateContentId);

        // Skip if size hasn't changed
        var oldWidth = stateQuery.width();
        var oldHeight = stateQuery.height();
        if(oldWidth == size.width && oldHeight == size.height) return false;

        if(!$obj(panelId).percentWidth) stateQuery.width(size.width);
        stateQuery.height(size.height);

        //updatePercentWidth on all child panels
        $jobj(stateContentId).children('.ax_dynamic_panel').each(
            function() { _updatePanelPercentWidth(this.id); }
        );

        //do the following only if it is the current state
        if(stateId != $ax.visibility.GetPanelState(panelId)) return false;

        if(!initializingView) _adjustFixed(panelId, oldWidth, oldHeight, size.width, size.height);
        else if(stateIndex != 0) {
            var state0 = $jobj($ax.repeater.applySuffixToElementId(panelId, '_state0'));
            _adjustFixed(panelId, state0.width(), state0.height(), size.width, size.height);
        }

        $ax.event.raiseSyntheticEvent(panelId, 'onResize');
        $ax.flyoutManager.updateFlyout(panelId);

        return true;
    };

    // widgetId is the one that crawls up masters until it finds a parent panel, targetId is the original widgetId (not the crawling master)
    var getParentPanel = function(widgetId, path, targetId) {
        path = path || $ax.getPathFromScriptId($ax.repeater.getScriptIdFromElementId(widgetId));

        var obj = $obj(widgetId);
        if(obj.parentDynamicPanel) {
            path[path.length - 1] = obj.parentDynamicPanel;
            var parentId = $ax.getScriptIdFromPath(path);
            parentId = $ax.repeater.getElementId(parentId, widgetId);
            var parentObj = $obj(parentId);
            var retVal = { parent: parentId };
            for(var i = 0; i < parentObj.diagrams.length; i++) {
                var stateId = $ax.repeater.applySuffixToElementId(parentId, '_state' + i);
                var stateQuery = $jobj(stateId);
                if(stateQuery.find('#' + (targetId || widgetId)).length != 0) {
                    retVal.state = i;
                    break;
                }
            }
            return retVal;
        }

        if(path.length == 1) return undefined;

        path.pop();
        var parentMaster = $ax.getScriptIdFromPath(path);
        parentMaster = $ax.repeater.getElementId(parentMaster, widgetId);

        return getParentPanel(parentMaster, path, targetId || widgetId);
    };

    // TODO: May be a better location for this. Used currently for rdo and panel state containers
    var getContainerSize = function(containerId) {
        var containerQuery = containerId ? $jobj(containerId) : $('#base');
        var children = containerQuery.children();
        // Default size
        var size = { width: 0, height: 0 };
        for(var i = 0; i < children.length; i++) {
            var child = $(children[i]);
            var childId = child.attr('id');

            var childObj = $obj(childId);
            if(!childObj) {
                // On the body there are some children that should be ignored, as they are not objects.
                if(!child.hasClass('basiclink') || child.get(0).tagName.toLowerCase() != 'a') continue;

                // Otherwise it should be a basic link
                var linkChildren = child.children();
                if(!linkChildren.length) continue;
                child = $(linkChildren[0]);
                childId = child.attr('id');
                childObj = $obj(childId);
            }

            if(!childId || $ax.visibility.limboIds[childId] || !$ax.visibility.IsIdVisible(childId)) continue;

            // Ignore fixed
            if(childObj.type == 'dynamicPanel' && childObj.fixedHorizontal) continue;

            var position = { left: Number(child.css('left').replace('px', '')), top: Number(child.css('top').replace('px', '')) };

            // Default width and height (adjusted for widgets that are special)
            var width = child.width();
            var height = child.height();
            if(childObj.type == 'master') {
                var masterSize = getContainerSize(childId);
                width = masterSize.width;
                height = masterSize.height;
                //            } else if(childObj.type == 'repeater') {
                //                var repeaterSize = $ax.repeater.getRepeaterSize(childId);
                //                width = repeaterSize.width;
                //                height = repeaterSize.height;

                //                if(width == 0 && height == 0) continue;

                //                position.left += childObj.x;
                //                position.top += childObj.y;
            } else if(childObj.type == 'dynamicPanel') {
                if($ax.dynamicPanelManager.isIdFitToContent(childId)) {
                    var stateQuery = $jobj($ax.visibility.GetPanelState(childId));
                    width = stateQuery.width();
                    height = stateQuery.height();
                }
            }

            size.width = Math.max(size.width, position.left + width);
            size.height = Math.max(size.height, position.top + height);
        }

        return size;
    };

    var _adjustFixed = _dynamicPanelManager.adjustFixed = function(panelId, oldWidth, oldHeight, width, height) {
        var loc = _getFixedPosition(panelId, oldWidth, oldHeight, width, height);
        if(loc) {
            $ax.action.addAnimation(panelId, function() {
                $ax.move.MoveWidget(panelId, loc[0], loc[1], 'none', 0, false, null, true);
            });
        }
    };

    var _getFixedPosition = _dynamicPanelManager.getFixedPosition = function(panelId, oldWidth, oldHeight, width, height) {
        var panelObj = $obj(panelId);
        var x = 0;
        var y = 0;
        if(panelObj.fixedHorizontal == 'center') {
            x = (oldWidth - width) / 2;
        }
        if(panelObj.fixedVertical == 'middle') {
            y = (oldHeight - height) / 2;
        }
        return x == 0 && y == 0 ? undefined : [x, y];
    };

    _dynamicPanelManager.getFixedInfo = function(panelId) {
        var panelObj = $obj(panelId);
        if(!panelObj || panelObj.type != 'dynamicPanel') return {};
        var jobj = $jobj(panelId);
        if(jobj.css('position') == 'absolute') return {};

        var info = {};
        var horizontal = panelObj.fixedHorizontal;
        if(!horizontal) return info;

        info.fixed = true;
        info.horizontal = horizontal;
        info.vertical = panelObj.fixedVertical;

        if(info.horizontal == 'left') info.x = Number(jobj.css('left').replace('px', ''));
        else if(info.horizontal == 'center') info.x = Number(jobj.css('margin-left').replace('px', ''));
        else if(info.horizontal == 'right') info.x = Number(jobj.css('right').replace('px', ''));

        if(info.vertical == 'top') info.y = Number(jobj.css('top').replace('px', ''));
        else if(info.vertical == 'middle') info.y = Number(jobj.css('margin-top').replace('px', ''));
        else if(info.vertical == 'bottom') info.y = Number(jobj.css('bottom').replace('px', ''));

        return info;
    };

    // Show isn't necessary if this is always done before toggling (which is currently true), but I don't want that
    //  change (if it happened) to break this.
    var _compressToggle = function(id, vert, show, easing, duration) {
        var panelJobj = _getPanelJobj(id);
        var threshold = Number(panelJobj.css(vert ? 'top' : 'left').replace('px', ''));
        var delta = _getShownState(id)[vert ? 'height' : 'width']();

        if(!show) {
            // Need to make threshold bottom/right
            threshold += delta;
            // Delta is in the opposite direction
            delta *= -1;
        }

        _compress(id, vert, threshold, delta, easing, duration);
    };
    _dynamicPanelManager.compressToggle = _compressToggle;

    // Used when setting state of dynamic panel
    var _compressDelta = function(id, oldState, newState, vert, easing, duration) {
        var panelQuery = $jobj(id);
        var oldQuery = $jobj(oldState);
        var newQuery = $jobj(newState);

        var thresholdProp = vert ? 'top' : 'left';
        var thresholdOffset = vert ? 'height' : 'width';
        var threshold = Number(panelQuery.css(thresholdProp).replace('px', ''));
        threshold += oldQuery[thresholdOffset]();

        var delta = newQuery[thresholdOffset]() - oldQuery[thresholdOffset]();

        var clampProp = vert ? 'left' : 'top';
        var clampOffset = vert ? 'width' : 'height';
        var clamp = [Number(panelQuery.css(clampProp).replace('px', ''))];
        clamp[1] = clamp[0] + Math.max(oldQuery[clampOffset](), newQuery[clampOffset]());

        _compress(id, vert, threshold, delta, easing, duration, clamp);
    };
    _dynamicPanelManager.compressDelta = _compressDelta;

    var _compress = function(id, vert, threshold, delta, easing, duration, clamp) {
        if(!easing) {
            easing = 'none';
            duration = 0;
        }
        var parent = $ax('#' + id).getParents()[0];
        var obj = $ax.getObjectFromElementId(parent);
        while(obj && obj.type == 'referenceDiagramObject') {
            parent = $ax('#' + parent).getParents()[0];
            obj = $ax.getObjectFromElementId(parent);
        }

        var clampLoc = _getPanelJobj(id);
        var clampDim = _getClamp(id);

        // If below, a horizantal clamp, otherwise a vertical clamp
        var clampProp = vert ? 'left' : 'top';
        var clampOffset = vert ? 'width' : 'height';
        if(!clamp) {
            clamp = [Number(clampLoc.css(clampProp).replace('px', ''))];
            clamp[1] = clamp[0] + clampDim[clampOffset]();
        }

        // If clamps, threshold, or delta is not a number, can't compress.
        if(isNaN(clamp[0]) || isNaN(clamp[1]) || isNaN(threshold) || isNaN(delta)) return;

        // Note: If parent is body, some of these aren't widgets
        if(parent && $jobj(parent + '_content').length > 0) parent = parent + '_content';
        var children = $(parent ? '#' + parent : '#base').children();
        for(var i = 0; i < children.length; i++) {
            var child = $(children[i]);

            // Check for basic links
            if(child[0] && child[0].tagName == 'A' && child.hasClass('basiclink')) child = child.children();

            var childId = child.attr('id');
            // Don't move self, and check id to make sure it is a widget.
            if(childId == id || !childId || childId[0] != 'u') continue;
            var numbers = childId.substring(1).split('-');
            if(numbers.length < 1 || isNaN(Number(numbers[0])) || (numbers.length == 2 && isNaN(Number(numbers[1]))) || numbers.length > 2) continue;

            var markerProp = vert ? 'top' : 'left';
            var marker = Number(child.css(markerProp).replace('px', ''));

            var childClamp = [Number(child.css(clampProp).replace('px', ''))];

            // Dynamic panels are not reporting correct size sometimes, so pull it from the state. Get shown state just returns the widget if it is not a dynamic panel.
            var sizeChild = _getShownState(childId);
            childClamp[1] = childClamp[0] + sizeChild[clampOffset]();
            if(isNaN(marker) || isNaN(childClamp[0]) || isNaN(childClamp[1]) ||
               marker < threshold || childClamp[1] <= clamp[0] || childClamp[0] >= clamp[1]) continue;

            //marker += delta;

            //var props = {};
            //props[markerProp] = marker;
            $ax('#' + childId).moveBy(vert ? 0 : delta, vert ? delta : 0, easing == 'none' ? {} : { duration: duration, easing: easing });
            //if(easing == 'none') child.css(props);
            //else child.animate(props, duration, easing);
        }
    };

    var _parentHandlesStyles = function(id) {
        var parents = $ax('#' + id).getParents(true)[0];
        if(!parents) return false;
        var directParent = true;
        for(var i = 0; i < parents.length; i++) {
            var parentId = parents[i];
            // Because state parent panel id is the active state, must strip off the end of it.
            var itemId = $ax.repeater.getItemIdFromElementId(parentId);
            parentId = parentId.split('_')[0];
            if(itemId) parentId = $ax.repeater.createElementId(parentId, itemId);
            var parentObj = $obj(parentId);
            if(parentObj.type != 'dynamicPanel') continue;
            if(!parentObj.propagate) {
                directParent = false;
                continue;
            }
            return { id: parentId, direct: directParent };
        }
        return false;
    };
    _dynamicPanelManager.parentHandlesStyles = _parentHandlesStyles;

    var _propagateMouseOver = function(id, value) {
        propagate(id, true, value);
    };
    _dynamicPanelManager.propagateMouseOver = _propagateMouseOver;

    var _propagateMouseDown = function(id, value) {
        propagate(id, false, value);
    };
    _dynamicPanelManager.propagateMouseDown = _propagateMouseDown;

    var propagate = function(id, hover, value) {
        var hoverChildren = function(children) {
            if(!children) return;
            for(var i = 0; i < children.length; i++) {
                var elementId = children[i].id;
                var obj = $obj(elementId);
                if(obj == null) {
                    elementId = elementId.split('_')[0];
                    obj = $obj(elementId);
                }
                if(obj == null) continue;
                if(obj.type == 'dynamicPanel' && !obj.propagate) continue;

                if(hover) $ax.style.SetWidgetHover(elementId, value);
                else $ax.style.SetWidgetMouseDown(elementId, value);
                $ax.annotation.updateLinkLocations($ax.style.GetTextIdFromShape(elementId));

                hoverChildren(children[i].children);
            }
        };
        hoverChildren($ax('#' + id).getChildren(true)[0].children);
    };
});

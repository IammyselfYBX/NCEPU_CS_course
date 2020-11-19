﻿$axure.internal(function($ax) {
    var widgetDragInfo = new Object();
    var _drag = {};
    $ax.drag = _drag;

    $ax.drag.GetWidgetDragInfo = function() {
        return $.extend({}, widgetDragInfo);
    };

    $ax.drag.StartDragWidget = function(event, id) {
        $ax.setjBrowserEvent(jQuery.Event(event));
        if(event.donotdrag) return;

        var x, y;
        var tg;
        if(IE) {
            x = window.event.clientX + window.document.documentElement.scrollLeft + window.document.body.scrollLeft;
            y = window.event.clientY + window.document.documentElement.scrollTop + window.document.body.scrollTop;
            tg = window.event.srcElement;
        } else {
            if(event.changedTouches) {
                x = event.changedTouches[0].pageX;
                y = event.changedTouches[0].pageY;
            } else {
                x = event.pageX;
                y = event.pageY;
                event.preventDefault();
            }
            tg = event.target;
        }

        widgetDragInfo.hasStarted = false;
        widgetDragInfo.widgetId = id;
        widgetDragInfo.cursorStartX = x;
        widgetDragInfo.cursorStartY = y;
        widgetDragInfo.lastX = x;
        widgetDragInfo.lastY = y;
        widgetDragInfo.currentX = x;
        widgetDragInfo.currentY = y;

        widgetDragInfo.movedWidgets = new Object();
        widgetDragInfo.startTime = (new Date()).getTime();
        widgetDragInfo.targetWidget = tg;

        if(IE) {
            if($ax.features.supports.windowsMobile) {
                window.document.attachEvent($ax.features.eventNames.mouseDownName, _dragWidget);
                window.document.attachEvent($ax.features.eventNames.mouseUpName, _stopDragWidget);
            } else {
                window.document.attachEvent('on' + $ax.features.eventNames.mouseMoveName, _dragWidget);
                window.document.attachEvent('on' + $ax.features.eventNames.mouseUpName, _stopDragWidget);
            }
        } else {
            window.document.addEventListener($ax.features.eventNames.mouseMoveName, _dragWidget, true);
            window.document.addEventListener($ax.features.eventNames.mouseUpName, _stopDragWidget, true);
        }
        $ax.legacy.SuppressBubble(event);
    };

    var _dragWidget = function(event) {
        $ax.setjBrowserEvent(jQuery.Event(event));

        var x, y;
        if(IE) {
            x = window.event.clientX + window.document.documentElement.scrollLeft + window.document.body.scrollLeft;
            y = window.event.clientY + window.document.documentElement.scrollTop + window.document.body.scrollTop;
        } else {
            if(event.changedTouches) {
                x = event.changedTouches[0].pageX;
                y = event.changedTouches[0].pageY;
                //allow scroll (defaults) if only swipe events have cases and delta x is less than 5px and not blocking scrolling
                var deltaX = x - widgetDragInfo.currentX;
                var target = window.document.getElementById(widgetDragInfo.widgetId);
                if($ax.event.hasSyntheticEvent(widgetDragInfo.widgetId, "onDrag") || $ax.event.hasSyntheticEvent(widgetDragInfo.widgetId, "onSwipeUp") ||
                    $ax.event.hasSyntheticEvent(widgetDragInfo.widgetId, "onSwipeDown") || (deltaX * deltaX) > 25
                    || ($ax.document.configuration.preventScroll && $ax.legacy.GetScrollable(target) == window.document.body)) {
                    event.preventDefault();
                }
            } else {
                x = event.pageX;
                y = event.pageY;
            }
        }
        widgetDragInfo.xDelta = x - widgetDragInfo.currentX;
        widgetDragInfo.yDelta = y - widgetDragInfo.currentY;
        widgetDragInfo.lastX = widgetDragInfo.currentX;
        widgetDragInfo.lastY = widgetDragInfo.currentY;
        widgetDragInfo.currentX = x;
        widgetDragInfo.currentY = y;

        widgetDragInfo.currentTime = (new Date()).getTime();

        $ax.legacy.SuppressBubble(event);

        if(!widgetDragInfo.hasStarted) {
            widgetDragInfo.hasStarted = true;
            $ax.event.raiseSyntheticEvent(widgetDragInfo.widgetId, "onDragStart");

            widgetDragInfo.oldBodyCursor = window.document.body.style.cursor;
            window.document.body.style.cursor = 'move';
            var widget = window.document.getElementById(widgetDragInfo.widgetId);
            widgetDragInfo.oldCursor = widget.style.cursor;
            widget.style.cursor = 'move';
        }

        $ax.event.raiseSyntheticEvent(widgetDragInfo.widgetId, "onDrag");
    };

    var _suppressClickAfterDrag = function(event) {
        _removeSuppressEvents();

        $ax.legacy.SuppressBubble(event);
    };

    var _removeSuppressEvents = function() {
        if(IE) {
            window.event.srcElement.detachEvent("onclick", _suppressClickAfterDrag);
            widgetDragInfo.targetWidget.detachEvent("onmousemove", _removeSuppressEvents);
        } else {
            window.document.removeEventListener("click", _suppressClickAfterDrag, true);
            window.document.removeEventListener("mousemove", _removeSuppressEvents, true);
        }
    };

    var _stopDragWidget = function(event) {
        $ax.setjBrowserEvent(jQuery.Event(event));

        var tg;
        if(IE) {
            if($ax.features.supports.windowsMobile) {
                window.document.detachEvent($ax.features.eventNames.mouseDownName, _dragWidget);
                window.document.detachEvent($ax.features.eventNames.mouseUpName, _stopDragWidget);

            } else {
                window.document.detachEvent('on' + $ax.features.eventNames.mouseMoveName, _dragWidget);
                window.document.detachEvent('on' + $ax.features.eventNames.mouseUpName, _stopDragWidget);
            }
            tg = window.event.srcElement;
        } else {
            window.document.removeEventListener($ax.features.eventNames.mouseMoveName, _dragWidget, true);
            window.document.removeEventListener($ax.features.eventNames.mouseUpName, _stopDragWidget, true);
            tg = event.target;
        }

        if(widgetDragInfo.hasStarted) {
            widgetDragInfo.currentTime = (new Date()).getTime();
            $ax.event.raiseSyntheticEvent(widgetDragInfo.widgetId, "onDragDrop");

            if($ax.globalVariableProvider.getVariableValue('totaldragx') < -30 && $ax.globalVariableProvider.getVariableValue('dragtime') < 1000) {
                $ax.event.raiseSyntheticEvent(widgetDragInfo.widgetId, "onSwipeLeft");
            }

            if($ax.globalVariableProvider.getVariableValue('totaldragx') > 30 && $ax.globalVariableProvider.getVariableValue('dragtime') < 1000) {
                $ax.event.raiseSyntheticEvent(widgetDragInfo.widgetId, "onSwipeRight");
            }

            var totalDragY = $ax.globalVariableProvider.getVariableValue('totaldragy');
            if(totalDragY < -30 && $ax.globalVariableProvider.getVariableValue('dragtime') < 1000) {
                $ax.event.raiseSyntheticEvent(widgetDragInfo.widgetId, "onSwipeUp");
            }

            if(totalDragY > 30 && $ax.globalVariableProvider.getVariableValue('dragtime') < 1000) {
                $ax.event.raiseSyntheticEvent(widgetDragInfo.widgetId, "onSwipeDown");
            }

            window.document.body.style.cursor = widgetDragInfo.oldBodyCursor;
            var widget = window.document.getElementById(widgetDragInfo.widgetId);
            // It may be null if OnDragDrop filtered out the widget
            if(widget != null) widget.style.cursor = widgetDragInfo.oldCursor;

            if(widgetDragInfo.targetWidget == tg && !event.changedTouches) {
                // suppress the click after the drag on desktop browsers
                if(IE && widgetDragInfo.targetWidget) {
                    widgetDragInfo.targetWidget.attachEvent("onclick", _suppressClickAfterDrag);
                } else {
                    window.document.addEventListener("click", _suppressClickAfterDrag, true);
                }

                if(IE && widgetDragInfo.targetWidget) {
                    widgetDragInfo.targetWidget.attachEvent("onmousemove", _removeSuppressEvents);
                } else {
                    window.document.addEventListener("mousemove", _removeSuppressEvents, true);
                }
            }
        }

        widgetDragInfo.hasStarted = false;
        widgetDragInfo.movedWidgets = new Object();

        return false;
    };

    $ax.drag.GetDragX = function() {
        if(widgetDragInfo.hasStarted) return widgetDragInfo.xDelta;
        return 0;
    };

    $ax.drag.GetDragY = function() {
        if(widgetDragInfo.hasStarted) return widgetDragInfo.yDelta;
        return 0;
    };

    $ax.drag.GetTotalDragX = function() {
        if(widgetDragInfo.hasStarted) return widgetDragInfo.currentX - widgetDragInfo.cursorStartX;
        return 0;
    };

    $ax.drag.GetTotalDragY = function() {
        if(widgetDragInfo.hasStarted) return widgetDragInfo.currentY - widgetDragInfo.cursorStartY;
        return 0;
    };

    $ax.drag.GetDragTime = function() {
        if(widgetDragInfo.hasStarted) return widgetDragInfo.currentTime - widgetDragInfo.startTime;
        return 600000;
    };

    //    $ax.drag.GetCursorRectangles = function() {
    //        var rects = new Object();
    //        rects.lastRect = new Rectangle($ax.lastMouseLocation.x, $ax.lastMouseLocation.y, 1, 1);
    //        rects.currentRect = new Rectangle($ax.mouseLocation.x, $ax.mouseLocation.y, 1, 1);
    //        return rects;
    //    };

    //    $ax.drag.GetWidgetRectangles = function(id) {
    //        var widget = window.document.getElementById(id);
    //        var rects = new Object();
    //        rects.lastRect = new Rectangle($ax.legacy.getAbsoluteLeft(widget), $ax.legacy.getAbsoluteTop(widget), Number($('#' + id).css('width').replace("px", "")), Number($('#' + id).css('height').replace("px", "")));
    //        rects.currentRect = rects.lastRect;
    //        return rects;
    //    };

    //    $ax.drag.IsEntering = function(movingRects, targetRects) {
    //        return !movingRects.lastRect.IntersectsWith(targetRects.currentRect) && movingRects.currentRect.IntersectsWith(targetRects.currentRect);
    //    };

    //    $ax.drag.IsLeaving = function(movingRects, targetRects) {
    //        return movingRects.lastRect.IntersectsWith(targetRects.currentRect) && !movingRects.currentRect.IntersectsWith(targetRects.currentRect);
    //    };

    //    function IsOver(movingRects, targetRects) {
    //        return movingRects.currentRect.IntersectsWith(targetRects.currentRect);
    //    }

    //    function IsNotOver(movingRects, targetRects) {
    //        return !IsOver(movingRects, targetRects);
    //    }

    $ax.drag.LogMovedWidgetForDrag = function(id) {
        if(widgetDragInfo.hasStarted) {
            var widget = $('#' + id);
            var y = Number(widget.css('top').replace("px", ""));
            var x = Number(widget.css('left').replace("px", ""));
            var movedWidgets = widgetDragInfo.movedWidgets;
            if(!movedWidgets[id]) {
                movedWidgets[id] = new Location(x, y);
            }
        }
    };

    var Location = function(x, y) {
        this.x = x;
        this.y = y;
    };
    $ax.drag.location = Location;

    var Rectangle = $ax.drag.Rectangle = function(x, y, width, height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.right = x + width;
        this.bottom = y + height;
    };

    Rectangle.prototype.IntersectsWith = function(rect) {
        if(this.Invalid()) return false;
        if(rect.length) {
            for(var i = 0; i < rect.length; i++) if(!rect[i].Invalid && this.IntersectsWith(rect[i])) return true;
            return false;
        }
        if(rect.Invalid()) return false;
        return this.x < rect.right && this.right > rect.x && this.y < rect.bottom && this.bottom > rect.y;
    };

    Rectangle.prototype.Invalid = function() {
        return this.x == -1 && this.y == -1 && this.width == -1 && this.height == -1;
    };

    Rectangle.prototype.Move = function(x, y) {
        return new Rectangle(x, y, this.width, this.height);
    };
});
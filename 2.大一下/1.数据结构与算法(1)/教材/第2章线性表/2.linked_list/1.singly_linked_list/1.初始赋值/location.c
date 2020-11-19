/*
* Copyright (c) 2019,YBX is the most handsome man in NCEPU
* All rights reserved.
*
* 文件名称: location.c
* 文件标识: 见README.md
* 摘要: 定位某元素在链表的位置
*
* 当前版本: 1.1
* 作者: 杨秉学
* 完成日期: 2019年5月2日
*
* 取代版本:1.0
* 原作者: 杨秉学
* 完成日期: 2018年4月10日
*/

#include "singly_linked.h"

int linklist_location(LinkList L, char *name)
{
    LinkList p = L->next;
    int i = 1;
    while(p)
    {
        if(strcmp(p->data.name, name)){
            p = p->next;
            i++;
        }else{
            return i;
        }
    }
    if(p == NULL){
        return 0;
    }
}
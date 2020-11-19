/*
* Copyright (c) 2019,YBX is the most handsome man in NCEPU
* All rights reserved.
*
* 文件名称: display.c
* 文件标识: 见README.md
* 摘要: 遍历整个顺序表
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

int linklist_display(LinkList L)
{
    LinkList p = L->next;
    if(p == NULL){
        printf("没有数据\n");
        return 0;
    }
    while (p)
    {
        printf("name:%s\t score:%d\n", p->data.name, p->data.score);
        p = p->next;
    }
    
    return 1;
}
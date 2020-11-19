/*
* Copyright (c) 2019,YBX is the most handsome man in NCEPU
* All rights reserved.
*
* 文件名称: insert.c
* 文件标识: 见README.md
* 摘要: 在指定位置对但链表进行插入
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

int linklist_insert(LinkList *L, int i, Elemtype e)
{
    LinkList s ,p = *L;
    int position = 0;
    while(p!=NULL && position < i-1){
        p = p->next;
        position++;
    } 
    if(p == NULL || position>i-1){
        printf("插入位置异常\n");
        return 0;
    }
    s = (LinkList)malloc(sizeof(LNode));
    s->data = e;
    s->next = p->next;
    p->next = s;
    printf("插入成功\n");
    return 1;
}
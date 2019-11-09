/*
* Copyright (c) 2019,YBX is the most handsome man in NCEPU
* All rights reserved.
*
* 文件名称: delect.c
* 文件标识: 见README.md
* 摘要: 删除指定位置的元素
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

int linklist_delete(LinkList *L, int i, Elemtype *e)
{
    LinkList q, p= *L;
    int position = 0;
    while (p->next != NULL && position < i-1)
    {
        p = p->next;
        position++;
    }
    if(p->next == NULL || position> i-1)
    {
        printf("位置删除异常\n");
        return 0;
    }
    q = p->next;
    p->next = q->next;
    *e = q->data;
    free(q);
    printf("删除成功！\n");
    return 1;
}
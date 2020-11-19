/*
* Copyright (c) 2019,YBX is the most handsome man in NCEPU
* All rights reserved.
*
* 文件名称: initialization.c
* 文件标识: 见README.md
* 摘要: 初始化整个链表
*
* 当前版本: 1.1
* 作者: 杨秉学
* 完成日期: 2019年5月2日
*
* 取代版本:1.0
* 原作者: 杨秉学
* 完成日期: 2018年4月10日
*/

#include <stdio.h>
#include <malloc.h>
#include "singly_linked.h"

int linklist_init(LinkList *L)
{
    *L = (LinkList)malloc(sizeof(LNode));
    if(*L == NULL){
        printf("空间申请失败！\n");
        return 0;
    }
    (*L)->next = NULL;
    printf("初始化成功！\n");

    return 1;
}
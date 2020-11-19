/*
* Copyright (c) 2019,YBX is the most handsome man in NCEPU
* All rights reserved.
*
* 文件名称: init_sqlist.c
* 文件标识: 见README.md
* 摘要: 初始化整个顺序表
*
* 当前版本: 1.1
* 作者: 杨秉学
* 完成日期: 2019年5月2日
*
* 取代版本:1.0
* 原作者: 杨秉学
* 完成日期: 2018年4月10日
*/

//initialization
#include <malloc.h>
#include "static_sequence.h"

int init_sqlist(sq_list *L, int max)
{
    L->data = (Elemtype *)malloc(max*sizeof(Elemtype));
    if(L->data == NULL){
        printf("空间申请失败！\n");
        return 0;
    }
    L->listsize = max;
    L->length = 0;
    printf("初始化成功！\n");
    return 1;
}
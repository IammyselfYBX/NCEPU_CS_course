/*
* Copyright (c) 2019,YBX is the most handsome man in NCEPU
* All rights reserved.
*
* 文件名称: insert.c
* 文件标识: 见README.md
* 摘要: 在指定位置对顺序表进行插入
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
#include "static_sequence.h"

int list_insert(sq_list *L, int i, Elemtype e)
{
    if(i<1||i>L->length+1){
        printf("插入位置异常\n");
        return 0;
    }
    if(L->length>=MaxSize){
        printf("容量不足\n");
        return 0;
    }
    for(int j = L->length; j>=i; j--){
        L->data[j] = L->data[j-1];
    }
    L->data[i-1] = e;
    L->length++;
    printf("插入成功\n");
    return 1;
}
/*
* Copyright (c) 2019,YBX is the most handsome man in NCEPU
* All rights reserved.
*
* 文件名称: update.c
* 文件标识: 见README.md
* 摘要: 对顺序表指定位置进行更新操作
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

int list_updata(sq_list *L, int i, Elemtype e)
{
    if(L->length == 0)
    {
        printf("没有数据，不能更新\n");
        return 0;
    }
    if(i<1||i>L->length)
    {
        printf("位置不正确\n");
        return 0;
    }
    L->data[i-1] = e;
    printf("更新成功\n");
    return 1;
}
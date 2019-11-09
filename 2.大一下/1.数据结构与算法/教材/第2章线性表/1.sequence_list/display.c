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

#include <stdio.h>
#include "static_sequence.h"

int list_display(sq_list L)
{
    int i;
    if(L.length == 0){
        printf("没有数据\n");
        return 0;
    }
    for(i =0; i<L.length; i++){
        printf("The %d element is %s %d\n", i+1, L.data[i].name, L.data[i].score);
    }

    return 1;    
}
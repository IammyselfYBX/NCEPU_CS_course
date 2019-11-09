/*
* Copyright (c) 2019,YBX is the most handsome man in NCEPU
* All rights reserved.
*
* 文件名称: static_sequence.h
* 文件标识: 见README.md
* 摘要: 动态定义顺序表的Elemtype，顺序表结构，以及操作的函数
*
* 当前版本: 1.1
* 作者: 杨秉学
* 完成日期: 2019年5月2日
*
* 取代版本:1.0
* 原作者: 杨秉学
* 完成日期: 2018年4月10日
*/

//definde dynamic sequence
#define InitSize 100    //
typedef struct sq_list
{
    int  *data;
    int MaxSize, length;
}sq_list;
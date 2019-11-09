/*
* Copyright (c) 2019,YBX is the most handsome man in NCEPU
* All rights reserved.
*
* 文件名称: static_sequence.h
* 文件标识: 见README.md
* 摘要: 静态定义顺序表的Elemtype，顺序表结构，以及操作的函数
*
* 当前版本: 1.1
* 作者: 杨秉学
* 完成日期: 2019年5月2日
*
* 取代版本:1.0
* 原作者: 杨秉学
* 完成日期: 2018年4月10日
*/

//define static sequence
#define MaxSize 50
//#define Elemtype int      //take an integer
typedef struct STD          //take STD to Elemtype
{
    char name[20];
    int score;
}Elemtype;          //实际上应该写STD，但是为了规范，写Elemtype

typedef struct sq_list{
    Elemtype *data;  
    int listsize;           //存放数组容量
    int length;             //存放实际的数组元素个数
}sq_list;

//function
int init_sqlist(sq_list *L, int max); //
int list_insert(sq_list *L, int i, Elemtype e);
int list_delect(sq_list *L, int i, Elemtype *e);
int list_get(sq_list L, int i, Elemtype *e);
int list_updata(sq_list *L, int i, Elemtype e);
int list_display(sq_list L);
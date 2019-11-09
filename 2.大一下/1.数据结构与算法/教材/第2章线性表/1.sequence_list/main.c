/*
* Copyright (c) 2019,YBX is the most handsome man in NCEPU
* All rights reserved.
*
* 文件名称: main.c
* 文件标识: 见README.md
* 摘要: 实现将顺序表的初始化、插入、查找、更新、删除操作的整合的主函数
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
#include <string.h>
#include "static_sequence.h"

int main()
{
    sq_list L;
    
    printf("--------------Initialization------------------\n");
    init_sqlist(&L, 10);
    printf("L.length = %d L.listsize = %d\n",L.length, L.listsize);
    
    printf("\n--------------Insert------------------\n");
    Elemtype x;
    strcpy(x.name,"YBX");
    x.score=98;
    list_insert(&L, 1, x);
    printf("L.length = %d L.listsize = %d\n",L.length, L.listsize);
    printf("%s %d\n",L.data[0].name, L.data[0].score);

    Elemtype y;
    strcpy(y.name,"ybx");
    y.score=100;
    list_insert(&L, 2, y);
    printf("L.length = %d L.listsize = %d\n",L.length, L.listsize);
    printf("%s %d\n",L.data[1].name, L.data[1].score);

    Elemtype z;
    strcpy(z.name,"Ybx");
    z.score=99;
    list_insert(&L, 3, z);
    printf("L.length = %d L.listsize = %d\n",L.length, L.listsize);
    printf("%s %d\n",L.data[2].name, L.data[2].score);

    printf("\n-------------------Update--------------------------\n");
    Elemtype a;
    strcpy(a.name,"ybx_YBX");
    a.score=89;
    list_updata(&L, 2, a);
    printf("After Update :%s %d\n",L.data[1].name, L.data[1].score);

    printf("\n--------------------Search----------------------------\n");
    Elemtype b;
    list_get(L, 3, &b);
    printf("You get the element is %s %d\n", b.name, b.score);

    printf("\n--------------------Delect-----------------------\n");
    Elemtype e;
    list_delect(&L, 5, &e);
    list_delect(&L, 2, &e);
    printf("%s %d\n", e.name, e.score);
    printf("L.length = %d L.listsize = %d\n",L.length, L.listsize);

    printf("\n---------------display-----------------------------\n");
    list_display(L);

    return 1;
}
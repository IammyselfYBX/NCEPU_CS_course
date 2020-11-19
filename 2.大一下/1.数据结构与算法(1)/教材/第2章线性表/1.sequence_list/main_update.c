/*
* Copyright (c) 2019,YBX is the most handsome man in NCEPU
* All rights reserved.
*
* 文件名称: main_update.c
* 文件标识: 见README.md
* 摘要: 实现将顺序表的初始化、插入、查找、更新、删除操作的整合的主函数
*       这个是main.c的升级版，可以让用户进行输入输出
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
    Elemtype x;
    int n;
    char yn;
    
    printf("--------------Initialization------------------\n");
    init_sqlist(&L, 100);
    do{
        printf("请输入第%d个学生的姓名与分数,用空格隔开\n",n+1);
        scanf("%s%d",x.name, &x.score);
        getchar();

        list_insert(&L, n+1, x);
        n++;
        printf("继续输入吗? Y/N");
        yn = getchar();
    }while (yn =='Y' || yn == 'y')

    printf("L.length = %d L.listsize = %d\n",L.length, L.listsize);
    
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


    return 1;
}
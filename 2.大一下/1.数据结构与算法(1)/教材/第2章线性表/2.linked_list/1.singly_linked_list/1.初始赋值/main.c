/*
* Copyright (c) 2019,YBX is the most handsome man in NCEPU
* All rights reserved.
*
* 文件名称: main.c
* 文件标识: 见README.md
* 摘要: 实现对但链表的初始化、插入、查找、更新、删除操作的整合的主函数
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

int main(int argc, char *argv[])
{
    printf("\n---------------------------------------------------\n");
    printf("|                    单向链表                      |\n");
    printf("|                              计算1702班 杨秉学   |\n");
    printf("|       YBX is the most handsome man in NCEPU      |\n");
    printf("---------------------------------------------------\n");
    LinkList L;
    printf("--------------Initialization----------------------\n");
    linklist_init(&L);

    printf("\n-----------------Insert--------------------------\n");
    Elemtype x;
    strcpy(x.name,"YBX");
    x.score=98;
    linklist_insert(&L, 1, x);

    Elemtype y;
    strcpy(y.name,"ybx");
    y.score=100;
    linklist_insert(&L, 2, y);

    Elemtype z;
    strcpy(z.name,"Ybx");
    z.score=99;
    linklist_insert(&L, 3, z);

    int i = get_length(L);
    printf("The length of Linklist is %d \n", i);
    linklist_display(L);

    printf("\n--------------------Search-----------------------------\n");
    Elemtype b;
    linklist_get(L, 1, &b);
    printf("The first element is name:%s score:%d\n", b.name, b.score);
    linklist_get(L, 2, &b);
    printf("The second element is name:%s score:%d\n", b.name, b.score);
    linklist_get(L, 3, &b);
    printf("The third element is name:%s score:%d\n", b.name, b.score);

    printf("\n------------------location--------------------------\n");
    i = linklist_location(L, "ybx");
    if(0 != i){
        printf("You want locat element 'YBX' is %d \n", i);
    }else{
        printf("Can't location\n");
    }
    char s[50];
    strcpy(s, "YBX is the most hangsome man in NCEPU");
    i = linklist_location(L, s);
    if(0 != i){
        printf("You want locat element 'YBX' is %d \n", i);
    }else{
        printf("Can't location '%s'\n", s);
    }
    
    printf("\n------------------Update--------------------------\n");
    Elemtype a;
    strcpy(a.name,"ybx_YBX");
    a.score=89;
    linklist_update(&L, 2, a);
    linklist_get(L, 2, &b);
    printf("The second element after update is name:%s score:%d\n", b.name, b.score);

    printf("\n--------------------Delect-------------------------\n");
    Elemtype e;
    linklist_delete(&L, 2, &e);
    printf("name: %s\t score:%d\n", e.name, e.score);
    i = get_length(L);
    printf("The length of Linklist is %d \n", i);
    linklist_display(L);

    return 1;
}
/*
 * Function:添加顶点
 * */
#include "Graph.h"
#include <stdio.h>

int addvex(NetGraph *G)
{
    int remain=MAX_VEXTEX_NUM-G->vex_num;
    int increase_vexs=0;
    printf("请输入添加结点数目n(其中n不能超过%d):", remain);
    scanf("%d", &increase_vexs);
    getchar();
    if(increase_vexs>remain || increase_vexs <0)
    {
        printf("对不起，你输入有误!!!\n");
        return -1;
    }

    int tmp = G->vex_num+increase_vexs;

    // 对角线的部分初始化为0
    for (int i = G->vex_num; i < tmp; i++) {
        printf("请输入第%d个结点名称:",i+1);
        scanf("%c",&G->vexs[i]);
        getchar();
        G->arcs[i][i].adj = 0;
    }

    G->vex_num = tmp;

    return 0;
}


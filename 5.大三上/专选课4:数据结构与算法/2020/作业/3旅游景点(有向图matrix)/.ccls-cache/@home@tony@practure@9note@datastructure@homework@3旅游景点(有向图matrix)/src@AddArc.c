/*
 * Function:添加边
 * Author：杨秉学
 * */  

#include "Graph.h"
#include <stdio.h>

int addarc(NetGraph *G)
{
    int increase_arc=0;
    int ves=G->vex_num;
    int max_arc=ves*(ves-1);  //有向图最多有 n(n-1) 条边

    int remain_arc = max_arc - G->arc_num;
    printf("请输入要添加的边数目(不能超过%d): ", remain_arc);
    scanf("%d",&increase_arc);
    getchar();

    if(increase_arc > max_arc || increase_arc <0)
    {
        printf("对不起，你输入有误!!!\n");
        return -1;
    }

    int vex_a, vex_b, w;
    for (int i = 0; i < increase_arc; i++) {
        printf("请输入存在边的两端顶点<Vi,Vj> 和 权值 w: ");
        scanf("%d%d%d",&vex_a, &vex_b, &w);
        G->arcs[vex_a-1][vex_b-1].adj = w;
    }

    G->arc_num += increase_arc;
    
    return 0;
}

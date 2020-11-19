/*
 * Function:创建有向图的邻接矩阵
 * Author：杨秉学
 * */

#include "Graph.h"
#include <stdio.h>

void creat_graph(NetGraph *ga)
{
    int tmp_ves_max=MAX_VEXTEX_NUM;
    int tmp_arc_max=tmp_ves_max*(tmp_ves_max-1);
    printf("输入顶点数和边数(顶点数0~%d,边数0~%d): ", tmp_ves_max, tmp_arc_max);
    scanf("%d%d", &ga->vex_num,&ga->arc_num);    
    fflush(stdin);

    //输入顶点编号
    printf("==============================\n");
    printf("输入各个顶点:\n");
    for (int i = 0; i < ga->vex_num; i++) {
        getchar();
        printf("请输入第%d个结点名称:", i+1);
        scanf("%c",&ga->vexs[i]);
    }

    //初始化 整个邻接矩阵都为无穷大
    for(int i=0; i<MAX_VEXTEX_NUM; i++)
    {
        for(int j=0; j<MAX_VEXTEX_NUM; j++)
        {
            ga->arcs[i][j].adj = INFINITY;
        }
    }

    //矩阵对角线的元素都为0
    for (int i = 0; i < ga->vex_num; i++) {
        ga->arcs[i][i].adj = 0;
    }

    //输入边
    printf("==============================\n");
    int vex_a, vex_b, w;
    for (int i = 0; i < ga->arc_num; i++) {
        printf("请输入存在边的两端顶点<Vi,Vj> 和 权值 w: ");
        scanf("%d%d%d",&vex_a, &vex_b, &w);
        ga->arcs[vex_a-1][vex_b-1].adj = w;
    }
}

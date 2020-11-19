/*
 * Function:显示图的邻接矩阵存储
 * Author:杨秉学
 * */
#include "Graph.h"
#include <stdio.h>

void DisNetGraph(NetGraph *G)
{
    int i, j, k;
    k = G->vex_num;
    char *tmp="∞";
    //先打印第一行标题栏
    printf("%6c",'|');
    for (int i = 0; i < k; i++) {
        printf("%5c ", G->vexs[i]);
    }
    putchar('\n');

    // 打印第二行分割符号
    // -----┼--------------
    for (int i = 0; i < 5; i++) {
        printf("-");
    }
    printf("┼");
    for (int i = 0; i < 6*k; i++) {
        printf("-");
    }
    putchar('\n');

    //遍历矩阵
    for (i=0; i<k; ++i)
    {
        printf("%5c|", G->vexs[i]);
        for (j=0; j<k; ++j)
        {
            if(G->arcs[i][j].adj==INFINITY)
            {
                printf("%7s ",tmp);
            }else{
                printf("%5d ", G->arcs[i][j].adj);
            }
        }
        putchar('\n');
    }
}


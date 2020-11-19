/*
 * Function:实现 Floyd 算法
 * Author:杨秉学
 * */
#include "Graph.h"
#include <stdio.h>

typedef int path_vex[MAX_VEXTEX_NUM]; //存放两结点之间路径 经过的全部结点

void floyd(NetGraph G)
{
    int dist[MAX_VEXTEX_NUM][MAX_VEXTEX_NUM];
    path_vex path[MAX_VEXTEX_NUM][MAX_VEXTEX_NUM];

    // 对dist[] path[][] 初始化
    for (int i = 0; i < G.vex_num; i++) {
        for (int j = 0; j < G.vex_num; j++) {
            dist[i][j] = G.arcs[i][j].adj;
            for (int k = 0; k < G.vex_num; k++) {
                path[i][j][k] = -1;
            }
        }
    }

    // 存放初始化路径
    for (int i = 0; i < G.vex_num; i++) {
        for (int j = 0; j < G.vex_num; j++) {
            if(dist[i][j] != INFINITY && dist[i][j] != 0)
            {
                path[i][j][0]=i;
                path[i][j][1]=j;
            }
        }
    }

    int m=0,n=0;
    char *tmp="∞";
    for (int k = 0; k < G.vex_num; k++) {
        for (int i = 0; i < G.vex_num; i++) {
            for (int j = 0; j < G.vex_num; j++) {
                if(dist[i][k]+dist[k][j] < dist[i][j])
                {
                    dist[i][j] = dist[i][k]+dist[k][j];
                    // 将path[i][k] 中存放的路径存入 path[i][j]
                    for (m = 0; m < G.vex_num && path[i][k][m] != -1; m++) {
                        path[i][j][m] = path[i][k][m];
                    }
                    // 将path[k][j] 中存放的路径存入 path[i][j]
                    for (n = 1; n < G.vex_num ; m++, n++) {
                        path[i][j][m] = path[j][k][n];
                    }
                }
            }
        }
        
        // 验证结果是否正确
        printf("\ndist 第%d次迭代结果\n", k+1);
        for (m = 0; m < G.vex_num; m++) {
            for (n = 0; n < G.vex_num; n++) {
                if(dist[m][n]!=INFINITY){
                    printf("%6d", dist[m][n]);
                }else{
                    printf("%7s ",tmp);
                }
            }
            printf("\n");
        }

        printf("\npath 第%d次迭代结果\n", k+1);
        for (int i = 0; i < G.vex_num; i++) {
            for (int j = 0; j < G.vex_num; j++) {
                for (m = 0; path[i][j][m]!=-1; m++) {
                    printf("%c->", G.vexs[path[i][j][m]]);
                }
                if(m != 0)
                    printf("\b\b    ");
                printf("\t");
            }
            printf("\n");
        }
    }
}


/*
 * Function:实现 Prim算法
 * Author:杨秉学
 * */
#include "Graph.h"
#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>

/*
 * Prim算法描述
 *   好像只能打印有向图的 连通分量 的一个MST
 *    1.辅助数组初始化，把第一个点的邻接矩阵拷贝到辅助数组，将第一个顶点并入U集
 *      辅助数组结构：
 *      //Prim算法中的辅助信息
        struct LowCost{
            VertexType vi;          //存放最短路径的出发节点结点
            VertexType vj;     // 存放 待选顶点 的下标
            EdgeType   lowcost;         //最短路径
        };
        
        struct LowCost lowcost[MAX_VERTEX_NUM];
 *    2.选择其余G.vexnum - 1个顶点，并选择最小代价的边
 *    3.输出路径与权值，将mincost并入U集
 *    4.如果有更小的边，把小的替换原来的
 * */

/*
 * 一维结构体数组 lowcost
 */
typedef struct 
{
    int vi;     // 存放生成树上顶点的下标
    int vj;     // 存放 待选顶点 的下标
    int weight; // 存放 待选边 的权值
}LowCost;

void prim(NetGraph G)
{
    int mincost=0, tmp;
    // 创建 lowcost 数组
    LowCost *lowcost=(LowCost *)malloc(sizeof(LowCost)*G.vex_num);

    // 初始化
    //从序号0的顶点开始生成最小生成树
    for (int i = 0; i < G.vex_num; i++) {
        lowcost[i].vi=0;
        lowcost[i].vj=i;
        lowcost[i].weight=G.arcs[0][i].adj;
    }
    lowcost[0].weight=0;

    // 找最小的权值和当前最小权值的和
    for (int i = 0; i < G.vex_num; i++) {
        mincost=INFINITY;
        for (int j = 0; j < G.vex_num; j++) {
            if(lowcost[j].weight<mincost && lowcost[j].weight !=0)
            {
                mincost = lowcost[j].weight;
                tmp=j;
            }
        }

        // 输出生成树上一条边
        if(mincost != INFINITY){
            printf("%c->%c %d\n", G.vexs[lowcost[tmp].vi], G.vexs[lowcost[tmp].vj], mincost);
        }
        lowcost[tmp].weight=0;
        // 更新权值
        for (int j = 0; j < G.vex_num; j++) {
            if (G.arcs[tmp][j].adj < lowcost[j].weight) {
                lowcost[j].weight=G.arcs[tmp][j].adj;
                lowcost[j].vi=tmp;
            }
        }
    }
    // 使用完释放内存
    free(lowcost);
}











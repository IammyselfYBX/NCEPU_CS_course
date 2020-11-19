#include "Stack.h"
#include "Queue.h"
//图的邻接矩阵表示
#define MAX_VEXTEX_NUM 20 //最大顶点数
typedef int VRType;
typedef char VertexType;

/*===================================================================================
 * 定义图结构
 *==================================================================================
*/
//有向边的结构
typedef struct
{
    VRType adj; //用1或0表示是否相邻
}GraphArc, AdjMatrix[MAX_VEXTEX_NUM][MAX_VEXTEX_NUM];

//图的定义
typedef struct {
    VertexType vexs[MAX_VEXTEX_NUM]; //顶点信息
    AdjMatrix arcs;    //邻接矩阵
    int vex_num, arc_num;   //顶点数、弧数
}NetGraph;

/*==============================================================================
 * 定义图操作
 *==============================================================================
 * */
void creat_graph(NetGraph *ga); //创建邻接矩阵
void DisNetGraph(NetGraph *G);  // 打印图存储结构

int addvex(NetGraph *G);  //添加顶点
int addarc(NetGraph *G);  //添加边

/*
 * 图的深度优先遍历
 */
// 递归遍历
void DFS_recursion(NetGraph G, int i);
void DFSTraverse_recursion(NetGraph G);
// 非递归深度遍历
void DFS(NetGraph G, int i, Stack *s);
void DFSTraverse(NetGraph G);

/*
 * 图的广度优先遍历
 */
void BFSTraverse(NetGraph *G);

/*
 * MST
 * */
//Prim 算法
void prim(NetGraph G);
//Kruskal 算法
typedef char ZFC[MAX_VEXTEX_NUM];
int find(ZFC *s, int n, char c); //判断顶点属于那个连通分量
void Kruskal(NetGraph G);

// 最短路径
void dijkstra(NetGraph G, int v);
void floyd(NetGraph G);

// 打印 图中两顶点 之间全部 最短路径
// void SimplePath(NetGraph G, int i, int j);
// void DFS_Path(NetGraph G, int i, int j, int on[]);

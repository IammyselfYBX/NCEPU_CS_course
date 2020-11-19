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


//用于深度与广度遍历
// #define TRUE   1
// #define FALSE  0
// typedef int Bool;
// #define INFINITY    65535        //表示∞
// //Bool visited[MaxSize];  //全局数组,记录图中节点访问状态
// //广度优先遍历需要的循环队列
// typedef struct {
//     int    data[MAX_VEXTEX_NUM];
//     int    front, rear;
// }Queue;
// 队列操作
// void InitQueue(Queue *Q);
// void EnQueue(Queue *Q, int e);
// Bool QueueEmpty(Queue *Q);
// void DeQueue(Queue *Q, int *e);

// 非递归深度遍历
//===================链栈====================== 
// typedef struct Node{
//     int data;           //数据
//     struct Node* next;  //指针
// }Node;
// typedef struct Stack{	 
//     Node* top;
//     Node* bottom;
// }Stack;
// void InitStack(Stack *s);
// Stack* push(Stack * s,int a);
// int pop(Stack * s);
// Bool Isempty(Stack *s);


    




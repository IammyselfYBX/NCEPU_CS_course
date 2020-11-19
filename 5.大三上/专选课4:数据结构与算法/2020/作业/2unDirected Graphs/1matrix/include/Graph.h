
//图的邻接矩阵表示
#define MAX_VEXTEX_NUM 20 //最大顶点数
typedef int VRType;
typedef char VertexType;

//边
typedef struct
{
    VRType adj; //用1或0表示是否相邻
}GraphArc, AdjMatrix[MAX_VEXTEX_NUM][MAX_VEXTEX_NUM];

//图的定义
typedef struct {
    VertexType vexs[MAX_VEXTEX_NUM]; //顶点信息
    AdjMatrix arcs;    //邻接矩阵
    int vex_num, arc_num;   //顶点数、弧数
}MGraph;

//用于深度与广度遍历
#define TRUE   1
#define FALSE  0
typedef int Bool;
#define INFINITY    65535        //表示∞
//Bool visited[MaxSize];  //全局数组,记录图中节点访问状态
//广度优先遍历需要的循环队列
typedef struct {
    int    data[MAX_VEXTEX_NUM];
    int    front, rear;
}Queue;

//创建邻接矩阵
void creat_graph(MGraph *ga);

// 队列操作
void InitQueue(Queue *Q);
void EnQueue(Queue *Q, int e);
Bool QueueEmpty(Queue *Q);
void DeQueue(Queue *Q, int *e);

//
void DisMGraph(MGraph *G);
//图的深度优先遍历
void DFS(MGraph G, int i);
void DFSTraverse(MGraph G);

//图的广度优先遍历
void BFSTraverse(MGraph *G);

    




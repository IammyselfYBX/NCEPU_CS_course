//有向图的邻接矩阵表示

#define MAX_VEXTEX_NUM 20 //最大顶点数
#define MAXINT 65536    //假定无穷大是 65536
typedef double VRType; //因为是权值所以不一定是 int
typedef char VertexType;

//弧
typedef struct
{
    VRType adj; //这里存放权值
}GraphArc, AdjMatrix[MAX_VEXTEX_NUM][MAX_VEXTEX_NUM];

//网的定义
typedef struct {
    VertexType vexs[MAX_VEXTEX_NUM]; //顶点信息
    AdjMatrix arcs; //邻接矩阵
    int vex_num, arc_num; //顶点数、弧数
}NetGraph;

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
void creat_net(NetGraph *ga);

//创建邻接矩阵
void creat_graph(NetGraph *ga);

// 队列操作
void InitQueue(Queue *Q);
void EnQueue(Queue *Q, int e);
Bool QueueEmpty(Queue *Q);
void DeQueue(Queue *Q, int *e);

//
void DisNetGraph(NetGraph *G);
//图的深度优先遍历
void DFS(NetGraph G, int i);
void DFSTraverse(NetGraph G);

//图的广度优先遍历
void BFSTraverse(NetGraph *G);



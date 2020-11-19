//有向图的邻接表表示

#define MAX_VEXTEX_NUM 20
#define MAXINT 65536    //假定无穷大是 65536
typedef double VRType; //因为是权值所以不一定是 int
typedef char VertexType;

//用于深度与广度遍历
#define TRUE   1
#define FALSE  0
typedef int Bool;
//Bool visited[MaxSize];  //全局数组,记录图中节点访问状态

//弧的结点结构
/* ArcNode
 * __________________________
 * |        |        |      |
 * | adjvex |nextarc | info |
 * |________|________|______|
 * */
typedef struct ArcNode
{
    int adjvex; //该弧所指向顶点的位置
    struct ArcNode *nextarc;  //指向下一条弧的指针
    VRType info; //用于存放边上的信息，可有可无，具体看情况，这里info就是权值
}ArcNode;

//顶点的结点结构
/* 
 * VNode
 * ____________________
 * |        |          |
 * |  data  | firstarc |
 * |________|__________|
 * */
typedef struct VNode
{
    VertexType data; //顶点信息
    ArcNode *firstarc;  //指向第一条依附该顶点的弧
}VNode, AdjList[MAX_VEXTEX_NUM];

//图的邻接表定义
/* ALGraph
 * ____________________
 * |        |          | 
 * |  data  | firstarc |
 * |________|__________|
 * |        |          |
 * |  data  | firstarc |
 * |________|__________|
 * |        |          |
 * |  ...   | .......  |
 * |________|__________|
 * |        |          |
 * |  data  | firstarc |
 * |________|__________|
 * */
typedef struct ALGraph
{
    AdjList vertices;
    int vex_num, arc_num;
}ALGraph;


/*
 * 图的操作
 * */
ALGraph *CreateALGraph(ALGraph *Gp); //无向图的邻接表创建


/*
 * 队列定义及相关操作(广度遍历会用到此循环队列)
 * */
//定义循环队列
typedef struct LoopQueue{
    int data[MAX_VEXTEX_NUM];
    int front,rear;
}Queue; //队列结构
void initQueue(Queue *Q);       // 队列初始化
Bool QueueEmpty(Queue *Q);      // 队列是否为空
Bool QueueFull(Queue *Q);       // 判断队列是否满了
void EnQueue(Queue *Q,int e);   // 队尾插入元素
void DeQueue(Queue *Q,int *e);  // 队头删除元素

// 深度优先搜索
void DFS(ALGraph *G, int i);
void DFSTraverse(ALGraph *G);

// 广度优先遍历
void BFSTraverse(ALGraph *G);



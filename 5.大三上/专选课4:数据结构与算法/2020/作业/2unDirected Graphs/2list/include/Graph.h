/*
 * Fuction: 定义 无向图 邻接表的变量
 * Last-Modified:2020年 11月 08日 星期日 11:27:49 KST
**/

// 无向图的邻接表 表示
#define MaxSize 20
typedef int VRType;   // 相邻结点间 权值
typedef char VertexType; //顶点信息

//用于深度与广度遍历
#define TRUE   1  
#define FALSE  0
typedef int Bool;
//Bool visited[MaxSize];  //全局数组,记录图中节点访问状态

//邻接表的 边结点
/* EdgeNode
 * __________________________
 * |        |        |      |
 * | adjvex |nextarc | info |
 * |________|________|______|
 * */
typedef struct EdgeNode
{
    int adjvex;//存储该顶点对应的下标
    struct EdgeNode *next;//指向该顶点的下一个邻接点
    VRType info; //用于存放边上的信息，可有可无，具体看情况，这里info就是权值
}EdgeNode;

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
    EdgeNode *firstedge;  //指向第一条依附该顶点的弧
}VNode, AdjList[MaxSize];

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
    int vex_num, edge_num;
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
    int data[MaxSize];
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






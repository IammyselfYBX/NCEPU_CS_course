#ifndef __QUEUE_H__
#define __QUEUE_H__

#define MAX_VEXTEX_NUM 20 //最大顶点数

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

// 队列操作
void InitQueue(Queue *Q);
void EnQueue(Queue *Q, int e);
Bool QueueEmpty(Queue *Q);
void DeQueue(Queue *Q, int *e);
#endif

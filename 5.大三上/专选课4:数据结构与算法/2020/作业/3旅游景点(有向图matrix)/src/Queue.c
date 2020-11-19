/*
 * Function：实现队列操作
 * Author：杨秉学
 * */
#include "Queue.h"
#include <stdio.h>

//初始化
void InitQueue(Queue *Q)
{
    Q->front = Q->rear = 0;
}

//入队
void EnQueue(Queue *Q, int e)
{
    if ((Q->rear+1)%MAX_VEXTEX_NUM == Q->front)
        return ;

    Q->data[Q->rear] = e;
    Q->rear = (Q->rear+1)%MAX_VEXTEX_NUM;
}

//判空
Bool QueueEmpty(Queue *Q)
{
    if (Q->front == Q->rear)
        return TRUE;
    else
        return FALSE;
}

//出队
void DeQueue(Queue *Q, int *e)
{
    if (Q->front == Q->rear)
        return ;

    *e = Q->data[Q->front];
    Q->front = (Q->front+1)%MAX_VEXTEX_NUM;
}



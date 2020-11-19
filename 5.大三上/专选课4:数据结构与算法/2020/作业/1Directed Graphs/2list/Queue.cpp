/**
 * Function:队列定义及相关操作(广度遍历会用到此循环队列) 
 * Last-Modified: 2020年 11月 08日 星期日 11:28:34 KST
**/

#include "Graph.h"
#include <iostream>
using namespace std;

// 队列初始化
void initQueue(Queue *Q){
    Q->front=Q->rear=0;
}

// 队列是否为空
Bool QueueEmpty(Queue *Q){
    if(Q->front == Q->rear){
        return TRUE;
    }else{
        return FALSE;
    }
}

// 判断队列是否满了
Bool QueueFull(Queue *Q){
    if((Q->rear+1)%MaxSize == Q->front){
        return TRUE;
    }else{
        return FALSE;
    }
}

// 队尾插入元素
void EnQueue(Queue *Q,int e){
    if(!QueueFull(Q)){
        Q->data[Q->rear] = e;
        Q->rear = (Q->rear+1)%MaxSize;
    }
}

// 队头删除元素
void DeQueue(Queue *Q,int *e){
    if(!QueueEmpty(Q)){
        *e = Q->data[Q->front];
        Q->front = (Q->front+1)%MaxSize;
    }
}

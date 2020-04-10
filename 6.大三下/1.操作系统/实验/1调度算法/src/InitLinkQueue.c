#include "Node.h"

void initlink_queue(LinkQueue **order)
{
    //初始化
    (*order)->front = (*order)->rear = (job *)malloc(sizeof(job));
    (*order)->rear->next=NULL;
    (*order)->front->prior=(*order)->front;
    (*order)->average_time = (*order)->average_weight_time = 0.0;
    (*order)->begin=0.0;
}
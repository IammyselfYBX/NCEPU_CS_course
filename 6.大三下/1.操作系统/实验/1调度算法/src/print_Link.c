#include "Node.h"

void print_Link(LinkQueue **order){
    LinkQueue *head = *order;
    job *jobs = head->front->next;
    printf("------------------------------------------------------------------\n");
    printf("调度次序\t作业号\t调度时间\t\t周转时间\t\t带权周转时间\n");
    int i=1;
    while (jobs)
    {
        (*order)->average_time+= jobs->zhouzhuan;
        (*order)->average_weight_time += jobs->weight_zhouzhuan;
        printf("%d\t\t%d\t%f\t\t%f\t\t%f\n", i++, jobs->job_num, jobs->wait, jobs->zhouzhuan, jobs->weight_zhouzhuan);
        jobs = jobs->next;
    }
    (*order)->average_time = (*order)->average_time/(i-1);
    (*order)->average_weight_time = (*order)->average_weight_time/(i-1);
    printf("\t平均周转时间:%f\t平均带权周转时间:%f\n", (*order)->average_time, (*order)->average_weight_time);
}

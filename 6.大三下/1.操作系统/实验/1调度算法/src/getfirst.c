#include "Node.h"

// 选择排序——选择提交时间最小的放到队列里面
void getfirst(job **jobs_head, LinkQueue **order)
{
    job *jobs = (*jobs_head)->next;     //jobs指向第一个元素
    //看谁的提交时间最靠前，序列号放到 first_num 中,如果相同比较运行时间 
    int count = 1;          // 计数， 看有几个相同的，因为实现存放一个元素在 first[] 中，所以 count 是 1
    int first_time=jobs->submit_time;
    job *first[10];          // 假设相同提交时间的不超过10个
    first[0] = jobs;        // 把第1个的值放到里面
    
    jobs = jobs->next;      // 已经把第1个的值放到 first[] 里面，就不需要再从第一个开始比较了
    while(jobs){
        if(first_time > jobs->submit_time){
            count = 0;
            first_time = jobs->submit_time;
            first[count++] = jobs;
        }
        if(first_time == jobs->submit_time){
            first[count++] = jobs;
        }
        jobs = jobs->next;
    }

    double first_runtime = first[0]->run_time;
    
    // 如果提交时间相同的话，比较谁的运行时间短，优先。
    job *final_first = NULL;
    for(int i=0; i<count; i++){
        if(first_runtime >= first[i]->run_time){
            first_runtime = first[i]->run_time;
            final_first = first[i];
        }
    }
    
    (*order)->begin=final_first->submit_time+final_first->run_time;     //设置为第一个初始时间为该进程提交时间+运行时间
    final_first->wait=0;
    final_first->zhouzhuan=final_first->wait+final_first->run_time;
    final_first->weight_zhouzhuan = final_first->zhouzhuan/final_first->run_time;

    //把第一个节点从链表拿下来放到队列里面。
    final_first->prior->next=final_first->next;
    if(final_first->next!=NULL){
        final_first->next->prior = final_first->prior;
    }else{}
    final_first->next=(*order)->rear->next;
    (*order)->rear->next=final_first;
    final_first->prior=(*order)->rear;
    (*order)->rear=final_first;
}
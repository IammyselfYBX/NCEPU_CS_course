#include <stdio.h>
#include <stdlib.h>

typedef struct job{         //双向链表
    double submit_time;
    double run_time;
    int job_num;
    double Rp;
    double wait;
    double zhouzhuan;
    double weight_zhouzhuan;
    struct job *next, *prior;
}job;       

typedef struct LinkQueue    //队列
{
    double begin;                  // 开始时间
    double average_time;           // 平均周转时间
    double average_weight_time;    // 平均带权周转时间
    job *front, *rear;//队头 和 队尾
}LinkQueue;

void create_link(job **head);
void initlink_queue(LinkQueue **order);
void hight_response_ratio_next(job **head, LinkQueue **order);
void getfirst(job **jobs, LinkQueue **order);
void assert_begin(job **jobs, LinkQueue **order);
void getrp(job **jobs, LinkQueue **order);
void print_Link(LinkQueue **order);
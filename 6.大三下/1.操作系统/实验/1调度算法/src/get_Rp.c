#include "Node.h"

// 选择排序——选择 Rp 最大的放到队列里面
void getrp(job **jobs_head, LinkQueue **order)
{
    job *jobs = (*jobs_head)->next;
    //job *text = jobs;       //jobs就是第一个
    // 计算出每个作业的 Rp
    job *job_tmp=jobs;
    double max_Rp=0;
    while(job_tmp){
        job_tmp->wait = (*order)->begin - job_tmp->submit_time;
        job_tmp->Rp = (double) (job_tmp->wait + job_tmp->run_time)/job_tmp->run_time;
        if(job_tmp->Rp >= max_Rp){
            max_Rp = job_tmp->Rp;      // 找到最大的 Rp 值，不用关重复 Rp 的，因为只要 Rp 相同，谁先执行无所谓
        }
        job_tmp = job_tmp->next;
    }

    // 找到最大 Rp 对应的结点
    job_tmp = jobs;
    while(job_tmp){
        if(max_Rp == job_tmp->Rp){  //找到就直接放到队列里面，然后跳出循环
            //找到以后计算周转时间和带权周转之间
            job_tmp->zhouzhuan = job_tmp->wait + job_tmp->run_time;
            job_tmp->weight_zhouzhuan = (job_tmp->zhouzhuan)/job_tmp->run_time;
            job_tmp->prior->next = job_tmp->next;
            if(job_tmp->next){
                job_tmp->next->prior= job_tmp->prior;
            }else{}

            // 修改 begin 的值为加上该作业的运行时间
            (*order)->begin += job_tmp->wait;
            job_tmp->next=(*order)->rear->next;
            (*order)->rear->next=job_tmp;
            job_tmp->prior = (*order)->rear;
            (*order)->rear = job_tmp;
            break;
        }
        job_tmp = job_tmp->next;
    }
}
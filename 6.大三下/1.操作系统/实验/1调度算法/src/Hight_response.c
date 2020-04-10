#include "Node.h"

void hight_response_ratio_next(job **head, LinkQueue **order)
{
    job *first = *head;                     // 头结点
    LinkQueue *order_first = *order;        // 队列表头

    job *jobs = first;                      // 双向链表头结点(不含元素)
    order_first = *order;                   // 队列头结点
    job *jobs_tmp = NULL;
    while (jobs->next)
    {
        // 如果存在某一个结点的 submit_time > (*ordor)->begin 才需要重新确定 begin——>assert_begin，否则直接进行 getrp();
        job *temp=jobs->next;                   // temp指向第一个结点
        jobs_tmp=NULL;
        while (temp)
        {   
            if(temp->submit_time > (*order)->begin){
                jobs_tmp = temp;
                break;
            }
            temp = temp->next;
        }
        
        if(jobs_tmp)
        {
            assert_begin(&jobs, &order_first);          // 重新确定 begin 的值，并将第一个元素放到队列里面
            jobs_tmp = NULL;
            jobs = first;                               // 然后重新开始，直到链表为空 NULL 结束循环
        }else{
            getrp(&jobs, &order_first);                 // 从链表中找出 Rp 值最大的元素放到队列里面
        }
        jobs = first;
    }
}
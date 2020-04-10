#include "Node.h"

// 比较 上一个运行结束以后的时间作为 begin，与其他的剩余作业的提交时间比较，
// 如果 begin 比其他剩余作业的提交时间晚，那么以 begin 作为开始时间
void assert_begin(job **jobs, LinkQueue **order){
    //从头在次遍历，看有没有那个作业的提交时间晚于上一个作业结束时间,只要有全部 头插法 放到 job_tmp_head 里面
    job *job_tmp = (*jobs)->next;                                 // 第一个元素
    job *job_tmp_head=(job *)malloc(sizeof(job));                 // 定义新双向链表的头结点    这样才能有结点结构
    job_tmp_head->prior=(*jobs);                                  // 新头节点的 前指针指向原双向链表头结点。
    job_tmp_head->next=NULL;                
    job *temp=NULL;
    while(job_tmp){
        if((*order)->begin <= job_tmp->submit_time){              // 只要存在作业的提交时间比队列记录的起始时间晚或等于一律放到新双向链表里面
            temp=job_tmp->next;                              // 因为放完之后还需要进行循环，可能找不到下一个节点，先标记一下
            //先从双向链表拿下来
            job_tmp->prior->next = job_tmp->next;
            if(job_tmp->next!=NULL){
                job_tmp->next->prior = job_tmp->prior;
                
            }else
            {
                // 如果是最后一个就什么也不做，不操作 ->next->prior 因为没有
            }
            // 头插法在放到新的双线链表里面
            job_tmp->next = job_tmp_head->next;
            job_tmp->prior = job_tmp_head;
            if(job_tmp_head->next){
                job_tmp_head->next->prior = job_tmp;
            }else{}
            job_tmp_head->next = job_tmp;

            job_tmp = temp;
            
        }else
        {
            job_tmp = job_tmp->next;
        }      
    }

    // 判断新链表是否为空
    if(job_tmp_head->next){     // 不为空
        job_tmp = *jobs;        // 找到原双向链表表尾
        while(job_tmp->next){ 
            job_tmp = job_tmp->next;
        }
        //将新链表接到原双向链表后面
        job_tmp->next = job_tmp_head->next;
        job_tmp_head->next->prior = job_tmp;

        LinkQueue *order_first = *order;        // 队列头结点
        getfirst(&job_tmp_head, &order_first); 
    }
    // 为空直接推出函数到 get_Rp
}
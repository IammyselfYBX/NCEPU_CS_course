#include "Node.h"

void create_link(job **head)
{
    printf("请输入作业数K: ");
    int num;
    scanf("%d", &num);
    if(num<=0){
        printf("对不起，你输入的作业数有误!!!\n");
        exit(-1);
    }
    job *temp_head = *head;     // temp_head指向头结点区域
    char a[4];

    //输入尾插法
    for(int i=0; i<num; i++){
        job *jobs = (job *)malloc(sizeof(job));
        temp_head->next=jobs;
        jobs->prior=temp_head;
        printf("作业%d的提交时间: ", i+1);
        scanf("%s", a);
        getchar();
        int temp =atoi(a);
        double time = temp/100*60+temp%100;
        jobs->submit_time = time;
        printf("作业%d的运行时间: ", i+1);
        int runtime;
        scanf("%d", &runtime);
        jobs->run_time = (double) runtime;
        jobs->job_num=i+1;
        jobs->Rp=0;
        jobs->next=NULL;
        temp_head=jobs;
    }

    temp_head = temp_head->next;    
    free(temp_head);

}
#include "Node.h"

int main()
{
    job *head;                                                      // 创建头节点
    head = (job *)malloc(sizeof(job));
    head->prior = head;
    head->next = NULL;
    create_link(&head);                                             // 创建存储链表

    LinkQueue *order;                                               // 运行队列顺序
    initlink_queue(&order);                                         // 初始化
    
    hight_response_ratio_next(&head, &order);                       // 采用队列高响应比优先算法将双链表中的元素排到队列里面

    print_Link(&order);                                              // 遍历输出队列    
    
    return 0;
}
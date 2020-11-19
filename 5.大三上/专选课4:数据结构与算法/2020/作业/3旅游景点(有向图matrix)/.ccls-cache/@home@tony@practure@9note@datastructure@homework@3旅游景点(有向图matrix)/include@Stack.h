#ifndef __STACK_H__
#define __STACK_H__

#define TRUE   1
#define FALSE  0
typedef int Bool;

//===================链栈======================
// 定义链表结点
typedef struct Node{
    int data;           //数据
    struct Node* next;  //指针
}Node;

// 定义链表结构
typedef struct Stack{
    Node* top;
    Node* bottom;
}Stack;

// 定义链表操作
void InitStack(Stack *s);     // 初始化
Stack* push(Stack * s,int a); // 入栈
int pop(Stack * s);           // 出栈
Bool Isempty(Stack *s);       // 判断是否为空

#endif

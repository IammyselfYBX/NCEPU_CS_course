#ifndef __STACK_H__
#define __STACK_H__

#define TRUE   1
#define FALSE  0
typedef int Bool;
//===================链栈======================
typedef struct Node{
    int data;           //数据
    struct Node* next;  //指针
}Node;
typedef struct Stack{
    Node* top;
    Node* bottom;
}Stack;
void InitStack(Stack *s);
Stack* push(Stack * s,int a);
int pop(Stack * s);
Bool Isempty(Stack *s);

#endif

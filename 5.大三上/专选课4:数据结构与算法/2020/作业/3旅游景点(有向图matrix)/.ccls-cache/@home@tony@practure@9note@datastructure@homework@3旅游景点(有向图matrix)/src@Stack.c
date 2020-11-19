/*
 * Function:实现栈的操作
 * Author:杨秉学
 * */
#include "Stack.h"
#include <stdlib.h>
#include <stdio.h>
#include <malloc.h>

// 初始化
void InitStack(Stack *s)
{
    s->bottom=s->top=NULL;
}

// 入栈
Stack* push(Stack * s,int a){
    Node* pNew = (Node*)malloc(sizeof(Node));
    if(pNew == NULL){
        printf("push失败！");
        exit(-1);
    }
    pNew->data = a;
    pNew->next = s->top;
    s->top = pNew;
    return s;
}

// 出栈
int pop(Stack * s){
    int result;
    if(s->top == NULL){
        printf("栈空！\n");
        exit(-1);
    }
    Node *p = s->top;
    result = p->data;
    s->top = p->next;
    free(p);
    p = NULL;
    return result;
}

//判断空
Bool Isempty(Stack *s)
{
    if(s->bottom==s->top)
        return TRUE;
    else
        return FALSE;
}

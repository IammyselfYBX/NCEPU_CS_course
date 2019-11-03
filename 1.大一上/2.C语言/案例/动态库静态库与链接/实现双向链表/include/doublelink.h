#ifndef _doublelink_h
#define _doublelink_h

#include <stdlib.h>

//创建两个结构, ListNode 和包含这些节点的 List
struct ListNode;
typedef struct ListNode {
    struct ListNode *next;
    struct ListNode *prev;
    void *value;
} ListNode;

typedef struct List {   //List 结构只是这些 ListNode 结构的容器,它们互联链接组成链型。
    int count;
    ListNode *first;
    ListNode *last;
} List;

List *List_create();
void List_destroy(List *list);
void List_clear(List *list);
void List_clear_destroy(List *list);

#define List_count(A) ((A)->count)
#define List_first(A) ((A)->first != NULL ? (A)->first->value :NULL)
#define List_last(A) ((A)->last != NULL ? (A)->last->value : NULL)

void List_push(List *list, void *value);
void *List_pop(List *list);

void List_unshift(List *list, void *value);
void *List_shift(List *list);

void *List_remove(List *list, ListNode *node);

#define LIST_FOREACH(L, S, M, V) ListNode *_node = NULL;\
        ListNode *V = NULL;\
        for(V = _node = L->S; _node != NULL; V = _node = _node->M)
#endif
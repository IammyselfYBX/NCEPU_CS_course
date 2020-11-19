//定义数据的数据类型
//#define Elemtype int      //take an integer
#include <stdio.h>
#include <malloc.h>
#include <string.h>

typedef struct STD          //take STD to Elemtype
{
    char name[20];
    int score;
}Elemtype;          //实际上应该写STD，但是为了规范，写Elemtype

//定义单向链表的数据类型
typedef struct Lnode{
    Elemtype data;  
    struct Lnode *next;
}LNode, *LinkList;

//function
int linklist_init(LinkList *L);
int linklist_insert(LinkList *L, int i, Elemtype e);
int linklist_delete(LinkList *L, int i, Elemtype *e);
int linklist_update(LinkList *L, int i, Elemtype e);
int linklist_get(LinkList L, int i, Elemtype *e);
int linklist_location(LinkList L, char *name);
int linklist_display(LinkList L);
int get_length(LinkList L);
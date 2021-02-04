#include <stdio.h>

#define INIT_SIZE 20
#define INCREASE_SIZE 5

// 定义顺序表类型
typedef struct{
    int key; //关键子
}ElemType;

// 定义顺序表结构
typedef struct {
    ElemType *elem;
    int length, MaxSize;
}SSTable;


void InitTable(SSTable *l); // 初始化
int search_bin(SSTable *l, int key); //折半查找
int InsertTable(SSTable *l, int local, int key); //根据位置插入
void Traverse(SSTable l);
void test_demo(SSTable *l);

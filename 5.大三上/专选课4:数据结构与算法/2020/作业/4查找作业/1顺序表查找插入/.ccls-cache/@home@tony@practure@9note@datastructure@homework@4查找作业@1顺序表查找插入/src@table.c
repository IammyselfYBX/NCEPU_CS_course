#include <stdio.h>
#include "table.h"
#include <stdlib.h>

void InitTable(SSTable *l)
{
    printf("Table Initializing......\n");
    l->elem=(ElemType *)malloc(INIT_SIZE*sizeof(ElemType));
    if(!(l->elem))
    {
        printf("Initialized Failed!!!\n");
        exit(-1);
    }

    l->length=0; // 初始化长度为0
    l->MaxSize=INIT_SIZE;
    printf("Initialize SuCCEED!!!\n");
    printf("-----------------------------------------------------\n");
}

// 折半查找，找到返回数组下标
// 没找到返回应该插入的位置
int search_bin(SSTable *l, int key)
{
    // 折半查找这里数组从0开始
    int low=0;
    int high=l->length-1;
    int mid=(low+high)/2;
    printf("\n*******************************************\n");
    printf("显示二分查找过程\n");
    printf("初始值：length=%d, high=%d\n", l->length, high);

    while(low<=high)
    {
        mid=(low+high)/2;
    printf(">> low=%d,mid=%d,high=%d\n",low, mid, high);
        if(key == l->elem[mid].key)
        {
            return mid;
        }else if(key < l->elem[mid].key){
            high = mid -1;
        }else{
            low = mid +1;
        }
    printf("<< low=%d,mid=%d,high=%d\n",low, mid, high);
    }

    // 顺序表不存在待查元素，直接在那个位置插入
    // 如果要插入的位置是在最后一个位置，那么就应该在最后的位置的后面（+1）
    if(mid==high)
    {
        mid++;
    }
    printf("Not Found! But Inserted in the %dth position\n", mid);
    InsertTable(l, mid, key);
    Traverse(*l);

    return -1;
}

// 插入
// 根据位置插入元素
int InsertTable(SSTable *l, int local, int key)
{
    // 如果长度不够动态申请空间
    if(l->length == l->MaxSize){
        l->elem =(ElemType*)realloc(l->elem, (l->MaxSize+INCREASE_SIZE)*sizeof(ElemType));
        l->MaxSize+=INCREASE_SIZE;
    }

    // 这里不用判断是否溢出
    // 先转移元素
    for (int i = l->length; i>=local; i--) {
        l->elem[i]=l->elem[i-1];
    }
    l->elem[local].key=key;
    l->length+=1;
    printf("After insert length=%d\n", l->length);

    return 0;
}

// 遍历
void Traverse(SSTable l)
{
    if(0 == l.length)
    {
        printf("Empty!!\n");
    }

    for (int i = 0; i < l.length; i++) {
        printf("%4d",i+1);
    }
    printf("\n");

    for (int i = 0; i < l.length; i++) {
        printf("----");
    }
    printf("\n");

    for (int i = 0; i < l.length; i++) {
        printf("%4d",l.elem[i].key);
    }
    printf("\n");
}

// 仅仅是为了演示使用
void test_demo(SSTable *l)
{
    printf("加载实验用例loading......\n");
    l->length=11;
    l->elem[0].key=5;
    l->elem[1].key=13;
    l->elem[2].key=19;
    l->elem[3].key=21;
    l->elem[4].key=37;
    l->elem[5].key=56;
    l->elem[6].key=64;
    l->elem[7].key=75;
    l->elem[8].key=80;
    l->elem[9].key=88;
    l->elem[10].key=92;
    printf("加载完成\n");
    printf("加载数据为：\n");
    Traverse(*l);
}








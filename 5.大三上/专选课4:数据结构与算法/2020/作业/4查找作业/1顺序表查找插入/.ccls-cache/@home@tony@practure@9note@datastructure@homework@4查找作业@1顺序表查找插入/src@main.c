/*
 * 顺序表中存储的数据元素是整数，编写算法实现折半查找给定值：找到时返回所在位置，找不到时插入该值并返回插入位置。
 * */

#include <stdio.h>
#include "table.h"

int main(int argc, char *argv[])
{
    SSTable l;
    InitTable(&l);
    test_demo(&l);

    int key=0;
    int local=0;
    while(1)
    {
        printf("\n----------------------------------------------------------\n");
        printf("请输入要找的元素(必须是整数)[Ctrl-c终止程序]: ");
        scanf("%d", &key);
        getchar();
        printf("查找元素%d\n",key);
        local = search_bin(&l, key);
        if(-1!=local)
        {
            printf("该元素位置是%d\n", local+1);
        }
    }

    return 0;
}

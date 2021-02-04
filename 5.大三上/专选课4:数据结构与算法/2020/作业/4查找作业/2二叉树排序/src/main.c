/*
 * 编写二叉排序树相关算法：
 *  1.画出一个二叉排序树，写出对应的先序字符串
 *  2.输入先序字符串，编写递归算法创建二叉树
 *  3.编写算法，输出二叉排序树的中序遍历结果
 *  4.编写算法，在二叉排序树上查找给定值，找到返回该结点指针，找不到返回查找路径的最后一个结点指针。
 *
 * */

#include "BST.h"

int main(int argc, char *argv[])
{
    BSTree root;
  	int key;
    BSTree tmp;
    tmp=NULL;
    int result=0;
    printf("\n");
    printf("\t\t\t二叉排序树程序\n");
    printf("\t\t\t\t\tAuthor:计算1702 杨秉学\n");
    printf("\n");

    // 创建
    char y_o;
    printf("\e[41;32m 在使用之前请先创建一个有向图(Y/N)(默认是Y): \e[0m");
    fflush(stdin);//注意前bai面要清空输入缓冲du区字符
    scanf("%c",&y_o);
    if(y_o=='Y'|| y_o=='y' || y_o=='\n')
    {
        CreateBst(&root);
    }else{
        printf("欢迎再次使用\n");
        exit(0);
    }

    while(1)
    {
        printf("\n\n\n=====================================\n");
        printf("\n\n\n二叉排序树程序\n");
        printf("1.中序遍历(从小到大)\n");
        printf("2.逆中序遍历(从大到小)\n");
        printf("3.查询\n");
        printf("=====================================\n");
        printf("> ");

        int option=0;
        fflush(stdin);
        scanf("%d", &option);
        getchar();

        switch(option){
            case 1:
                printf("中序遍历(从小到大)：");
                Inorder(root);
                printf("\n");
                break;
            case 2:
                printf("逆中序遍历(从大到小)：");
                ReverseInorder(root);
                printf("\n");
                break;
            case 3:
                printf("请输入需要查询的整数: ");
                scanf("%d",&key);
                getchar();
                result=SearchBST(root, key, root, &tmp);
                if(-1 == result){
                    printf("查找失败!!!\n");
                    printf("查询路径上最后一个结点为%d\n",tmp->data);
                }else if(1 == result){
                    printf("查找成功!!!\n");
                }
                break;
        }
    }

    return 0;
}


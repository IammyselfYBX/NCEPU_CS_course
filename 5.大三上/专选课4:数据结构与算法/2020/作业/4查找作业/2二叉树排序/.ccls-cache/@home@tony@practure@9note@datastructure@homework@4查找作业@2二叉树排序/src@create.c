#include "BST.h"

/*
 * 二叉树的建立，需要按照一棵满二叉树来建立
 * 二叉排序树建立二叉树，对于左右子树建立时有条件限制，则不需要补空节点
 * */
//从键盘输入元素的值，创建相应的二叉排序树 
void CreateBst(BSTree *bst) {
    int key;
  	*bst = NULL;

    int node_num=0;
    printf("请输入结点数:");
    scanf("%d", &node_num);
    getchar();
    fflush(stdin);

    for (int i = 0; i < node_num; i++) {
        printf("第%d个结点整数: ", i+1);
        scanf("%d", &key);
        getchar();
        InsertBST(bst, key);
    }
}


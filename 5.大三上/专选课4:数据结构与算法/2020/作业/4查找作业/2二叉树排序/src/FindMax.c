/*
 * 找该分支最大的结点，返回结点指针
 * */
#include "BST.h"

BSTree searchMax(BSTree root)
{
    if(root == NULL)
        return NULL;
    if(root->rchild == NULL)
        return root;
    else  //一直往左孩子找，直到没有右孩子的结点
        return searchMin(root->rchild);
}


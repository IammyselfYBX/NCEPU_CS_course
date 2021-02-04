/*
 * 找该分支最小的结点，返回结点指针
 * */
#include "BST.h"

BSTree searchMin(BSTree root)  
{  
    if(root == NULL)  
        return NULL;  
    if(root->lchild == NULL)  
        return root;  
    else  //一直往左孩子找，直到没有左孩子的结点  
        return searchMin(root->lchild);  
}  


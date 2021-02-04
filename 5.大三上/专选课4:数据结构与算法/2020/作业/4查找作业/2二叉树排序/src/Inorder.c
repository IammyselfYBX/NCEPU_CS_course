#include "BST.h"

// 中序遍历从小到大输出二叉树结点，即先遍历左子树，然后根，最后右子树 
void Inorder(BSTree root) {
    if(root!=NULL) {
        Inorder(root->lchild); //先序遍历左子树
        printf("%d ",root->data);//访问根节点
        Inorder(root->rchild);//先序遍历右子树
	}
}

//逆中序遍历从大到小输出二叉树结点，即先遍历右子树，然后根，最后左子树
void ReverseInorder(BSTree root) {
    if(root!=NULL) {
        ReverseInorder(root->rchild);//先序遍历右子树
        printf("%d ",root->data);//访问根节点
        ReverseInorder(root->lchild);//先序遍历左子树
	}
}
  

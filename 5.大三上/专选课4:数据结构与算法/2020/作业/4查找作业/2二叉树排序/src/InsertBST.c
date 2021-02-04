#include "BST.h"

//插入结点，并对结点进行判断，确定插入左子树还是右子树
void InsertBST(BSTree *bst,int key) {
    BSTree s;
//	若在二叉排序树中不存在关键字等于key的元素则插入该元素
  	if(*bst==NULL) {
        s = (BSTree)malloc(BSTNODE_SIZE);
    		s->data = key;
    		s->lchild = NULL;
    		s->rchild = NULL;
    		*bst = s;
  	} else if(key<(*bst)->data){
        InsertBST(&((*bst)->lchild),key);		//将s插入左子树
    }	else if(key>(*bst)->data){
        InsertBST(&((*bst)->rchild),key);	   //将s插入右子树
    }
}


#include "BST.h"
//根据关键字删除某个结点,删除成功返回1,否则返回0  
//如果把根结点删掉，那么要改变根结点的地址，所以传二级指针  
int deleteNode(BSTree* root,Elemtype key)  
{  
    BSTree q;  
    //查找到要删除的结点  
    BSTree p=search(*root,key);  
    Elemtype temp;    //暂存后继结点的值  
    //没查到此关键字  
    if(!p)  
        return 0;  
    //1.被删结点是叶子结点，直接删除  
    if(p->lchild == NULL && p->rchild == NULL){  
        //只有一个元素，删完之后变成一颗空树  
        if(p->parent == NULL){  
            free(p);  
            (*root)=NULL;  
        }else{  
            //删除的结点是父节点的左孩子  
            if(p->parent->left == p)  
                p->parent->left=NULL;  
            else  //删除的结点是父节点的右孩子  
                p->parent->right=NULL;  
            free(p);  
        }  
    }  
  
    //2.被删结点只有左子树  
    else if(p->lchild && !(p->rchild)){  
        p->lchild->parent=p->parent;  
        //如果删除是父结点，要改变父节点指针  
        if(p->parent == NULL)  
            *root=p->lchild;  
        //删除的结点是父节点的左孩子  
        else if(p->parent->left == p)  
            p->parent->left=p->lchild;  
        else //删除的结点是父节点的右孩子  
            p->parent->right=p->lchild;  
        free(p);  
    }  
    //3.被删结点只有右孩子  
    else if(p->rchild && !(p->lchild)){  
        p->rchild->parent=p->parent;  
        //如果删除是父结点，要改变父节点指针  
        if(p->parent == NULL)  
            *root=p->rchild;  
        //删除的结点是父节点的左孩子  
        else if(p->parent->left == p)  
            p->parent->left=p->rchild;  
        else //删除的结点是父节点的右孩子  
            p->parent->right=p->rchild;  
        free(p);  
    }  
    //4.被删除的结点既有左孩子，又有右孩子  
    //该结点的后继结点肯定无左子树(参考上面查找后继结点函数)  
    //删掉后继结点,后继结点的值代替该结点  
    else{  
        //找到要删除结点的后继  
        q=searchSuccessor(p);  
        temp=q->key;  
        //删除后继结点  
        deleteNode(root,q->key);  
        p->key=temp;  
    }  
    return 1;  
}  

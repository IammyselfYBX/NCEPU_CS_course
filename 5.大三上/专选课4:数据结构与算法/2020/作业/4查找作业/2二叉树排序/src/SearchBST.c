#include "BST.h"

int SearchBST(BSTree t, int key, BSTree f, BSTree *p)
{
    if (t==NULL) {      // 查找不成功
        *p=f;
        return -1;
    }else if(key==t->data){ //查找成功
        *p=t;
        return 1;
    }else if(key<t->data){  // 查询的值小于当前结点，左子树
        return SearchBST(t->lchild, key, t,p);
    }else{                  // 查询的值大于当前结点，右子树
        return SearchBST(t->rchild, key, t,p);
    }
}

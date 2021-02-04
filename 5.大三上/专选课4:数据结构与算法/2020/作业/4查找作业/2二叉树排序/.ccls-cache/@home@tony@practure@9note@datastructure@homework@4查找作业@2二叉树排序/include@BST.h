/*
 * Function：定义 Binary sort tree
 *
 * */
#include <stdio.h>
#include <stdlib.h>

typedef int Elemtype;
//定义二叉树的二叉链表结点结构
typedef struct BSTNode
{
    Elemtype data;
    struct BSTNode *lchild;  //左孩子
    struct BSTNode *rchild;  //右孩子
}BSTNode, *BSTree;
 
#define BSTNODE_SIZE sizeof(BSTNode)

/*
 * 操作
 *    二叉排序树是一种动态树表。它的特点是树的结构不是一次生成的，而是在查找过程中，当树中不存在关键字等于给定值的节点时再进行插入。新插入的节点一定是一个新添加的叶子结点，并且是查找不成功时查找路径上访问的最后一个节点的左孩子或右孩子节点
 * */
//创建
void CreateBst(BSTree *bst);

//插入
/*插入过程比较简单，首先判断当前要插入的值是否已经存在二叉排序树中
 *    如果已经存在，则直接返回;
 *    如果不存在，则应找到适当的位置，将其插入。注意插入的新节点一定是叶子节点；
 * */
void InsertBST(BSTree *bst,int key);

//删除
/*首先要判断这样节点是否存在，
 *  1.如果已经不存在，则直接返回；
 *  2.如果已经存在，则获取给定值节点的位置，根据不同情况进行删除、调整
 *    1)如果待删节点只有左子树（只有右子树），则直接将待删节点的左子树（右子树）放在待删节点的位置，并释放待删节点的内存
 *    2)如果待删节点既有左子树又有右子树，此时的删除就是在待删节点 *左子树* 中找到值 *最大* 的那个节点，将其放到待删节点的位置。
 * */

//查询
/*首先将关键字和根节点的关键字比较
 *  1.如果 相等 则返回节点的位置(指针)；
 *  2.如果 小于 根节点的关键字，则去左子树中继续查找；
 *  3.如果 大于 根节点的关键字，则去右子树中查找；
 *  4.如果找到叶子节点也没找到，则返回 *查找路径的最后一个结点指针*
 * */

// t 表示根指针，key表示要查询的变量值，f表示当前结点的双亲，p表示查询路径上最后一个>结点
int SearchBST(BSTree t, int key, BSTree f, BSTree *p);
BSTree searchMin(BSTree root); //找该分支最小的结点，返回结点指针
BSTree searchMax(BSTree root); //找该分支最大的结点，返回结点指针

//遍历
// 中序遍历从小到大输出二叉树结点，即先遍历左子树，然后根，最后右子树
void Inorder(BSTree root);
//逆中序遍历从大到小输出二叉树结点，即先遍历右子树，然后根，最后左子树
void ReverseInorder(BSTree root);


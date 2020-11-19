/*
 * Fuction:创建无向图的邻接表
 * Last-Modified: 2020年 11月 08日 星期日 11:25:23 KST
 * */

#include "Graph.h"
#include <iostream>
#include <stdlib.h>
using namespace std;

ALGraph *CreateALGraph(ALGraph *Gp)//无向图的邻接表创建
{
   Gp=(ALGraph *)malloc(sizeof(ALGraph)); 
   EdgeNode *pe;//定义边表指针类型pe
   cout << "input numNodes and numEdges:" << endl;
   cin >> Gp->vex_num >> Gp->edge_num;

   for (int k = 0 ; k < Gp->vex_num; k++)
   {
       cout << "input VertexType data:" << endl;
       cin >> Gp->vertices[k].data;//输入A B C D
       Gp->vertices[k].firstedge = NULL;//将边表头指针指向NULL，即置为0
   }

  for (int k = 0; k <  Gp->edge_num; k++)//建立边表
  {
      int i,j;
      cout << "input vi and vj:" << endl;
      cin >> i >> j;//每次循环依次输入0 1,0 2,0 3,1 2,2 3

      pe = (EdgeNode *)malloc(sizeof(EdgeNode));
      pe->adjvex = j;// 邻接序号为j
      pe->next = Gp->vertices[i].firstedge;//将pe的指针指向当前顶点指向的结点
      Gp->vertices[i].firstedge = pe;//将当前顶点的指针指向pe

      pe = (EdgeNode *)malloc(sizeof(EdgeNode));
      pe->adjvex = i;
      pe->next = Gp->vertices[j].firstedge;
      Gp->vertices[j].firstedge = pe;//无序图重复上面步骤
  }
  return Gp;   
}

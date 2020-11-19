/*
 * Fuction:主函数
 * Last-Modified:2020年 11月 08日 星期日 11:24:39 KST
 * */
#include <iostream>
using namespace std;

#include "Graph.h"

int main(void)
{
    ALGraph *GL=NULL;
    GL = CreateALGraph(GL);

    cout<<"图的深度优先遍历为:"<<endl;
    DFSTraverse(GL);
    cout<<endl;

    cout<<"图的广度优先遍历为:"<<endl;
    BFSTraverse(GL);
    cout<<endl;

    return 0;
}


#include <iostream>
#include "Graph.h"
using namespace std;

void creat_graph(MGraph *ga)
{
//    cout<<"请输入顶点数"<<endl;
//    cin>>ga->vex_num;
//    cout<<"请输入边数"<<endl;
//    cin>>ga->arc_num;
    printf("输入顶点数和边数: ");
    scanf("%d%d", &ga->vex_num,&ga->arc_num);    
    fflush(stdin);

    //输入顶点编号
    printf("==============================\n");
    printf("输入各个顶点:\n");
    for (int i = 0; i < ga->vex_num; i++) {
        printf("请输入第%d个结点:", i+1);
        cin>>ga->vexs[i];
//        fflush(stdin);
    }

    //初始化邻接矩阵都为无穷大
    for(int i=0; i<ga->vex_num; i++)
    {
        for(int j=0; j<ga->vex_num; j++)
        {
            ga->arcs[i][j].adj = INFINITY;
        }
    }

    //输入边
    printf("==============================\n");
    int vex_a, vex_b, w;
    for (int i = 0; i < ga->arc_num; i++) {
        printf("请输入存在边的两端顶点(Vi,Vj) 和 权值 w: ");
        scanf("%d%d%d",&vex_a, &vex_b, &w);
        ga->arcs[vex_a-1][vex_b-1].adj = ga->arcs[vex_b-1][vex_a-1].adj = w;
    }
}

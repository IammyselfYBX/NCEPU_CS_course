
#include <iostream>
#include "Graph.h"

using namespace std;

void creat_net(NetGraph *ga)
{
//    cout<<"请输入顶点数"<<endl;
//    cin>>ga->vex_num;
//    cout<<"请输入弧数"<<endl;
//    cin>>ga->arc_num;
    printf("输入顶点数和边数: ");
    scanf("%d%d", &ga->vex_num,&ga->arc_num);
    fflush(stdin);

    //输入顶点编号
    for (int i = 0; i < ga->vex_num; i++) {
        cin>>ga->vexs[i];
    }

    //初始化邻接矩阵都为无穷大
    for(int i=0; i<ga->vex_num; i++)
    {
        for(int j=0; j<ga->vex_num; j++)
        {
            ga->arcs[i][j].adj = MAXINT;
        }
    }

    //输入边
    int vex_a, vex_b;
    VRType value;
    for (int i = 0; i < ga->arc_num; i++) {
        printf("请输入存在边的两端顶点的数字i,j: ");
        scanf("%d,%d",&vex_a, &vex_b);
        printf("请输入该弧的权值:");
        scanf("%lf", &value);
        ga->arcs[vex_a-1][vex_b-1].adj = value;
    }
}

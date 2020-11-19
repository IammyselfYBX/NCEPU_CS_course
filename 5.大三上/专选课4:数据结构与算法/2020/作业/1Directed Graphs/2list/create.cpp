#include "Graph.h"
#include <iostream>
using namespace std;

void creat_net(ALGraph &gb)
{
    cout<<"请输入顶点数"<<endl;
    cin>>gb.vex_num;
    cout<<"请输入弧数"<<endl;
    cin>>gb.arc_num;

    //输入顶点信息
    for (int i = 0; i < gb.vex_num; i++) {
        cin>>gb.vertices[i].data;
        gb.vertices[i].firstarc = NULL;
    }

    //输入边
    int vex_a, vex_b;
    VRType value;
    for (int i = 0; i < gb.arc_num; i++) {
       printf("请输入存在边的两端顶点的数字i,j: ");
        scanf("%d,%d",&vex_a, &vex_b);
        ArcNode *p = (ArcNode *)malloc(sizeof(ArcNode));
        p->adjvex=vex_b; //该弧指向 vex_b
        p->nextarc = gb.vertices[i].firstarc;    //头插法
        printf("请输入该弧的权值:");
        scanf("%lf", &value); 
        p->info = value;

    }
}


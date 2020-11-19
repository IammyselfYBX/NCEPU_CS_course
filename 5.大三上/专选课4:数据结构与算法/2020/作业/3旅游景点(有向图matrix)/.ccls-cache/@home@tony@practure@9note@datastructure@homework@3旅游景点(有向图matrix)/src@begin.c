#include <stdio.h>
#include "Graph.h"

void begin(NetGraph *G)
{
    char y_o;
    printf("  _/          _/            _/                                    ");
    printf(" _/          _/    _/_/    _/    _/_/_/    _/_/    _/_/_/      _/_/");
    printf("_/    _/    _/  _/_/_/_/  _/  _/        _/    _/  _/    _/  _/_/_/_/");
    printf(" _/  _/  _/    _/        _/  _/        _/    _/  _/    _/  _/");
    printf("  _/  _/        _/_/_/  _/    _/_/_/    _/_/    _/    _/    _/_/_/");
    printf("在使用之前请先创建一个有向图(Y/N):");
    fflush(stdin);//注意前bai面要清空输入缓冲du区字符
    scanf("%c",&y_o);
    if(y_o=='Y'|| y_o=='y')
    {
        creat_graph(&G); //创建图的邻接矩阵
    }else{
        exit(0);
    }

}

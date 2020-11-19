#include "Graph.h"
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
    NetGraph G;

    char y_o;

    system("clear");//清屏
    printf("============================================================================\n");
    printf("  _/          _/            _/                                              \n");
    printf(" _/          _/    _/_/    _/    _/_/_/    _/_/    _/_/_/  _/_/      _/_/   \n");
    printf("_/    _/    _/  _/_/_/_/  _/  _/        _/    _/  _/    _/    _/  _/_/_/_/  \n");
    printf(" _/  _/  _/    _/        _/  _/        _/    _/  _/    _/    _/  _/         \n");
    printf("  _/  _/        _/_/_/  _/    _/_/_/    _/_/    _/    _/    _/    _/_/_/    \n");
    printf("\n");
    printf("\t\t\t旅游管理程序\n");
    printf("\t\t\t\t\tAuthor:计算1702 杨秉学\n");
    printf("\n");
    //printf("\e[字背景颜色;字体颜色m字符串\e[0m" );
    printf("\e[41;32m 在使用之前请先创建一个有向图(Y/N)(默认是Y): \e[0m");
    fflush(stdin);//注意前bai面要清空输入缓冲du区字符
    scanf("%c",&y_o);
    if(y_o=='Y'|| y_o=='y' || y_o=='\n')
    {
        creat_graph(&G); //创建图的邻接矩阵
    }else{
        printf("欢迎再次使用\n");
        exit(0);
    }

    system("clear");//清屏

    while(1){
        printf("\n\n\n=====================================\n");
        printf("旅游景点管理程序(邻接矩阵 有向图)\n");
        printf("1.打印图的邻接矩阵\n");
        printf("2.添加顶点\n");
        printf("3.添加边\n");
        printf("4.图的深度优先遍历(递归遍历)\n");
        printf("5.图的深度优先遍历(非递归遍历)\n");
        printf("6.图的广度优先遍历\n");
        printf("7.Prim算法\n");
        //printf("8.Kruskal算法\n");
        printf("8.Dijkstra算法\n");
        printf("9.Floyd算法\n");
        printf("10.退出\n");
        printf("=====================================\n");
        printf("> ");
        int option=0;
        fflush(stdin);
        scanf("%d", &option);
        getchar();

        int result=0;
        switch(option){
            case 1:
                printf("图的邻接矩阵为：\n");
                DisNetGraph(&G);
                break;
            case 2:
                result=addvex(&G);
                if(result == -1)
                {
                    printf("添加失败\n");
                    break;
                }else if(result == 0){
                    printf("添加成功\n");
                    break;
                }
            case 3:
                result=addarc(&G);
                if(result == -1)
                {
                    printf("添加失败\n");
                    break;
                }else if(result == 0){
                    printf("添加成功\n");
                    break;
                }
            case 4:
                printf("图的深度优先遍历(递归遍历): ");
                DFSTraverse_recursion(G);
                break;
            case 5:
                printf("图的深度优先遍历(非递归遍历): ");
                DFSTraverse(G);
                break;
            case 6:
                printf("图的广度优先遍历: ");
                BFSTraverse(&G);
                break;
            case 7:
                printf("Prim算法(打印最小生成树的边)\n");
                prim(G);
                break;
           // case 8:
           //     Kruskal(G);
           //     break;
            case 8:
                printf("是否需要指定顶点(如果是N的话，打印全部顶点)[Y/N](默认是N)");
                fflush(stdin);
                scanf("%c", &y_o);
                if(y_o=='Y'|| y_o=='y')
                {
                    int tmp =0;
                    printf("请输入需要打印的顶点(1-%d):", G.vex_num);
                    fflush(stdin);
                    scanf("%d", &tmp);
                    if(tmp>G.vex_num || tmp < -1)
                    {
                        printf("输入错误!\n");
                        break;
                    }else{
                        printf("顶点%c的全部最短路径为\n", G.vexs[tmp-1]);
                        dijkstra(G,tmp-1);
                        break;
                    }
                }else if(y_o=='N'||y_o=='n' ||y_o=='\n'){  
                    for (int i = 0; i < G.vex_num; i++) {
                        printf("-----------------------------------\n");
                        printf("顶点%c的全部最短路径为\n", G.vexs[i]);
                        dijkstra(G,i);
                    }
                    break;
                }else{
                    printf("对不起，输入错误！！！\n");
                    break;
                }
            case 9:
                floyd(G);
                break;
            case 10:
                printf("欢迎再次使用\n");
                exit(0);
            default :
                printf("输入错误\n");
        }
    }

    return 0;
}

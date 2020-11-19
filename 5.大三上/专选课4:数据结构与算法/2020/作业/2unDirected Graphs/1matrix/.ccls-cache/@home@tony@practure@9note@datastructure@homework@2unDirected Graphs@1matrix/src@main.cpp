#include <iostream>
using namespace std;
#include "Graph.h"

int main(int argc, char *argv[])
{
     MGraph G;

    creat_graph(&G);

    printf("\n图的深度优先遍历为: ");
    DFSTraverse(G);    

    printf("\n图的广度优先遍历为: ");
    BFSTraverse(&G);

    printf("\n");


    return 0;
}

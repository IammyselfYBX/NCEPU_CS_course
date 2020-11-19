#include "Graph.h"
#include <stdlib.h>
#include <stdio.h>

Bool visited[MAX_VEXTEX_NUM];  //全局数组,记录图中节>点访问状态
//输出
void DisMGraph(MGraph *G)
{
    int i, j, k;
    k = G->vex_num;
    for (i=0; i<k; ++i)
    {
        for (j=0; j<k; ++j)
        {
            printf("%5d ", G->arcs[i][j].adj);
        }
        putchar('\n');
    }
}


/****************************************/
//图的深度优先遍历
void DFS(MGraph G, int i)
{
    int j;
    visited[i] = TRUE;
    printf("%c ",    G.vexs[i]);

    for (j=0; j<G.vex_num; ++j)
    {
        if (G.arcs[i][j].adj != INFINITY  &&  !visited[j])
            DFS(G, j);
    }
}

void DFSTraverse(MGraph G)
{
    int i;
    for (i=0; i<G.vex_num; ++i)
        visited[i] = FALSE;

    for (i=0; i<G.vex_num; ++i)
    {
        if (!visited[i])
            DFS(G, i);
    }

}


//图的广度优先遍历
void BFSTraverse(MGraph *G)
{
    int i, j;
    Queue Q;

    for (i=0; i<G->vex_num; ++i)
        visited[i] = FALSE;

    InitQueue(&Q);

    for (i=0; i<G->vex_num; ++i)
    {
        if (!visited[i])
        {
            visited[i] = TRUE;
            printf("%c ", G->vexs[i]);
            EnQueue(&Q, i);

            while (!QueueEmpty(&Q))
            {
                DeQueue(&Q, &i);
                for (j=0; j<G->vex_num; ++j)
                {
                    if (!visited[j] && G->arcs[i][j].adj!=INFINITY)
                    {
                        visited[j] = TRUE;
                        printf("%c ", G->vexs[j]);
                        EnQueue(&Q, j);
                    }
                }
            }
        }
    }
}

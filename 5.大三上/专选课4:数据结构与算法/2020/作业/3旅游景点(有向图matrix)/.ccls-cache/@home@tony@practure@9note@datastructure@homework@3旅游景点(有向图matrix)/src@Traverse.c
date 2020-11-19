#include "Graph.h"
#include "Queue.h"
#include "Stack.h"
#include <stdlib.h>
#include <stdio.h>

Bool visited[MAX_VEXTEX_NUM];  //全局数组,记录图中节>点访问状态
/*
 * 递归实现 深度遍历
 *     1.初始化 visited 数组
 *     2.访问的结点i的visited数组置 TRUE
 *     3.输出该结点i信息
 *     4.判断结点i有没有其他相邻没有被访问的结点(矩阵第i行其他i列不是 INFINITY并且 visited[j]!=TRUE)
 *        有则访问
 *        没有则本层递归结束返回到上层递归中
 * */
void DFS_recursion(NetGraph G, int i)
{
    int j;
    visited[i] = TRUE;
    printf("%c ", G.vexs[i]);

    for (j=0; j<G.vex_num; ++j)
    {
        if (G.arcs[i][j].adj != INFINITY  &&  !visited[j])
            DFS_recursion(G, j);
    }
}

void DFSTraverse_recursion(NetGraph G)
{
    int i;
    //初始化 visited 数组
    for (i=0; i<G.vex_num; ++i)
    {
        visited[i] = FALSE;
    }

    for (i=0; i<G.vex_num; ++i)
    {
        if (!visited[i])
            DFS_recursion(G, i);
    }
}

/*
 * 非递归深度遍历基本思想
 *     1.初始化栈
 *     2.输出起始的顶点，起始顶点改为“已访问”的标志，将起始顶点进栈
 *     3.重复一下的操作直至栈为空：
 *     4.取栈顶元素顶点，存在着未被访问的邻结点W
 *     5.输出顶点W，将顶点W改为“已访问”，将W进栈；
 *       否则，当前顶点退栈
 *    n=G.vex_num;
 * */
void DFSTraverse(NetGraph G){
    Stack s;
    InitStack(&s);
    int s_pop; //用来标记出栈的值(这里是矩阵顶点下标)
    int ves=G.vex_num;
    //初始化 visited 数组
    for (int i = 0; i < ves; i++) {
        visited[i]=FALSE;
    }

    //先把 结点i 的全部邻接点全部压栈
    //这样的目的是防止有的结点没有被任何顶点指向
    for(int i = 0; i<ves; i++)
    {
        //如果被访问过了，就直接跳过该结点下一个
        if(visited[i]==TRUE)
        {
            continue;;
        }else{
            // 没被访问则访问
            visited[i]=TRUE;
            printf("%c ", G.vexs[i]);
            DFS(G, i, &s);

            while(!Isempty(&s))
            {
                s_pop = pop(&s);
                if(visited[s_pop]==FALSE){
                  visited[s_pop] = TRUE;
                  printf("%c ", G.vexs[s_pop]);
                  DFS(G, s_pop, &s);
                }
            }
        }
    }
}
//就是将图G的第i个结点相邻的邻接点全部压入栈s
void DFS(NetGraph G, int i, Stack *s)
{
    int ves = G.vex_num;
    for (int j = 0; j < ves; j++) {
        if(G.arcs[i][j].adj != INFINITY && !visited[j]){
            //visited[j]=TRUE;  //表示虽然还没访问，但是已经压入栈中了，避免多次压栈先设为TRUE
            push(s, j);
        }
    }
}

//图的广度优先遍历
void BFSTraverse(NetGraph *G)
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

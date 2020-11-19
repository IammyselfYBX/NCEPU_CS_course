/*
 * Last-Modified: 2020年 11月 08日 星期日 11:22:50 KST
 * Fuction:深度优先遍历，广度优先遍历
 * */
#include "Graph.h"
#include <stdlib.h>
#include <stdio.h>

Bool visited[MaxSize];  //全局数组,记录图中节点访问状态

void DFS(ALGraph *G, int i){
    visited[i] = TRUE;
    printf("%c ", G->vertices[i].data);

    EdgeNode *p = G->vertices[i].firstedge;
    while(p){
        if(!visited[p->adjvex]){
            DFS(G,p->adjvex); //递归深度遍历
        }
        p= p->next;
    }
}

/**
 * 深度优先遍历
 */
void DFSTraverse(ALGraph *G){
    int i;
    for (i=0; i<G->vex_num; ++i){
        visited[i] = FALSE;  //初始化访问数组visited的元素值为false
    }
    for (i=0; i<G->vex_num; ++i){
        if(!visited[i]){ //节点尚未访问
            DFS(G,i);
        }
    }
}

/**
 * 图的广度优先遍历
 */
void BFSTraverse(ALGraph *G){
    int i;
    Queue *Q = (Queue *)malloc(sizeof(Queue));

    for (i=0; i<G->vex_num; ++i){
        visited[i] = FALSE;
    }
    initQueue(Q);

    for (i=0; i<G->vex_num; ++i){
        if(!visited[i]){
            visited[i] = TRUE;
            printf("%c ", G->vertices[i].data);
            EnQueue(Q, i);

            while (!QueueEmpty(Q)){
                DeQueue(Q, &i);
                EdgeNode *p = G->vertices[i].firstedge;
                while (p){
                    if (!visited[p->adjvex]){
                        visited[p->adjvex] = TRUE;
                        printf("%c ", G->vertices[p->adjvex].data);
                        EnQueue(Q, p->adjvex);
                    }
                    p = p->next;
                }
            }
        }
    }
}

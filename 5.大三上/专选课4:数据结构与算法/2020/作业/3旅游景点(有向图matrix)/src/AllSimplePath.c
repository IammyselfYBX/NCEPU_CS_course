/*
 * 打印两顶点全部简单路径
 * */
#include "Graph.h"
#include <stdio.h>

void SimplePath(NetGraph G, int i, int j)
{
	int m;
	int on[MAX_VEXTEX_NUM];
	for(m = 1; m <= G.vex_num; m++)
		on[m] = FALSE;
	DFS_Path(G, i, j, on);
}

void DFS_Path(NetGraph G, int i, int j, int on[])
{
	static int n = 0;
	static VertexType vertex[MAX_VEXTEX_NUM];//存储走过的路径
	int m;
	GraphArc *p;
	on[i] = TRUE;
	n++;
	vertex[n] = G.vexs[i];
	if(i == j)
	{
		for(m = 1; m <= n; m++)
			printf("%c", vertex[m]);
		printf("\n");
	}

	p = G.vertices[i].firstarc;
	while(p)
	{
		if(!on[p->adjvex])
			DFS(G, p->adjvex, j, on);
		p = p->nextarc;
	}
	on[i] = FALSE;
	n--;
}



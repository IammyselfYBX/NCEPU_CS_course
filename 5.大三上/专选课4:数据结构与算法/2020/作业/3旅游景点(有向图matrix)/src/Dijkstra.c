/*
 * Function:实现 Dijkstr算法
 * Author:杨秉学
 * */
#include "Graph.h"
#include <stdio.h>

/*
 * Dijkstr算法——求某源点到其余各点的最短路径
 *  思路：
 *    1.引进两个辅助数组来记录 源点 到其他顶点的路径长度和路径集合
 *        一维dist[]：dist[i]是Vi到 源点 的路径长度
 *        二维path[][]：path[i]表示源点到 Vi 需要经过的顶点下标
 *                      path[i][]从源点到 Vi 需要经过的顶点依次是 path[i][0]，path[i][1]。。。
 *    2.初始化
 *    // 初始化dist[]
 *        if(Vi——>Vj)   //而且权值为8(就是G.arcs[i][j].adj=8)
 *        {
 *            dist[j]=G.arcs[i][j].adj;
 *        }else{
 *            dist[j]=INFINITY;
 *        }
 *
 *    // 初始化path[][]
 *        if(Vi——>Vj){
 *            path[j][0]=i;
 *            for(k=2; K<G.vex_num; k++)
 *            {
 *                path[j][k]=-1;
 *                if(j==i)  //就是 j 不能等于 i
 *                {
 *                    continue;
 *                }
 *            }
 *        }
 * */
// 求下标 v 的结点 到其他结点间最短距离
void dijkstra(NetGraph G, int v)
{
    int dist[MAX_VEXTEX_NUM];
    int path[MAX_VEXTEX_NUM][MAX_VEXTEX_NUM];

    //初始化 
    for(int i = 0; i < G.vex_num; i++) {
        // 先让 path[][] 全部为 -1
        for (int j = 0; j < G.vex_num; j++) {
            path[i][j] = -1;
        }
        // 将矩阵的值赋值给dist[]
        // 如果dist的值不为0而且存在则
        //    1.把 下标v 的结点放在 path[j][0] 的位置
        //    2.把 j 放在 path[j][1] 的位置
        for (int j = 0; j < G.vex_num; j++) {
            dist[j] = G.arcs[v][j].adj;
            if(dist[j] != 0 && dist[j] != INFINITY ){
                path[j][0] = v;
                path[j][1] = j;
            }
        }
    }

    int flag=1, n=0;
    //从小到大找最短路径
    while(flag)
    {
        int min=INFINITY, k=0;
        // (选择排序) 
        // 找 dist[] 中最小值 放到 min里面
        //    最小值对应的数组下标 放到 k 里面
        for (int j = 0; j < G.vex_num; j++) {
            if(dist[j] != 0 && dist[j] < min) 
            {
                k = j;
                min = dist[j];
            }
        }

        // 显示最短路径
        if(min != INFINITY)
        {
            printf("第%d条最短路径长度为%d,具体路径：", ++n, min);
            for (int m = 0; m < G.vex_num; m++) {
                if(path[k][m] != -1)
                {
                    printf("%c->", G.vexs[path[k][m]]);
                }
            }
            printf("\b\b    \n");//
        }

        //更新 dist 和 path
        int m=0;
        for (int j = 0; j < G.vex_num; j++) {
            if(j!=k && dist[j]!=0)//&&dist[j]!=INFINITY)
            {
                if (dist[k] + G.arcs[k][j].adj<dist[j]) {
                    dist[j] = dist[k] + G.arcs[k][j].adj;
                    //将path[k] 复制到 path[j]中
                    for (m = 0; m < G.vex_num; m++) {
                        path[j][m] = path[k][m];
                    }
                    //找 path[j] 的最后一个数据的下标，即第i个-1的下标
                    for ( m = 0; m < G.vex_num && path[j][m] != -1;) {
                        m++;
                    }
                    path[j][m]=j;
                }
            }
        }
        dist[k] = 0;

        // 判断 dist路径 是否求完，flag为1，表示继续求，否则完成
        flag = 0;
        for (int j = 0; j < G.vex_num; j++) {
            if (dist[j] != 0 && dist[j] < INFINITY) {
                flag = 1;
            }
        }
    }
}

 

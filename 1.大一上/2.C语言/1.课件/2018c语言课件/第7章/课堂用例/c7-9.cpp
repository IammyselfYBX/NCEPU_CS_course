/*编写函数实现学生成绩按平均分排名*/
#include "stdio.h"
#define M 5       /*学生人数*/
#define N 5       /*成绩科数*/

void sort_score(float score[][N], float ave[]);        /*函数声明*/
void main(void)
{
	float score[M][N] = {                              /*学生成绩*/
		{80.0, 85.0, 78.0, 97.0, 68.0},
		{90.0, 97.0, 89.0, 88.0, 92.0},	
		{60.0, 75.0, 79.0, 95.0, 56.0},
		{98.0, 61.0, 78.0, 99.0, 68.0},
		{80.0, 89.0, 98.0, 97.0, 88.0}};
	float ave[M];                                      /*平均成绩*/
	int i, j;

	sort_score(score, ave);                            /*函数调用*/

	for(i = 0;i < M; i++)                     /*按排名输出学生成绩*/
	{
		printf("第%d名学生的平均成绩为：%.2f\n", i+1, ave[i]);
		for(j = 0;j < N; j++)
			printf("%10.2f",score[i][j]);
		printf("\n");
	}
}

void sort_score(float score[][N], float ave[])       /*函数定义*/
{
  float sum,temp;
  int i,j,k;

  for(i = 0;i < M; i++)                              /*计算平均成绩*/
  {
	  sum = 0;
	  for(j = 0;j < N; j++)
		  sum = sum + score[i][j];
	  ave[i] = sum/N;
  }

  for(i = 0;i < M-1; i++)                            /*将平均成绩排序*/
	  for(j = i+1;j < M; j++)
	  {
		  if(ave[i] < ave[j])
		  {
			  temp = ave[i];
			  ave[i] = ave[j];
			  ave[j] = temp;
			  for(k = 0;k < N; k++)                 /*同时将学生成绩排序*/
			  {
				  temp = score[i][k];
				  score[i][k] = score[j][k];
				  score[j][k] = temp;
			  }
		  }
	  }
}

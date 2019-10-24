/*寻找数组中的最大元素（使用全局变量）*/
#include "stdio.h"
#define N 10

float array[N];                       /*全局变量*/
float max_array();                    /*函数声明*/

void main(void)
{
	float max;
	int i;
	printf("请输入%d个实数:\n",N);
	for(i = 0;i < N; i++)
		scanf("%f",&array[i]);        /*全部变量使用*/
	max = max_array();                /*函数调用*/
	printf("数组中最大元素是：%.2f",max);
}

float max_array()                     /*函数定义*/
{
  int i;
  float max;

  max = array[0];                     /*全局变量使用*/

  for(i = 1;i < N; i++)
	  if(array[i] > max)
		  max = array[i];

  return max;
}

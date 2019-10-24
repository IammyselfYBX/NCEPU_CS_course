/*求数组中元素的最大值*/
#include "stdio.h"
#define N 10
float max_array(float a[], int n);             /*函数声明*/
void main(void)
{
	float array[N], max;
	int i;
	printf("请输入%d个实数：\n",N);
	for(i = 0;i < N; i++)
		scanf("%f",&array[i]);

	max = max_array(array, N);                 /*函数调用*/
	printf("最大的数组元素值是：%.2f",max);
}

float max_array(float a[], int n)             /*函数定义*/
{
  int i;
  float max;
  max = a[0];
  for(i = 1;i < n; i++)
	  if(a[i] > max)
		  max = a[i];
  return max;
}

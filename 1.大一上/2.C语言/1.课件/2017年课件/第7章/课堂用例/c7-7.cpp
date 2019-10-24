/* 比较两个数组的大小 */
#include "stdio.h"
#define N 5
int cmp_array(int a[], int b[], int length);          /*函数声明*/
void main(void)
{
	int a[N], b[N], cmp;
	int i;
	printf("请输入数组1：%d个整数：\n", N);          /*输入数据*/
	for(i = 0;i < N; i++)
		scanf("%d",&a[i]);
	printf("请输入数组2：%d个整数：\n", N);
	for(i = 0;i < N; i++)
		scanf("%d",&b[i]);
	cmp = cmp_array(a,b,N);                           /*函数调用*/
	if(cmp > 0)										  /*输出结果*/
		printf("数组1大于数组2\n");
	else if(cmp < 0)
		printf("数组1小于数组2\n");
	else
		printf("数组1等于数组2\n");
}

int cmp_array(int a[], int b[], int length)           /*函数定义*/
{
  int i, result, m ,n, k;
  m = n = k = 0;
  for(i = 0;i < length; i++)                          /*计算m，n和k*/
	  if(a[i] > b[i])
		  m++;
	  else if(a[i] < b[i])
		  n++;
	  else
		  k++;

  if(m > n) 
	  result = 1;
  else if(m < n)
	  result = -1;
  else
	  result = 0;

  return result;  /*返回结果，1代表a大于b，0代表a等于b，-1代表a小于b*/
}

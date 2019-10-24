/*编写函数计算数组元素的均方差*/
#include "stdio.h"
#include "math.h"
#define N 10

float average(float a[], int n);             /*函数声明*/
float variance(float a[], int n, float ave);     /*函数声明*/
float rms(float a[], int n);                 /*函数声明*/

void main(void)
{
	float x[N], var;
	int i;
	printf("输入%d个数值：\n",N);
	for(i = 0;i < N; i++)                    /*读入数值*/
		scanf("%f", &x[i]);
	var = rms(x, N);                         /*函数调用*/
	printf("这些数值的均方差为：%.4f\n", var);
}

float average(float a[], int n)              /*函数定义*/
{
	int i;
	float sum = 0.0;
	for(i = 0;i < n; i++)
		sum = sum + a[i];
	return sum/n;                            /*返回数组的平均值*/
}

float variance(float a[], int n, float ave)  /*函数定义*/
{
	int i;
	float var;
	var = 0.0;
	for(i = 0;i < n; i++)
		var = var + pow((a[i] - ave),2);    /*计算方差*/
	return var;
}

float rms(float a[], int n)                 /*函数定义*/
{
	int i;
	float ave,var;
	ave = average(a, n);
	var = variance(a, n, ave);
	var = sqrt(var);                       /*计算均方差*/
	return var;
}

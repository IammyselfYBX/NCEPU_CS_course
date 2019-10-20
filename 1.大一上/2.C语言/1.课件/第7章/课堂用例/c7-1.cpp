/*计算平均值*/
#include "stdio.h"
void main(void)
{
	float x, y, z;
	float average(float a, float b);          /*函数声明*/

	printf("输入3个数值：");
	scanf("%f%f%f",&x,&y,&z);

	printf("%.2f和%.2f的平均值为：%.2f\n",x,y,average(x, y));  /*函数调用*/
	printf("%.2f和%.2f的平均值为：%.2f\n",y,z,average(y, z));  /*函数调用*/
	printf("%.2f和%.2f的平均值为：%.2f\n",x,z,average(x, z));  /*函数调用*/

}

float average(float a, float b)               /*函数定义*/
{
	float c;
	c = (a+b)/2;
	return c;
}

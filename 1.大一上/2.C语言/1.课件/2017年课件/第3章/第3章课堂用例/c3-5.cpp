#include <stdio.h>
#include <math.h>
void main(void)
{
	float a,b,c,s,area;
	printf("请输入三角形的三边：\n", &a, &b, &c);
	scanf("%f%f%f", &a, &b, &c);
	if(a+b>c&&abs(a-b)<c)
	{
		s=(a+b+c)/2;
		area=sqrt(s*(s-a)*(s-b)*(s-c));
		printf("area=%f\n",area);
	}
	else
		printf("输入数据错误！\n");
}

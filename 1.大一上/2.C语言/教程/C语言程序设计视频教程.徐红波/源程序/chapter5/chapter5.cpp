// chapter5.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

#include <math.h>

int main(int argc, char* argv[])
{
	/*int x;
	scanf("%d", &x);
	if(x > 0)
		printf("x is positive\n");
	else
		printf("x is negative\n");*/

	/*int a, b, c;
	a=1;
	b=2;
	c=3;

	//printf("%d\n", c>a+b);
	//printf("%d\n", a>b==c);
	//printf("%d\n", a==b<c);
	printf("%d\n", a=b>c);*/

	/*int a, b, c, d, f;
	a=1;
	b=2;
	c=3;
	printf("%d\n", 5==3);
	printf("%d\n", 5>=0);
	printf("%d\n", a>b);
	printf("%d\n", (a>b)==c);
	printf("%d\n", b+c<a);
	printf("%d\n", d=a>b);
	printf("%d\n", f=a>b>c);*/

	/*int a, b, c, x, y;
	a=1;
	b=2;
	c=3;
	x=4;
	y=5;
	printf("%d\n", !a&&b||x>y&&c);
	// 0||0=0
	printf("%d\n", a>b&&x>y);
	//0&&0=0
	printf("%d\n", a==b||x==y);
	//0||0=0
	printf("%d\n", !a||a>b);
	//0||0=0*/

	//printf("%d\n", 'c'&&'d');

	/*int a=1, b=2, c=3, d=4, m=1, n=1;
	printf("%d\n", (m=a>b) && (n=c>d));
	printf("m=%d,n=%d\n", m, n);*/

	/*int year;
	scanf("%d", &year);
	if(year%4==0 && year%100!=0 || year%400==0)
	{
		printf("%d是闰年\n", year);
	}
	else
	{
		printf("%d不是闰年\n", year);
	}*/

	/*int x, y;
	x=2;
	y=1;
	if(x>y) 
		printf("x=%d\n", x);
	else
		printf("y=%d\n", y);*/

	//if(3) printf("ok\n");

	//if('a') printf("%d", 'a');
	/*float x=1.0;
	if(x>0)
		printf("%f", x);
	else
		printf("%f", -x);*/

	/*double a, b, c, s, area;
	scanf("a=%lf,b=%lf,c=%lf", &a, &b, &c);
	if(a+b>c&&b+c>a&&c+a>b)
	{
		s=(a+b+c)/2;
		area=sqrt(s*(s-a)*(s-b)*(s-c));
		printf("area=%lf\n", area);
	}
	else
		printf("三边不能组成一个三角形\n");*/

	/*if(a>b) 
		max=a;
	else
		max=b;*/
	/*int a, b, max;
	a=2;
	b=3;
	max=1;

	max= a>b ? a : b;

	printf("max=%d\n", max);*/

	//max= a>b ? a : b;

	
	//(a>b) ? a : (b+1)
	/*int a, b, c, d;
	a=1;
	b=2;
	c=3;
	d=4;
	printf("%d\n", a>b ? a : c>d ? c : d);*/
	/*int a=2;
	int b=1;
	//printf("%d\n", a>b ? (a=100) : (b=200));
	//a>b ? printf("%d\n", a) : printf("%d\n", b);
	int x, y;
	x=1;
	y=0;
	x ? 'a' : 'b';
	double d = x>y ? 1 : 1.5;
	printf("d=%lf\n", d);*/

	char grade;
	scanf("%c", &grade);

	switch(grade)
	{
	case 'A': 
	case 'B':
	case 'C':
		printf(">=60\n");
		break;
	case 'D':
		printf("<60\n");
		break;
	default:
		printf("error\n");
		break;
	}







	return 0;
}


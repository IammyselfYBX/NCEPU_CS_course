#include <stdio.h>
long sum(int a,int b);
long factorial(int n);
void main()
{
	int n1,n2;
	long a;
	
	scanf("%d%d",&n1,&n2);
	a=sum(n1,n2);
	printf("a=%1d",a);
}

long sum(int a,int b)
{
	long c1,c2;
	c1=factorial(a);
	c2=factorial(b);
	return(c1+c2);
}

long factorial(int n)
{
	long result;
	if(n<=1)
		result = 1;
	else
		result = n*factorial(n-1);
	return result;
}

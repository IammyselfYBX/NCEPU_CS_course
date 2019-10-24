#include <stdio.h>
int *larger(int *,int *); 
void main()
{
	int a,b,*p;
	scanf("%d%d",&a,&b);
	p=larger(&a,&b);
	printf("较大的数是 %d\n",*p);
}
int *larger(int *x,int *y)
{
	if(*x>*y)
		return x;
	else
		return y;
}

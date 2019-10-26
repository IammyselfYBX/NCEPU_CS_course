#include "stdafx.h"

void swap(int * x, int * y);

int main(int argc, char* argv[])
{
	int a, b;
	scanf("%d,%d", &a, &b);

	if(a<b)
		swap(&a, &b);

	printf("max=%d min=%d\n", a, b);

	return 0;
}

void swap(int * x, int * y)
{
	//int * temp;
	int i;
	//temp=&i;
	//*temp=*x;//i=a;
	i=*x;
	*x=*y;//a=b;
	//*y=*temp;//b=i;
	*y=i;
}
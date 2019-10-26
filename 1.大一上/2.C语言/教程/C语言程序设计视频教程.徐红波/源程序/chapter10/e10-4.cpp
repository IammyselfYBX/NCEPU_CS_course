#include "stdafx.h"

void swap(int * x, int * y);
void exchange(int * q1, int * q2, int * q3);

int main(int argc, char* argv[])
{
	int a, b, c;
	scanf("%d,%d,%d", &a, &b, &c);

	exchange(&a, &b, &c);

	printf("%d %d %d\n", a, b, c);

	return 0;
}

void exchange(int * q1, int * q2, int * q3)
{
	if(*q1 < *q2) swap(q1, q2);
	if(*q1 < *q3) swap(q1, q3);
	if(*q2 < *q3) swap(q2, q3);
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
#include "stdafx.h"

int main(int argc, char* argv[])
{
	int * p1, * p2, a, b;
	scanf("%d, %d", &a, &b);
	p1=&a;
	p2=&b;
	if(a<b)
	{
		p1=&b;
		p2=&a;
		/*int * temp;
		temp=p1;
		p1=p2;
		p2=temp;*/
	}
	printf("a=%d,b=%d\n", a, b);
	printf("max=%d,min=%d\n",*p1,*p2); 

	


	return 0;
}
#include "stdafx.h"

int main(int argc, char* argv[])
{	
	int a, b, c;
	int temp;
	scanf("a=%d b=%d c=%d", &a, &b, &c);
	if(a>b)
	{
		temp=a;
		a=b;
		b=temp;		
	}
	if(b>c)
	{
		temp=b;
		b=c;
		c=temp;		
	}
	if(a>b)
	{
		temp=a;
		a=b;
		b=temp;		
	}
	printf("a=%d b=%d c=%d\n", a, b, c);



	return 0;
}
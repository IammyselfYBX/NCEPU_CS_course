// chapter2.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

int main(int argc, char* argv[])
{
	float sum, term, deno;
	int sign;
	sum=1.0;
	deno=2;
	sign=1;
	while(deno <= 100)
	{
		sign=-1*sign;
		term=sign*1/deno;
		sum=sum+term;
		deno=deno+1;
	}
	printf("1-1/2+1/3+...+1/99-1/100=%f", sum);

	return 0;
}
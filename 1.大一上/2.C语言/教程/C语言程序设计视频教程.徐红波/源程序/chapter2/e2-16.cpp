// chapter2.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

int main(int argc, char* argv[])
{
	int t;
	int i;
	t=1;
	i=2;
	while(i <= 5)
	{
		t=t*i;
		i=i+1;
	}
	printf("5!=%d\n", t);

	return 0;
}
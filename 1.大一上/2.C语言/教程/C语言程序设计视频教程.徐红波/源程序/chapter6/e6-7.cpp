#include "stdafx.h"

int main(int argc, char* argv[])
{
	int f1=1, f2=1;
	for(int i=1; i<=20; i++)
	{
		printf("%d %d\n", f1, f2);
		f1=f1+f2;
		f2=f2+f1;
	}

	return 0;
}
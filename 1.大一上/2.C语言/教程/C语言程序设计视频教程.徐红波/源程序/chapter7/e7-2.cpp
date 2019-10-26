#include "stdafx.h"

int main(int argc, char* argv[])
{
	//int f1, f2, f3, f4;
	/*f1=1;
	f2=1;

	f3=f1+f2;

	f4=f3+f2;

	f5=f4+f3;

	....
	f20=f19+f18;*/
	int f[20];
	f[0]=1;
	f[1]=1;
	printf("%12d", f[0]);
	printf("%12d", f[1]);
	for(int i=2; i<=19; i++)
	{
		f[i]=f[i-1]+f[i-2];
		printf("%12d", f[i]);
		if((i+1)%5 == 0)
			printf("\n");		
	}

	return 0;
}
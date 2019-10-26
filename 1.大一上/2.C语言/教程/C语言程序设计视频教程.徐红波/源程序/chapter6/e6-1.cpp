#include "stdafx.h"

int main(int argc, char* argv[])
{
	//1+2+...+100
	int i;
	i=1;
	int sum;
	sum=0;
label1:	if(i <= 100)
	{
		sum+=i;//sum=sum+i
		i++;//i=i+1
		goto label1;
	}

	printf("1+2+3+...+100=%d\n", sum);
	return 0;
}

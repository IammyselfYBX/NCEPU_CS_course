#include "stdafx.h"

int main(int argc, char* argv[])
{
	int sum, i;
	sum=0;
	scanf("%d", &i);
	
	/*while(i<=10)
	{
		sum=sum+i;
		i++;
	}*/

	//printf("i=%d\n", i);

	do
	{
		sum=sum+i;
		i++;
	} while(i<=10);

	printf("i=%d\n", i);

	printf("sum=%d\n", sum);

	return 0;
}
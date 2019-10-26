// chapter6.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"

#include "math.h"

int main(int argc, char* argv[])
{
	//printf("Hello World!\n");

	/*for(int i=1; i<=10; i++)
	{
		for(int j=1; j<=10; j++)
		{
			printf("i=%d j=%d\n", i, j);

			if(i+j == 5)
				goto label_1;
		}
	}

label_1 : printf("提前退出了循环\n");*/
	
	/*int sum, i;
	sum=0;
	for(i=1;i<=100;i++)
	{
		sum=sum+i;
	}

	i=1;
	while(i<=100)
	{
		sum=sum+i;
		i++;
	}

	printf("i=%d\n", i);
	printf("1+2+3..100=%d\n", sum);*/

	/*int i;
	char c;
	//for(i=0;(c=getchar()) != '\n'; i+=c) ;

	for(;(c=getchar())!='\n';)
		printf("%c", c);
	
	printf("\n");*/


	/*int j=1;
	while(1)
	{
		for(int i=1; i<=10; i++)
		{
			printf("i=%d\n", i);
		}

		j++;

		if(j==5)
		{
			break;
		}
	}*/

	/*int r;
	float area;
	float pi=3.14;
	for(r=1;r<=10;r++)
	{
		area=pi*r*r;
		if(area > 100) break;
		printf("r=%d area=%f\n", r, area);
	}

	printf("r=%d area=%f\n", r, area);*/

	return 0;
}


#include "stdafx.h"

enum color {red, yellow, blue, white, black};

int main(int argc, char* argv[])
{
	enum color i, j, k;

	int n=0;

	for(i=red; i<=black; i++)
	{
		for(j=red; j<=black; j++)
		{
			for(k=red; k<=black; k++)
			{
				if(i != j && i != k && j != k)
				{
					n++;

					switch(i)
					{
					case red:	printf("first: red   ");
					case yellow:printf("first: yellow");
					case blue:	printf("first: blue  ");
					case white:	printf("first: white ");
					case black:	printf("first: black ");
					}

					switch(j)
					{
					case red:	printf(" second: red   ");
					case yellow:printf(" second: yellow");
					case blue:	printf(" second: blue  ");
					case white:	printf(" second: white ");
					case black:	printf(" second: black ");
					}

					switch(k)
					{
					case red:	printf(" third: red   ");
					case yellow:printf(" third: yellow");
					case blue:	printf(" third: blue  ");
					case white:	printf(" third: white ");
					case black:	printf(" third: black ");
					}



				}
			}
		}
	}



	

	
	return 0;
}
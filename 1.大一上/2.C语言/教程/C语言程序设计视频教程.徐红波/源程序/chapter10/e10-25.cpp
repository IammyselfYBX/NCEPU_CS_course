#include "stdafx.h"

int * search(int (*p)[4]);

int main(int argc, char* argv[])
{
	int score[][4]={{100,200,300,400},{5,6,7,8},{9,10,11,12}};

	for(int i=0; i<3; i++)
	{
		int * p=search(score+i);

		if(p != *(score+i))
		{
			printf("student number=%d\n", i);
			for(int j=0; j<4; j++)
				printf("%d ", *(*(score+i)+j));
			printf("\n");
		}
	}

	return 0;
}

int * search(int (*p)[4])
{
	for(int i=0; i<4; i++)
		if(*(*p+i)<60)
			return *(p+1);
	
	return *p;
}
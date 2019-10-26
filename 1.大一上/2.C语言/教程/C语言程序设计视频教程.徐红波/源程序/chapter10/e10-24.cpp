#include "stdafx.h"

int * search(int n, int (*p)[4]);

int main(int argc, char* argv[])
{
	int score[][4]={{1,2,3,4},{5,6,7,8},{9,10,11,12}};

	//score score[0] score[1] score[2]
	int * p=search(1, score);

	for(int i=0; i<4; i++)
		printf("%d ", *(p+i));

	return 0;
}

int * search(int n, int (*p)[4])
{
	return *(p+n);		//*(p+n)==score[n]
}




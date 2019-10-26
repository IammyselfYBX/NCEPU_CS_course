#include "stdafx.h"

void search(float (*p)[4], int n)
{
	for(int i=0; i<n; i++)
	{
		int flag=0;
		for(int j=0; j<4; j++)
			if(*(*(p+i)+j) < 60.0)	
			{
				flag=1;
				break;
			}

		if(flag==1)
		{
			printf("%d:", i);
			for(int j=0; j<4; j++)
				printf("%f ", *(*(p+i)+j));
			printf("\n");			
		}				
	}
}

int main(int argc, char* argv[])
{
	float score[3][4]={{65,6,70,60},{80,87,90,81},{9,99,100,98}};
	
	search(score, 3);

	return 0;
}
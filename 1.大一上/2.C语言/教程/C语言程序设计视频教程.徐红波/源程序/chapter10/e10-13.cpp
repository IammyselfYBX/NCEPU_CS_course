#include "stdafx.h"

float average(float * p, int n)
{
	float * start;
	float sum=0.0;
	for(start=p;p<=start+n-1; p++)
		sum+=*p;
	return sum/n;
}

void search(float (*p)[4], int n)
{
	for(int i=0; i<4; i++)
		printf("%f ", *(*(p+n)+i));
	printf("\n");
}

int main(int argc, char* argv[])
{
	float score[3][4]={{65,67,70,60},{80,87,90,81},{90,99,100,98}};

	printf("average=%f\n", average(*score, 12));//*score==score[0]
	
	search(score, 2);

	return 0;
}


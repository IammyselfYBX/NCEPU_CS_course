#include "stdafx.h"

float average(float grade[], int n);

void main()
{
	float score1[10]={1,2,3,4,5,6,7,8,9,10};
	float score2[5]={1,2,3,4,5};

	printf("score1: %f\n", average(score1, 10));
	printf("score2: %f\n", average(score2, 5));

}

float average(float grade[], int n)
{
	float sum=0.0;
	for(int i=0; i<n; i++)
		sum=sum+grade[i];

	return sum/n;
}
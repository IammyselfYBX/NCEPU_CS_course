#include "stdafx.h"

float average(float grade[10]);

void main()
{
	float score[10]={1,2,3,4,5,6,7,8,9,10};

	printf("%f\n", average(score));	

}

float average(float grade[])
{
	float sum=0.0;
	for(int i=0; i<10; i++)
		sum=sum+grade[i];

	return sum/10;
}

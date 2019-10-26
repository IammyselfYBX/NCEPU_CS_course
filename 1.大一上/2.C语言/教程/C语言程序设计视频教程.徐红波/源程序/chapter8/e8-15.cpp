#include "stdafx.h"

int Max, Min;

int average(int score[], int n);

void main()
{
	int score[10];
	for(int i=0; i<10; i++)
		scanf("%d", &score[i]);

	int aver;
	aver=average(score, 10);

	printf("average: %d\n", aver);
	printf("max    : %d\n", Max);
	printf("min    : %d\n", Min);	
}

int average(int score[], int n)
{
	int sum=score[0];
	Max=score[0];
	Min=score[0];
	for(int i=1; i<n; i++)
	{
		sum=sum+score[i];
		if(score[i] > Max) Max=score[i];
		if(score[i] < Min) Min=score[i];
	}

	return sum/n;
}
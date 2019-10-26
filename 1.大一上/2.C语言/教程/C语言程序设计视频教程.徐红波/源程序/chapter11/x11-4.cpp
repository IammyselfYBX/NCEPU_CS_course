#include "stdafx.h"

typedef struct student
{
	int num;
	char name[20];
	float score[3];
} STUDENT;

void print(struct student * p, int n)
{
	printf("num        name      score[0]     score[1]     score[2]\n");
	for(int i=0; i<n; i++)
		printf("%5d %20s %10.2f %10.2f %10.2f\n", (p+i)->num, (p+i)->name, 
			(p+i)->score[0], (p+i)->score[1], (p+i)->score[2]);
}

void input(struct student * p, int n)
{
	for(int i=0; i<n; i++)
	{
		printf("input element i:\n", i);
		scanf("%d %s %f %f %f", &p[i].num, p[i].name, 
			&p[i].score[0], &p[i].score[1], &p[i].score[2]);
	}
}
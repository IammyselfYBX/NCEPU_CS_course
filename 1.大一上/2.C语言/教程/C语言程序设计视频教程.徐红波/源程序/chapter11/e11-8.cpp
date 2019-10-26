#include "stdafx.h"

#include <malloc.h>

struct student
{
	long num;
	float score;
	struct student * next;
};

int n=0;

struct student * create(void)
{
	struct student * head;
	struct student * p;
	struct student * tail;

	head=NULL;

	p=(struct student *)malloc(sizeof(struct student));
	scanf("%ld %f", &p->num, &p->score);

	while(p->num != 0)
	{
		if(head==NULL)
			head=p;
		else
			tail->next=p;

		tail=p;

		n++;

		p=(struct student *)malloc(sizeof(struct student));
		scanf("%ld %f", &p->num, &p->score);
	}

	tail->next=NULL;

	return head;
}

int main(int argc, char* argv[])
{
	struct student * head=create();

	struct student * p=head;

	while(p != NULL)
	{
		printf("node[num=%ld,score=%f]\n", p->num, p->score);
		p=p->next;
	} 
	
	return 0;
}
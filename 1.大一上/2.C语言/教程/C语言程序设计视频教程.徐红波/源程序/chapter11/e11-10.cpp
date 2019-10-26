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

void print(struct student * head)
{
	struct student * p=head;
	while(p != NULL)
	{
		printf("node[num=%ld,score=%f]\n", p->num, p->score);
		p=p->next;
	} 
}

struct student * del(struct student * head, long num)
{
	struct student * p1, * p2;

	if(head == NULL)
	{
		return head;
	}
	else
	{
		p1=head;
		p2=NULL;
		while(p1->num != num && p1 != NULL)
		{
			p2=p1;
			p1=p1->next;
		}
		if(p1->num == num)
		{
			if(p1 == head)
				head=p1->next;
			else
				p2->next=p1->next;
		}
		free(p1);
	}

	return head;
}

int main(int argc, char* argv[])
{
	struct student * head=create();

	printf("before delete\n");
	print(head);

	head=del(head, 4);
	printf("after delete\n");
	print(head);
	
	return 0;
}
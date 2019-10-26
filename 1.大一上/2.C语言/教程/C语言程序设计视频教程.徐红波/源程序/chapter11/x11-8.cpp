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
		while(p1 != NULL && p1->num != num)
		{
			p2=p1;
			p1=p1->next;
		}
		if(p1!=NULL)
		//if(p1->num == num)
		{
			if(p1 == head)
				head=p1->next;
			else
				p2->next=p1->next;

			free(p1);
		}
	}

	return head;
}

struct student * insert(struct student * head, long num, float score)
{
	struct student * p=(struct student *)malloc(sizeof(struct student));

	p->num=num;
	p->score=score;

	if(head == NULL)
	{
		head=p;
		p->next=NULL;			
	}
	else
	{
		p->next=head;
		head=p;
	}
	return head;
}

int main(int argc, char* argv[])
{
	struct student * a_head;
	struct student * b_head;
	
	printf("create link a:\n");
	a_head=create();
	print(a_head);

	printf("create link b:\n");
	b_head=create();
	print(b_head);

	struct student * c_head;

	c_head=NULL;

	struct student * p_a;
	struct student * p_b;

	p_a=a_head;
	p_b=b_head;

	while(p_a != NULL && p_b != NULL)
	{
		if(p_a->num < p_b->num)
		{
			c_head=insert(c_head, p_b->num, p_b->score);
			p_b=p_b->next;	
		}
		else
		{
			c_head=insert(c_head, p_a->num, p_a->score);
			p_a=p_a->next;	
		}
	}

	if(p_a == NULL)
	{
		while(p_b != NULL)
		{
			c_head=insert(c_head, p_b->num, p_b->score);
			p_b=p_b->next;	
		}
	}
	else
	{
		while(p_a != NULL)
		{
			c_head=insert(c_head, p_a->num, p_a->score);
			p_a=p_a->next;	
		}
	}

	printf("print link c:\n");
	print(c_head);
	
	return 0;
}
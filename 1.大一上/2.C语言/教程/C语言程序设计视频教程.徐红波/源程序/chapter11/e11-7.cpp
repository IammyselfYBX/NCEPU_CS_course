#include "stdafx.h"

struct student
{
	long num;
	float score;

	struct student * next;
};

int main(int argc, char* argv[])
{
	struct student a, b, c;
	struct student * head;

	a.num=99101;
	a.score=89.5;
	b.num=99103;
	b.score=90;
	c.num=99107;
	c.score=85;

	head=&a;
	a.next=&b;
	b.next=&c;
	c.next=NULL;

	struct student * p;
	p=head;
	while(p != NULL)
	{
		printf("num:%ld score:%f\n", p->num, p->score);
		p=p->next;
	}

	return 0;
}
#include "stdafx.h"

struct student
{
	int num;
	char name[20];
	char sex;
	int age;
};

struct student stu[3]={	{10101, "Li Lin", 'M', 18},
						{10102, "Zhang Fun", 'M', 19},
						{10104, "Wang Min", 'F', 20} };

int main(int argc, char* argv[])
{
	struct student * p;
	for(p=stu; p<stu+3; p++)
	{
		printf("num:%d name:%s sex:%c age:%d\n",
				p->num, p->name, p->sex, p->age);
	}	

	return 0;
}
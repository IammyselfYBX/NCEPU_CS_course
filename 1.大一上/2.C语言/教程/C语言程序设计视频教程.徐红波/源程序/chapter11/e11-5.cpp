#include "stdafx.h"

#include <string.h>

struct student
{
	int num;
	char name[20];
	float score[3];
};

int main(int argc, char* argv[])
{
	struct student stu;
	stu.num=12345;
	strcpy(stu.name, "Li Li");
	stu.score[0]=67.5;
	stu.score[1]=89;
	stu.score[2]=78.6f;

	void print(struct student);
	print(stu);	

	return 0;
}

void print(struct student s)
{
	printf("num:%-6d name:%20s\n", s.num, s.name, s.score);
	for(int i=0; i<3; i++)
		printf("score[%d]=%f ", i, s.score[i]);
	printf("\n");
}

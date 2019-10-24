#include <stdio.h>
#include <string.h>

struct student
{
	int   num;
	char  name[20];
	float score[3];
};

void Print(struct student*);
void main()
{
	struct student stu;

	stu.num = 1001;
	strcpy(stu.name,"Li Hong");
	stu.score[0] = 66;
	stu.score[1] = 78;
	stu.score[2] = 89;
	Print(&stu);
}

void Print(struct student *pstu)
{
	printf("%d\n%s\n%f\n%f\n%f\n",pstu->num, pstu->name, 
		  pstu->score[0],pstu->score[1],pstu->score[2]);
}




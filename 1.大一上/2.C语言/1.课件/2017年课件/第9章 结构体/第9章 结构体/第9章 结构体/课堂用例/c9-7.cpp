#include <stdio.h>

struct student
{
    int num;
    char *name;
    char sex;
    float score;
}boy[5]={
          {101,"Li ping",'M',45},
          {102,"Zhang ping",'M',62.5},
          {103,"He fang",'F',92.5},
          {104,"Cheng ling",'F',87},
          {105,"Wang ming",'M',58},
        };
void main()
{
	struct student *p;
	printf("No. Name     Sex  age\n");
	for(p=boy; p<boy+5; p++)
		printf("%5d %-20s %2c %4f\n",p->num,p->name,p->sex,p->score);
}


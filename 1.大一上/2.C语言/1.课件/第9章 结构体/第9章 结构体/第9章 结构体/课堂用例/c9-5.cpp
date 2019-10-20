#include <stdio.h>
#include <string.h>

struct person{
  char name[20];
  int  count;
}leader[3] = {"Li",0, "Zhang",0, "Wang",0};

void main()
{
    char name[20];

	printf("input 10 names:\n");
	for(int i=1; i<=10; i++)
	{
		scanf("%s",name);
		for(int j=0; j<3; j++)
			if(strcmp(name,leader[j].name) == 0)
				leader[j].count++;
	}
	printf("result:\n");
	for(i=0; i<3; i++)
		printf("%5s:%d\n",leader[i].name, leader[i].count);
}

#include "stdafx.h"

struct record
{
	int num;
	char name[10];
	char sex;
	char job;//if job=s student; job=t teacher
	union 
	{
		int banji;
		char position[10];
	} category;
} person[2];


int main(int argc, char* argv[])
{
	for(int i=0; i<2; i++)
	{
		scanf("%d %s %c %c", 
			&person[i].num, person[i].name, 
			&person[i].sex, &person[i].job);

		if(person[i].job == 's')
			scanf("%d", &person[i].category.banji);
		else
			scanf("%s", person[i].category.position);
	}

	for(i=0; i<2; i++)
		if(person[i].job=='s')
			printf("%d %s %c %c %d\n", person[i].num, person[i].name,
				person[i].sex, person[i].job, person[i].category.banji);
		else
			printf("%d %s %c %c %s\n", person[i].num, person[i].name,
				person[i].sex, person[i].job, person[i].category.position);

	return 0;
}
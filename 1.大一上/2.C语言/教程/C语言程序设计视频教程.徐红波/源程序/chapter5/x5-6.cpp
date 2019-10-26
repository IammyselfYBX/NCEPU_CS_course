#include <stdafx.h>

void main()
{
	int grade;
	scanf("%d", &grade);
	if(grade >= 90)
	{
		printf("%d->%c\n", grade, 'A');
	}
	else
	{
		if(grade >= 80)
		{
			printf("%d->%c\n", grade, 'B');
		}
		else
		{
			if(grade >= 70)
			{
				printf("%d->%c\n", grade, 'C');
			}
			else
			{
				if(grade >= 60)
					printf("%d->%c\n", grade, 'D');
				else
					printf("%d->%c\n", grade, 'E');		
			}
		}
	}
}
#include "stdafx.h"

int main(int argc, char* argv[])
{
	char * name[5]={"Follow me","BASIC","Great Wall","FORTRAN","Computer design"};

	char * * p;

	p=name+1;

	/*for(int i=0; i<5; i++)
	{
		p=name+i;
		printf("%s\n", *p);
	}*/

	printf("%c\n", *(*p+1));
	


	




	


	return 0;
}
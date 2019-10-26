#include "stdafx.h"

int main(int argc, char* argv[])
{
	struct student
	{
		long int num;
		char name[20];
		char sex;
		char addr[20];
	} a={89031, "Li Lin", 'M', "123 Beijing Road"};

	printf("num:%ld\nname:%s\nsex:%c\naddr:%s\n", 
		      a.num, a.name, a.sex, a.addr);






	return 0;
}

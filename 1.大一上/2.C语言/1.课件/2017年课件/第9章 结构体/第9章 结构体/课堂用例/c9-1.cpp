#include <stdio.h>
void main()
{
    struct student
	{
		long int num;
		char name[20];
		char addr[20];
	}a = {89031, "Li Lin", "123 Beijing Road"};
	printf("No.:%ld\nname:%s\naddress:%s\n",a.num,a.name,a.addr);
}

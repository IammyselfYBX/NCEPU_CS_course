#include "stdafx.h"

int main(int argc, char* argv[])
{
	int a[3][4]={{1,3,5,7},{9,11,13,15},{17,19,21,23}};

	printf("%x,%x\n", a, *a); //*a==a[0]

	printf("%x,%x\n", a[0], *(a+0));//*(a+0)==a[0]

	printf("%x,%x\n", &a[0], &a[0][0]);//&a[0]==a+0

	printf("%x,%x\n", a[1], a+1);

	printf("%x,%x\n", &a[1][0], *(a+1)+0); //*(a+1)==a[1]

	printf("%x,%x\n", a[2], *(a+2)); //*(a+2)==a[2]

	printf("%x,%x\n", &a[2], a+2);

	printf("%d,%d\n", a[1][0], *(*(a+1)+0));












	


	


	return 0;
}
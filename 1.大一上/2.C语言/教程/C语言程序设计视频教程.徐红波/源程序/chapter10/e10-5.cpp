#include "stdafx.h"

int main(int argc, char* argv[])
{
	int a[10];
	/*for(int i=0; i<10; i++)
		scanf("%d", &a[i]);

	for(i=0; i<10; i++)
		printf("%d ", a[i]);*/

	/*for(int i=0; i<10; i++)
		scanf("%d", a+i);

	for(i=0; i<10; i++)
		printf("%d ", *(a+i));*/
	
	int * p;
	p=a;
	for(int i=0; i<10; i++)
		scanf("%d", p+i);

	for(i=0; i<10; i++)
		printf("%d ", *(p+i));








	return 0;
}
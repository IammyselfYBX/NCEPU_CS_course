#include <stdio.h>
void main()
{
	int a[2][2]={1,2,3,4};
	int i;
	for (i=0; i<2; i++) 
	{
		printf("a+%d = %x", i,a+i);
		printf("\t *(a+%d)= %x", i,*(a+i));
		printf("\t a[%d]= %x", i,a[i]);
		printf("\t *(*(a+%d))= %d\n", i,*(*(a+i)));
	}
	for (i=0; i<2; i++) 
	{
		printf("a[0]+%d= %x", i,a[0]+i);
		printf("\t *(a[0]+%d)= %d\n", i,*(a[0]+i));
	}
}

#include "stdafx.h"

int main(int argc, char* argv[])
{
	char a[]="I am a boy.", b[20];

	for(int i=0; *(a+i)!='\0'; i++)
	{
		*(b+i)=*(a+i);
		//*(a+i)==a[i]   *(b+i)==b[i]
	}
	*(b+i)='\0';

	/*for(i=0; b[i]!='\0'; i++)
		printf("%c", b[i]);
	printf("\n");*/
	printf("%s\n", b);
	
	return 0;
}
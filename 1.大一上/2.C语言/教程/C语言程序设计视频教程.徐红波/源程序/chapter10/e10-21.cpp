#include "stdafx.h"

int main(int argc, char* argv[])
{
	/*char * a="I love China!";
	printf("The sixth character is %c\n", *(a+5));//a[5]==*(a+5)

	for(int i=0; *(a+i) != '\0'; i++)
		printf("%c", a[i]);
	printf("\n");*/

	char * format="a=%d,b=%d\n";

	int a=1, b=2;
	printf(format, a, b);

	return 0;
}
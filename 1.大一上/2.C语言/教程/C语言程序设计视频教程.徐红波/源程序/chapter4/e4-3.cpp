#include <stdafx.h>

main()
{
	unsigned int a=4294967295;
	//111111111111111111111111111 32个1
	signed int b=-2;
	//111111111111111111111111110 31个1, 最右边1位为0
	printf("a=%d,%o,%x,%u\n",a,a,a,a);
	printf("b=%d,%o,%x,%u\n",b,b,b,b);

	return 0;
}
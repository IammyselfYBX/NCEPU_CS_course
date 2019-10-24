/*用%d、%o和%x输入输出整型数据*/
#include <stdio.h>
void main(void)
{
	int a, b, c;
	printf("输入a，b，c，分别为八进制、十进制和十六进制：\n");
	scanf("%o%d%x",&a, &b ,&c);
	printf("%o，%d，%x\n",a, a, a);
	printf("%o，%d，%x\n",b, b, b);
	printf("%o，%d，%x\n",c, c, c);
}

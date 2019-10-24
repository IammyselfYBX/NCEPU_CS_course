#include <stdio.h>
void main()
{
	int i;
	char ch[4];
	printf("输入4个字符:");
	scanf("%c%c%c%c", &ch[0], &ch[1], &ch[2], &ch[3]);
	printf("这些字符是:");
	for(i=0;i<4;i++)
		printf("%c", ch[i]);
	printf("\n");
}

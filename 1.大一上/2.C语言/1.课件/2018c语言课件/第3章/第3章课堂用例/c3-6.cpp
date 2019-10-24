#include <stdio.h> 
void main(void)
{
    int a, b, c, max;
    printf("输入三个数: ");
 	scanf("%d%d%d", &a, &b, &c);
	    max=a;
    if(b>max) max=b;
  	if(c>max) max=c;
 	printf("%d 是最大数\n", max);
}

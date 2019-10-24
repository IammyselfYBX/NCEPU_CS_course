#include <stdio.h>
void main()
{
	int i,a[10];   /* 定义了一个数组a，它有10个元素 */
	/* 给数组中的每个元素按顺序赋值 */
	for(i=0;i<=9;i++)
		a[i]=i;
	/* 逆序输出数组中各元素的值 */
	for(i=9;i>=0;i--)
		printf("%d  ",a[i]);
	printf("\n");    
}

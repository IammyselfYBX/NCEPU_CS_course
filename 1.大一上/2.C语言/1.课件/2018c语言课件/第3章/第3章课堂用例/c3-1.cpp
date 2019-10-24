#include <stdio.h>
void main(void)
{  
	int x, y;                   	/*定义变量x和y*/
	printf("请输入x的值：");
	scanf("%d", &x);             	/*从键盘上输入x*/
	if(x>0)                      	/*判断x的值是否大于0*/
		y=x*x;                 	/*如果x>0，则y= x2*/
	else                        	/*如果x不大0，即x小于等于0*/
		y=0;                   	/*如果x<=0，则y=0*/
	printf("y=%d\n", y);          	/*输出y的值*/
}

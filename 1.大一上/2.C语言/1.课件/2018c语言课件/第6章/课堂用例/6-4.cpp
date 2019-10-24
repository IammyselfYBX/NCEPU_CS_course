#include <stdio.h>
void main()
{
	int i;
	int fib[20];  /* 数组定义 */
	fib[0]=fib[1]=1;   
	
    /* 计算斐波那契数列其余的18个数 */
	for(i=2;i<20;i++)
		fib[i]=fib[i-1]+fib[i-2];
	
	/* 输出斐波那契数列 */
    for(i=0;i<20;i++)
	{
		printf("%8d",fib[i]);
		if((i+1)%5==0)
			printf("\n");
	}
}

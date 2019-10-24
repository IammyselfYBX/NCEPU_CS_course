/*判断1777和1991是否为素数？*/
#include "stdio.h"
#include "math.h"

int prime(int n)                        /*函数定义*/
{
	int k, i, result;                     

	k = sqrt(n);                        /*判断素数*/
	for(i = 2; i <= k; i++)
		if(n%i == 0) break;

	if(i > k)
		result = 1;
	else
		result = 0;

	return result;         /*函数返回值：1代表n是素数，0代表n不是素数*/

}

void main(void)
{
	int a = 1777, b = 1991;
	
	if(prime(a))                        /*函数调用*/
		printf("%d是素数\n",a);
	else
		printf("%d不是素数\n",a);
	
	if(prime(b))                        /*函数调用*/
		printf("%d是素数\n",b);
	else
		printf("%d不是素数\n",b);

}

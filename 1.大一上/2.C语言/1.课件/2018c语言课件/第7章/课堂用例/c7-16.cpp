/*看程序，写结果*/
#include "stdio.h"

void f()
{
	static int a;               /*静态变量*/
	printf ("a=%d\n", a);
	a++;
}

int main(void)
{
	f();                       /*函数调用*/
	f();                       /*函数调用*/
	
	return 0;
}

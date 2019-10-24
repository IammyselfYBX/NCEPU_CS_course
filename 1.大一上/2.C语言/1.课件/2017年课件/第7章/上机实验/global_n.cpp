#include <stdio.h>
int n=1;
void func()
{
	static int x=4;
	int y=10;
	x=x+2;
	y=y+n;
	n=n+y;
}
void main()
{
	static int x=5;
	int y;
	y=n;
	func();
	func();
	printf("%d\n",n);
}

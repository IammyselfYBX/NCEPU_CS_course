#include <stdio.h>
void swap(int x,int y)
{
	int t;
	printf("交换前：x=%d,y=%d\n",x,y);
	t=x;
	x=y;
	y=t;
	printf("交换后：x=%d,y=%d\n",x,y);
}
void main()
{
	int a,b;
	scanf("%d%d",&a,&b);
	printf("调用前：a=%d,b=%d\n",a,b);
	swap(a,b);
	printf("调用后：a=%d,b=%d\n",a,b);
}

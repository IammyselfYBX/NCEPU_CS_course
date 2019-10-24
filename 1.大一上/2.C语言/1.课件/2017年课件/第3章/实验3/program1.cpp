#include <stdio.h>
void main(void)
{
	int  a=3,b=4,c=5;
	printf("a=%d,b=%d,c=%d\n",a,b,c);
	printf("a+b || b++ 的值为:%d\n", a+b || b++ );    /* 输出逻辑表达式的值*/ 
	printf("a=%d,b=%d,c=%d\n",a,b,c);
	printf("b==c && c++ 的值为:%d\n", b==c && c++);    
	printf("a=%d,b=%d,c=%d\n",a,b,c);
	printf("a<b<c 的值为:%d\n",a<b<c);         
	printf("!a<b 的值为:%d\n", !a<b); 
}

#include <stdio.h>
void main()
{
	float i=3.456;
	int a,b,c,d;
	
	a=(int)(i); 
	b=(int)(i*10)%10;
	c=(int)(i*100)%10;
	d=(int)(i*1000)%10;
	
	printf("%d,%d,%d,%d",a,b,c,d);
}

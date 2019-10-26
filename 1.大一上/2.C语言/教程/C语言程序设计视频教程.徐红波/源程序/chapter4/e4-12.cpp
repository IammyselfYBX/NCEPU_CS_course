#include <stdafx.h>

#include <math.h>

void main()
{
	float a, b, c;
	scanf("%f %f %f", &a, &b, &c);
	//if(b*b-4*a*c > 0)
	//{	
		printf("x1=%lf\n", (-b-sqrt(b*b-4*a*c))/(2*a));
		printf("x2=%lf\n", (-b+sqrt(b*b-4*a*c))/(2*a));
	//}
	//else
	//{
	//	printf("无两个不同的实根！");
	//	return;
	//}
}
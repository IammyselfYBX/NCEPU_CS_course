#include <stdafx.h>

void main()
{
	double p, w, d;
	int s;
	scanf("%lf %lf %d", &p, &w, &s);

	if(s<=0)
	{
		printf("路程不能为0或负数\n");
		return;
	}

	int c=s/250;
	switch(c)
	{
	case 0:
		//s<250
		d=0.0;
		break;
	case 1:
		d=0.02;
		break;
	case 2:
		//[500, 750)
	case 3:
		//[750, 1000)
		d=0.05;
		break;
	case 4:
	case 5:
	case 6:
	case 7:
		//[1000, 2000)
		d=0.08;
		break;
	case 8:
	case 9:
	case 10:
	case 11:
		//[2000, 3000)
		d=0.1;
		break;
	default:
		d=0.15;
		break;
	}

	printf("总运费%lf\n", p*w*s*(1-d));
}
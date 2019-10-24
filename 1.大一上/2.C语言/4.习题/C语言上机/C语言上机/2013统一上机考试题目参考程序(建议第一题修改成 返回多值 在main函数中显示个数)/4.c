//4.输入一数组，将最大值最小值交换
#include"stdio.h"
main()
{
	float a[10],t;
	int i,max=0,min=0;
	for(i=0;i<10;i++)
		scanf("%f",&a[i]);
	for(i=0;i<10;i++)
	{
		if(a[i]>a[max])
			max=i;
		if(a[i]<a[min])
			min=i;
	}
	t=a[min];
	a[min]=a[max];
	a[max]=t;
	for(i=0;i<10;i++)
		printf("%f ",a[i]);
}
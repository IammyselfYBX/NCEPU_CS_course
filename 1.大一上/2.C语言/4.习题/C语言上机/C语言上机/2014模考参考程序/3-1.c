//1. .输入一数组，将最大值最小值交换
#include"stdio.h"
main()
{
	int a[10],i,max=0,min=0,t;
	for(i=0;i<10;i++)
		scanf("%d",&a[i]);
	for(i=0;i<10;i++)
		if(a[i]>a[max])
			max=i;
	for(i=0;i<10;i++)
		if(a[i]<a[min])
			min=i;
	t=a[max];
	a[max]=a[min];
	a[min]=t;
	for(i=0;i<10;i++)
		printf("%d ",a[i]);
}
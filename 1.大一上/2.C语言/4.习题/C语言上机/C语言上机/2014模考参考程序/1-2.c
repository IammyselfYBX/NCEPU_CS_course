//2.用函数实现对任意一组实数从大到小的选择法排序，用主函数调用该函数输出排序的结果。
#include"stdio.h"
#define n 10
void sort(float a[])
{
	int index,i,j;
	float t;
	for(i=0;i<n-1;i++)
	{
		for(j=i+1,index=i;j<n;j++)
			if(a[j]>a[index])
				index=j;
		t=a[i];
		a[i]=a[index];
		a[index]=t;
	}
}
main()
{
	float a[10];
	int i;
	for(i=0;i<10;i++)
		scanf("%f",&a[i]);
	sort(a);
	for(i=0;i<10;i++)
		printf("%f ",a[i]);
}

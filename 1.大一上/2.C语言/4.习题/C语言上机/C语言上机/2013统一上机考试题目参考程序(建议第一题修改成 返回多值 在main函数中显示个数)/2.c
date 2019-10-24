//2.任意输入一组实数，在指定位置插入指定数输出
#include"stdio.h"
main()
{
	float a[11],n;
	int i,m;
	for(i=0;i<10;i++)
		scanf("%f",&a[i]);
	for(i=0;i<10;i++)
	printf("%f ",a[i]);
	scanf("%d%f",&m,&n);
	for(i=10;i>m;i--)
		a[i]=a[i-1];
	a[m]=n;
	for(i=0;i<11;i++)
		printf("%f ",a[i]);
}

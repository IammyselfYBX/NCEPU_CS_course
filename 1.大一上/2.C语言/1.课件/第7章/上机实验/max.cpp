#include <stdio.h>
#define N 10;
float max(float a[], int n)
void main()
{
	float data[N];
	int i;

	for(i=0;i<N;i++)
		scanf("%f",data[i]);
	printf("max is=%f",max(data[N],N));

}
float max(float a[], int n)
{
	int i,result;

	for(i=0;i<n;i++)
	{
		if(a[i] > result)
			result = a[i];
	}

	return result;
}

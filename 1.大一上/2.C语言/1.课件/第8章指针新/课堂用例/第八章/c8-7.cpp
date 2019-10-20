#include <stdio.h>
void main()
{
	void sort(int a[], int n);

	int ser[100];
	int i, num;

	printf("Input length of serial:\n");
	scanf("%d", &num);

	printf("input serial elements:\n");
	for (i=0; i<num; i++)
		scanf("%d", ser+i);
	
	sort(ser,num);

	printf("The median of serial is %d\n", *(ser+num/2));
}

/* 一维数组排序函数 */
void sort(int a[], int n)
{ 
	int i, temp;
	int *p;
	for(i=0;i<n-1;i++)
		for(p=a;p<a+i-1;p++)
			if(*p>*(p+1))
			{
				temp=*p; 
				*p=*(p+1); 
				*(p+1)=temp;;
			}
}

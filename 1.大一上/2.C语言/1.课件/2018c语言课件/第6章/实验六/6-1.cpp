#include <stdio.h>
void main()
{
	int i,j,num,a[num];
	int change,t;
	printf("Enter Number: ");
	scanf("%d",&num);
	printf("Enter Data: \n");
	for(i=0;i<num;i++)
		scanf("%d",&a[i]);
	for(i=num-1,change=1;i>0 && change;i--)
{
		change=0;
		for(j=0;j<=i;j++)
			if(a[j]>a[j+1])
			{                        /*调试时设置断点*/
				t=a[j]; a[j]=a[j+1];
				a[j+1]=t;  change=1;
			}
	}                               /*调试时设置断点*/
	printf("Sorted data:\n");
	for(i=0;i<num;i++)
		printf("%d ",a[i]);
	printf("\n");
}

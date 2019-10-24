#include <stdio.h>

#define M 20
int fun(int bb[],int n, int y)
{
	int i,j;
	for(i=0;i<n;i++)
	{
		if(bb[i]==y)
		{
			for(j=i;j<n-1;j++)
				bb[j]=bb[j+1];
			n--;
			i--;
		}
	}

	return n;
}
void main()
{ 
	int aa[M]={1,2,3,3,2,1,1,2,3,4,5,4,3,2,1}, n=15, y, k;
	printf("The original data is: \n");
	for(k=0; k<n; k++ ) 
		printf("%d",aa[k]);

	printf("\nEnter a number to deleted: "); 
	scanf("%d",&y);
	n = fun(aa, n, y);

	printf("The data after deleted %d: \n",y);
	for(k=0; k<n; k++ ) 
		printf("%d",aa[k]);
	
	printf("\n\n");
}

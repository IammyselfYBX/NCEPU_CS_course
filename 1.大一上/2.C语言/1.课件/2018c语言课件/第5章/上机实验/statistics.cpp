#include <stdio.h>
void main()
{
		int count1,count2,n;
		scanf("%d",n);
		while (0<=n<=100) 
		{
			if(60<=n<=100)
				count1=+1;
			else
				count2+=1;
		}
		printf("Failed:%d, Pass:%d\n",count2,count1);
}

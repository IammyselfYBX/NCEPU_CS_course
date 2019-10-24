#include <stdio.h>
#include <string.h>
void main()
{
	char temp[20],name[10][20];
	int n,i,j,p;
	printf("请输入N:");
	scanf("%d",&n);
	printf("请输入%d个姓名\n",n);
	getchar();            /* 跳过scanf语句的回车键 */
	for(i=0;i<n;i++)
		gets(name[i]);
	printf("\n");
	for(i=0;i<n-1;i++)
	{
		p=i;
		for(j=i+1;j<n;j++)
			if(strcmp(name[j],name[p])<0) p=j;
		if(p!=i)
		{
			strcpy(temp,name[i]);
			strcpy(name[i],name[p]);
			strcpy(name[p],temp);
		}
	}
    for(i=0;i<n;i++)
		puts(name[i]);
}

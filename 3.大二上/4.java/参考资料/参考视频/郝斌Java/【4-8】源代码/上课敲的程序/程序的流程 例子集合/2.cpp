# include <stdio.h>

int main()
{
	int a[9]={1,2,3,4,5,6,7,8,9};
	int i = 0;
	
	for (i=0;i<9;i++)
		printf("%d",a[i]);
	printf("%d",20);   /* ���������������printf�����{}������������������ */  
	
	return 0;
}

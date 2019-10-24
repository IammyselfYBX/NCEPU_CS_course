#include<stdio.h>
#define N 80
int count(char str[])
{
	int m=0,n=0,k=0;
	int i;
	for(i=0;str[i];i++)
	{
		if(str[i]>='A'&&str[i]<='Z'||str[i]>='a'&&str[i]<='z')
			m++;
		else if(str[i]>='0'&&str[i]<='9')
			n++;
		else
			k++;
	}
	printf("字母%d,数字%d,其他%d",m,n,k);
}
void main()
{
	char str1[N];
	gets(str1);
	count(str1);
}
/*建议修改成 返回多值 在main函数中显示个数*/
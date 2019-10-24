/*将字符串转换为整数*/
#include <stdio.h>
void main(void)
{
	int i,n;
	char s[10];
	
	/* 输入字符串*/
	printf("Enter a string:");  /*输入提示*/
	
	i=0;
	while((s[i]=getchar())!='\n')
		i++;
	s[i]='\0';
	
	/* 将字符串转换为整数*/
	n=0;
	for(i=0;s[i]!='\0';i++)
		if(s[i]<='9'&&s[i]>='0')
			n=n*10+(s[i]-'0');
		else				/* 遇见非数字字符结束转换 */
			break;
		printf("digit=%d\n",n);
}

#include <stdio.h>
void main()
{
	char str1[80],str2[80];        /*声明两个字符数组str1和str2 */
	int i=0,k=0;  
	
	gets(str1);
	gets(str2);
	
	while(str1[i])
		i++;             /* 找到str1中字符的结束标志所在位置 */
	
	while(i<79)
		if(str2[k])
			str1[i++]=str2[k++];   /* 依次将str2中的字符连接到str1的末尾 */
		else
			break;
		str1[i]='\0';      /* 在最后一个字符后写入'\0' */
		
		puts(str1);
}

# include <stdio.h>

int main(void)
{
    int  i=0, s=0;
	
	do
	{ 
		if(i%2)
		{
			i++;
			continue;  /* ����ִ�и��������̻�ת��ִ���ĸ���䡣  */
		}
		i++;
		s+=i;  // s = s + i;
	}while(i < 7);
	
	printf("%d\n",s);   
	
	return 0;
}

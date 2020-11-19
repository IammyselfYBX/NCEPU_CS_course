# include <stdio.h>

int main(void)
{
    int  i=0, s=0;
	
	do
	{ 
		if(i%2)
		{
			i++;
			continue;  /* 考虑执行该语句后流程会转向执行哪个语句。  */
		}
		i++;
		s+=i;  // s = s + i;
	}while(i < 7);
	
	printf("%d\n",s);   
	
	return 0;
}

# include <stdio.h>

int main()
{ 
	int x=1, y=0, a=0, b=0;

	switch(x) // ��һ��switch 
	{  
	case 1:  
		switch(y)  // �ڶ���switch 
		{  
		case 0:  
			a++; 
			break;  
		case 1:  
			b++; 
			break;
		}
		break;  
	case 2: 
		a++;    
		b++;
		break;  
	}
	
	printf("%d %d\n",a,b); //26��
	
	return 0;
}

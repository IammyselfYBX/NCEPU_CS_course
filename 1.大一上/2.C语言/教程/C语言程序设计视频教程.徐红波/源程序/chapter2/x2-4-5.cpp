#include <stdafx.h>

int main(int argc, char * argv[])
{
	int n;
	scanf("n=%d", &n);
	if(n%3==0 && n%5==0)
	{
		printf("%d能够被3和5同时整除\n", n);
	}
	else
	{
		printf("%d不能够被3和5同时整除\n", n);
	}	

	return 0;
} 
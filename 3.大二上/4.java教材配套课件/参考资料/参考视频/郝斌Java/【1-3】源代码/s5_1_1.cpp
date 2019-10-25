# include <stdio.h>
# include <math.h>

int zhouchang(int m, int n, int k)
{
	return m + n + k;
}

double area(int m, int n, int k)
{
	double p = 1.0*(m+n+k) / 2;

	return sqrt(p * (p-m) * (p-n) * (p-k));
}

int main(void)
{
	int a, b, c;
	
	a = 3;
	b = 4;
	c = 5;

	printf("%d,  %lf\n", zhouchang(a,b,c), area(a,b,c));

	return 0;
}
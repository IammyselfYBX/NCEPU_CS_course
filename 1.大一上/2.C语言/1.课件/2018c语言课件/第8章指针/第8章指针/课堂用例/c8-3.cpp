#include <stdio.h>
#include <math.h>
void main()
{
	float a, b, c, t1, t2;
	int flag;
	int solvroot(float a, float b, float c, float *r1, float *r2);

    printf("Input parameters a,b,c:\n");
	scanf("%f,%f,%f", &a, &b, &c);
	flag=solvroot(a, b, c, &t1, &t2);
	if (flag > 0) {
		printf("Two real solutions: x1=%f, x2=%f\n", t1+t2, t1-t2);}
	else if (flag == 0) {
		printf("One solution: x1=x2=%f\n", t1);}
	else {
		printf("Two complex solutions: x1=%f+%fi, x2=%f-%fi\n", t1,t2,t1,t2);}
}

int solvroot(float a, float b, float c, float *r1, float *r2)
{   
	float delta;

	*r1 = -b/(2*a);
	delta = b*b-4*a*c;
	if (delta >= 0) 
	{	*r2 = sqrt(delta)/(2*a);
	} else
	{	*r2 = sqrt(-delta)/(2*a);
	}

	return (int)delta;
}

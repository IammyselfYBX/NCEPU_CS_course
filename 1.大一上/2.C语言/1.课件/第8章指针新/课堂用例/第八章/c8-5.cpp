#include <stdio.h>

long *a, *b, *c;
long *x, *y, *z;
long *tpre(char pref);

void main()
{ 
	char prefa, prefb, prefc;

	printf("请输入三位男士的选择对象（请选择x,y,z）:\n");
	scanf("%c%c%c", &prefa, &prefb, &prefc);
	getchar();
	a=tpre(prefa);
	b=tpre(prefb);
	c=tpre(prefc);
	printf("请输入三位女士的选择对象（请选择a,b,c）:\n");
	scanf("%c%c%c", &prefa, &prefb, &prefc);
	x=tpre(prefa);
	y=tpre(prefb);
	z=tpre(prefc);
	
	printf("&a=%x x=%x\n", &a, x);
	printf("a=%x &x=%x\n", a, &x);
	printf("&a=%x *a=%x\n", &a, *a);
	
	if (&a == (long **)*a) printf("A 先生是幸运的!\n");
	if (&b == (long **)*b) printf("B 先生是幸运的!\n");
	if (&c == (long **)*c) printf("C 先生是幸运的!\n");
}

long *tpre(char pref)
{
	switch (pref) {
		case 'x': return (long *) &x;
		case 'y': return (long *) &y;
		case 'z': return (long *) &z;
		case 'a': return (long *) &a;
		case 'b': return (long *) &b;
		case 'c': return (long *) &c;
	}
}

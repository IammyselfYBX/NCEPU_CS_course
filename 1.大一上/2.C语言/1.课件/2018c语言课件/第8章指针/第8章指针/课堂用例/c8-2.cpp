#include <stdio.h>

char x,y,z;
void assp(char **p, char pref);

void main()
{ 
	char *a, *b, *c, ta, tb, tc;

	printf("请输入三位男士的选择对象（请选择x,y,z）:\n");
	scanf("%c%c%c", &ta, &tb, &tc);
	getchar();
	assp(&a, ta);
	assp(&b, tb);
	assp(&c, tc);
	printf("请输入三位女士的选择对象（请选择a,b,c）:\n");
	scanf("%c%c%c", &x, &y, &z);
	if (*a == 'a') printf("A 先生是幸运的!\n");
	if (*b == 'b') printf("B 先生是幸运的!\n");
	if (*c == 'c') printf("C 先生是幸运的!\n");
}

void assp(char **p, char pref)
{
	switch (pref) {
		case 'x': *p=&x; break;
		case 'y': *p=&y; break;
		case 'z': *p=&z; break;
	}
}

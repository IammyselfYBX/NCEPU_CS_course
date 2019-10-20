#include <stdio.h>
#include <string.h>

struct book
{
	long   num;           //书号
	char   name[20];      //书名
	char   marking;       //售空标志
	float  price;         //价格
};

void main()
{
    struct book boo_1, *p;

	p = &boo_1;

	boo_1.num = 89101;
	strcpy(boo_1.name, "math");
	boo_1.marking = 'T';
	boo_1.price = 30;

	printf("书号:%ld\n书名:%s\n售空:%c\n书价:%f\n", boo_1.num, boo_1.name, boo_1.marking, boo_1.price);
    printf("书号:%ld\n书名:%s\n售空:%c\n书价:%f\n", (*p).num, (*p).name, (*p).marking, (*p).price);
    printf("书号:%ld\n书名:%s\n售空:%c\n书价:%f\n", p->num, p->name, p->marking, p->price);

}

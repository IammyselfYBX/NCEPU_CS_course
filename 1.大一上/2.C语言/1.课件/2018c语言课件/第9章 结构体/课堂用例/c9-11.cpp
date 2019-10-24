#include "stdio.h"
#include "string.h"
#include "process.h"

#define MAXSIZE 50

/*学生信息结构定义*/
struct student{
   char sNo[10];
   char sName[10];
   float fScore[3];
   float fTotal;
};

/*学生信息表结构定义*/
struct sqlist{
	struct student elem[50];
	int length;
};

/*构造一个空表*/
void Init(sqlist *sl)
{
	sl->length = 0;
}

/*输出学生信息表*/
int OutPut(sqlist sl)
{
	if(!sl.length)
	{
		printf("表为空！");
		return 0;
	}

	printf("表如下(包含%d个记录)：",sl.length);
	printf("\n学号\t姓名\t成绩1\t成绩2\t成绩3\t总成绩\t\n ");
	for(int i=0; i<sl.length; i++)
	{
		printf("%s\t%s\t%.2f\t%.2f\t%.2f\t%.2f\t\n",sl.elem[i].sNo,sl.elem[i].sName,
			sl.elem[i].fScore[0],sl.elem[i].fScore[1],sl.elem[i].fScore[2],sl.elem[i].fTotal);
	}
	return 1;
}
/*增加一个学生信息*/
int Append(sqlist *sl, struct student elem)
{
	if(sl->length == 50) 
	{
		printf("表满，不能插入");
		return 0;
	}
	
   sl->elem[sl->length] = elem;
   sl->elem[sl->length].fTotal = 0;

   for(int i=0; i<3; i++)
	    sl->elem[sl->length].fTotal += sl->elem[sl->length].fScore[i];
	sl->length++;
	return 1;
}
/*删除一个学生信息*/
int Delete(sqlist *sl, char *no)
{
	if(!sl->length) 
	{
		printf("表空，不能删除");
		return 0;
	}
	
	for(int i = 0; i < sl->length; i++)
		if(strcmp (sl->elem[i].sNo, no) == 0)
			break;

	if(i < sl->length)                
	{
		for(int j=i; j<sl->length; j++ )
			sl->elem[j] = sl->elem[j+1];
		sl->length--;

		return 1;
	}
	else return 0;

}
/*根据学号查找一个学生信息*/
int Find(sqlist sl, char *no)
{
	for(int i=0; i<sl.length;i++)
		if(strcmp(sl.elem[i].sNo,no)==0)
		{
			printf("找到的学生成绩信息\n%s\t%s\t%f\t%f\t%f\n",sl.elem[i].sNo,
           sl.elem[i].sName,sl.elem[i].fScore[0],sl.elem[i].fScore[1],sl.elem[i].fScore[2]);
		return 1;
		}
	if(i>sl.length-1)
	{
		printf("没有该记录！");
		return 0;
	}
}

main()
{
	char    ch;                      //操作代码
	sqlist   sl;                      //学生表结构变量，存储学生信息
	char    no[10];                  //标志，保存函数返回值
    int     flag;

	printf("/******学生成绩管理系统*****/\n");
	printf("\n本系统基本操作如下：\n  0：退出\n  1：初始化\n  2: 输出\n");
	printf("  3: 插入\n  4: 删除\n  5: 按学号查询\n \n");
	printf("请输入操作提示：(0~5)");
	
	while(1)
	{
		ch = getchar();
		switch(ch)
		{
		case '0':
	        exit(1);
			break;
		case '1':
		    Init(&sl);
			break;
		case '2':
			OutPut(sl);
			break;
		case '3':
			struct  student elem;
			printf("输入插入元素：学号 姓名 成绩1 成绩2 成绩3\n");
			scanf("%s%s%f%f%f",elem.sNo,elem.sName,&elem.fScore[0],&elem.fScore[1],&elem.fScore[2]);
			flag = Append(&sl,elem);
			if(flag) printf("插入成功！");
			else printf("插入失败！");
			break;
		case '4':
			printf("输入删除学号：");
			scanf("%s",no);
			flag = Delete(&sl,no);
			if(flag) printf("删除成功！");
			else printf("删除失败！");
			break;
		case '5':
			printf("输入学号：");
			scanf("%s",no);
			flag = Find(sl,no);
			break;
		default:
			continue;
		}
	    printf("请输入操作提示：(0~6)");	
	}
}

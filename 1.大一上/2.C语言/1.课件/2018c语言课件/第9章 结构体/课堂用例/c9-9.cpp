#include "stdio.h"

#define MAXSIZE 50

/*学生信息结构定义*/
struct student{
   char  no[10];
   char  name[10];
   float score;
};

/*统计成绩等级*/
int GetLevelStatis(struct student *p, int, int lev[]);

void main()
{
	struct student stu[10];              //结构数组定义
       int    level[5] = {0};               //成绩等级数组定义并初始化

	printf("输入10个学生信息：\n");      //输入学生信息
	for(int i=0; i<10; i++)
	{
		scanf("%s%s%f", stu[i].no, stu[i].name, &stu[i].score);
	}

	GetLevelStatis(stu,10,level);         //成绩等级统计

	for(i=0; i<5; i++)                    //输出统计结果
		printf("等级为%c的人数为%d：\n", 'A'+i, level[i]); 

}

int GetLevelStatis(struct student *p, int n, int lev[])
{
	for(int i=0; i<n; i++,p++)
		if(p->score >= 90)
            lev[0]++;
		else if(p->score >= 80)
			lev[1]++;
		else if(p->score >= 70)
			lev[2]++;
		else if(p->score >= 60)
			lev[3]++;
		else
			lev[4]++;
        
		return 1;
}

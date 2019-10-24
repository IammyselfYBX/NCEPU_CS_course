/* 求每个学生平均成绩及每门课程平均成绩 */
#include <stdio.h>
void main()
{
	int sum;
	int i,j,s[5][3];       /* 用数组s存学生的每门课程的成绩 */
	float avg[5]={0},mean[3]={0};  /*avg每个学生的平均分，mean每门课程的平均分*/
	
	/* 获取每个学生的每门课程的成绩，并计算学生平均成绩 */
	for(i=0;i<5;i++)
	{
		printf("No.%d  ",i+1);
		for(sum=0,j=0;j<3;j++)
		{
			scanf("%d",&s[i][j]);
			sum+=s[i][j];
		}
		avg[i]=sum/3.0;
	}
	
	/* 计算每门课程的平均分 */
	for(j=0;j<3;j++)
	{
		for(i=0;i<5;i++)
			mean[j]+=s[i][j];
		mean[j]=mean[j]/5;
	}
	
	/* 输出考试情况 */
	printf("学生  ");
	for(i=0;i<3;i++)
		printf("课程%d ",i+1);
	printf("平均分\n");
	
	for(i=0;i<5;i++)
	{
		printf("No.%d  ",i+1);
		for(j=0;j<3;j++)
			printf("%5d ",s[i][j]);
		printf("%6.1f\n",avg[i]);
	}
	printf("平均: %5.1f %5.1f %5.1f\n",mean[0],mean[1],mean[2]);
}

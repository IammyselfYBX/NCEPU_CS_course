#include <stdio.h>
#include <math.h>

struct stu                //学生结构定义
{
    int num;
    char *name;
    char sex;
    float score;
}boy[5]={
          {101,"Li ping",'M',45},
          {102,"Zhang ping",'M',62.5},
          {103,"He fang",'F',92.5},
          {104,"Cheng ling",'F',87},
          {105,"Wang ming",'M',58},
        };
void main()
{
    int i,c=0;                 //循环控制变量、不及格人数
    float ave,s=0;            //平均成绩、总成绩

    for(i=0;i<5;i++)
    {
      s+=boy[i].score;
      if(boy[i].score<60) c+=1;
    }
    printf("s=%f\n",s);
    ave=s/5;
    printf("average=%f\ncount=%d\n",ave,c);
}

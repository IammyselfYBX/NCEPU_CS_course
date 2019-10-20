#include <stdio.h>
#include <math.h>

float GetDis(struct point,struct point);
struct point{
  float x;
  float y;
};

float GetDis(struct point p1,struct point p2)
{
	return sqrt((p2.x-p1.x) * (p2.x-p1.x) + (p2.y-p1.y) * (p2.y-p1.y) );
}

void main()
{
	struct point pt0 = {0.0,0.0};     //原点
	struct point pt1,pt2,pt3;         //变量定义
	
	printf("Please input pt1:");      //输入提示信息
	scanf("%f%f",&pt1.x,&pt1.y);   //读入pt1
	printf("Please input pt2:");      //输入提示信息
	scanf("%f%f",&pt2.x,&pt2.y);   //读入pt2	

        printf("pt1:(%.1f,%.1f)\npt2:(%.1f,%.1f))",pt1.x,pt1.y,pt2.x,pt2.y);

	pt3 = pt1;
	
	printf("\npt3:(%.1f,%.1f)", pt3.x,pt3.y);
	printf("\nThe distance between origin and pt1 is %f",GetDis(pt0,pt3));
	printf("\nThe distance between origin and pt2 is %f",GetDis(pt0,pt2));
	printf("\nThe distance between pt1 and pt2 is %f\n",GetDis(pt2,pt1));
}

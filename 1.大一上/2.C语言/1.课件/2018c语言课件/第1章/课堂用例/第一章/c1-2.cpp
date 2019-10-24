/*  程序的功能为求圆的周长与面积   */

#include<stdio.h>
#define PI 3.1415926        /* 定义PI 为圆周率，PI为符号常量*/
/* 主程序*/
void main(void)
{
  float r,circum,area;            /* r存圆的半径、circum圆的周长、area圆的面积*/
  float get_circum(float r);      /*  声明函数get_ circum  */ 
  float get_area (float r);      /*  声明get_area */ 

  printf("请输入圆的半径:");   
  scanf("%f",&r);               /* 从键盘上输入r存圆的半径*/
  circum = get_circum (r);      /* 调用函数get_ circum求圆的周长*/
  area=get_area(r);                 /* 调用函数get_area求圆的面积*/
  printf("圆的周长为%.2f ，圆的面积为 %.2f\n",circum,area);
 }

/*  函数get_ circum(r)计算圆的周长  */ 
float get_circum(float r)
{
    return 2*PI*r;
}

 /*  函数get_area (r)计算圆的面积  */ 
float get_area (float r)
{
    return PI*r*r;
}

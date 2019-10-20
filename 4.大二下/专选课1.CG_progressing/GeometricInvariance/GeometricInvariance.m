function GeometricInvariance
% 这是一个演示曲线表示几何不变性质的Matlab程序
% 曲线表示几何不变性是指它们不依赖于坐标系的选择或者说在旋转与平移变换下不变的性质
%
% Copyright (c) Apr, 2006.  Zhou Dengwen.  All rights reserved.
% Department of Computer Science & Technology
% North China Electric Power University(Beijing)(NCEPU)
%

set(gcf, 'NumberTitle','off', 'Name','曲线表示几何不变性演示');
x = [0 1 2]; y = [0 0.5 0];  % 输入三个插值点
[a,b,c] = CalcCoef(x,y);  % 计算显式表示的二次多项式函数系数 a,b,c
subplot(2,2,1); % 画出曲线
DrawingCurve(x,y,a,b,c);  
title('通过三个插值点的显式表示的二次多项式曲线');

[xr,yr] = rotate2(x,y,45);  % 三个插值点逆时针旋转45度
[ar,br,cr] = CalcCoef(xr,yr);  % 计算旋转后的系数 ar,br,cr
subplot(2,2,2);  % 画出旋转后的曲线
DrawingCurve(xr,yr,ar,br,cr); 
title('旋转三个插值点后的显式表示的二次多项式曲线');

subplot(2,2,3);
QuadraticBezier(x,y); % 计算和绘制二次Bezier参数曲线
title('通过三个插值点的参数表示的二次曲线');

subplot(2,2,4);
QuadraticBezier(xr,yr); % 计算和绘制旋转后的二次Bezier参数曲线
title('旋转三个插值点后的参数表示的二次曲线');

%-----------------------------------------------------------
function [a,b,c] = CalcCoef(x,y)
% 本函数计算该二次多项式函数的系数 a,b,c
% 显式表示的二次多项式函数 y = a*x^2 + b*x + c
% x,y 均为三个元素的行向量，分别表示曲线上三个点的横、纵坐标

t1 = [y(2)-y(1) x(2)^2-x(1)^2 x(2)-x(1)];
t2 = [y(3)-y(2) x(3)^2-x(2)^2 x(3)-x(2)];

b = (t1(1)*t2(2)-t2(1)*t1(2))/(t1(3)*t2(2)-t2(3)*t1(2));
a = (t1(1)*t2(3)-t2(1)*t1(3))/(t1(2)*t2(3)-t2(2)*t1(3));
c = y(1)-a*x(1)^2-b*x(1);

%----------------------------------------------------------
function [xr,yr] = rotate2(x,y,theta)
% 本函数将坐标x,y逆时针旋转theta角
% theta是角度

n = size(x,2); theta = theta*pi/180;
for j = 1:n
    xr(j) = x(j)*cos(theta)-y(j)*sin(theta);
    yr(j) = x(j)*sin(theta)+y(j)*cos(theta);
end

%----------------------------------------------
function DrawingCurve(x,y,a,b,c)
% 本函数绘制多项式函数曲线

hold on; axis equal;
t0 = min(x); t1 = max(x);
t = t0:0.01:t1;
f = a*t.^2 + b*t + c;
plot(t,f);  % 画出曲线
for j = 1:3
    plot(x(j),y(j),'ro','MarkerSize',8,'MarkerFaceColor','g');
end

%----------------------------------------------
function QuadraticBezier(x,y)
% 本函数计算和绘制二次Bezier参数曲线
% x,y是给定的三个插值点

L1 = sqrt((x(2)-x(1))^2+(y(2)-y(1))^2); % 计算弦长
L2 = sqrt((x(3)-x(2))^2+(y(3)-y(2))^2);
u = [0 L1/(L1+L2) 1]; % 计算各插值点的参数

x1 = x(1); y1 = y(1); x3 = x(3); y3 = y(3); % 计算特征多边形顶点
x2 = (x(2)-(1-u(2))^2*x1-u(2)^2*x3)/(2*u(2)*(1-u(2)));
y2 = (y(2)-(1-u(2))^2*y1-u(2)^2*y3)/(2*u(2)*(1-u(2)));

% 计算二次Bezier参数曲线上的插值点
hold on; axis equal;
t = 0:0.01:1;
xt = (1-t.^2)*x1+2*t.*(1-t)*x2+t.^2*x3;
yt = (1-t.^2)*y1+2*t.*(1-t)*y2+t.^2*y3;

% 绘制二次Bezier参数曲线
plot(xt,yt);
for j = 1:3
    plot(x(j),y(j),'ro','MarkerSize',8,'MarkerFaceColor','g');
end
    




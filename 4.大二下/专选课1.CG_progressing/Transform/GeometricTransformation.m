function GeometricTransformation
% 这是一个3D维空间中绕任意一根轴的旋转变换的Matlab程序
%
% Copyright (c) Mar, 2006.  Zhou Dengwen.  All rights reserved.
% Department of Computer Science & Technology
% North China Electric Power University(Beijing)(NCEPU)
%

% 输入参数
AxisLine = [0 5 3; 5 8 10];  % 旋转轴线
vertex_matrix = [1 1 4; 2 1 4; 2 2 4; 1 2 4; 1 1 5; 2 1 5; 2 2 5; 1 2 5];  % 待旋转的物体
faces_matrix = [1 2 6 5; 2 3 7 6; 3 4 8 7; 4 1 5 8; 1 2 3 4; 5 6 7 8];
DrawingScene(AxisLine,vertex_matrix,faces_matrix); % 绘制场景
DisplatPrompt(AxisLine,vertex_matrix,faces_matrix,'旋转轴线和被旋转的物体');  % 显示提示信息
'按任意键继续...'
pause;

% 将轴线的起点P0(x0,y0)平移到坐标原点
AxisLine_h = ones(4,size(AxisLine',2));
AxisLine_h(1:3,:) = AxisLine';  % 轴线端点转化为齐次坐标 
vertex_matrix_h = ones(4,size(vertex_matrix',2));
vertex_matrix_h(1:3,:) = vertex_matrix';  % 物体顶点转化为齐次坐标
T1 = [1 0 0 -AxisLine(1,1); 0 1 0 -AxisLine(1,2); 0 0 1 -AxisLine(1,3); 0 0 0 1];  % 平移矩阵
AxisLine_temp = T1*AxisLine_h;  % 轴线起点平移到原点
vertex_matrix_temp = T1*vertex_matrix_h;  % 物体作平移变换
DrawingScene((AxisLine_temp(1:3,:))',(vertex_matrix_temp(1:3,:))',faces_matrix); % 绘制平移后的场景
DisplatPrompt((AxisLine_temp(1:3,:))',(vertex_matrix_temp(1:3,:))',faces_matrix,'将轴线的起点平移到坐标原点');  % 显示提示信息
'按任意键继续...'
pause;

% 将轴线绕x轴旋转，使之与xoz平面重合
x1 = AxisLine_temp(1,2); y1 = AxisLine_temp(2,2); z1 = AxisLine_temp(3,2); % 轴的端点P1
x2 = x1; y2 = 0; z2 = z1; % P1在xoz平面的投影
x3 = x1; y3 = 0; z3 = 0;  % P1在x轴上的投影
sx = abs(y1)/sqrt(y1^2+z1^2); cx = sqrt(1-sx^2);
RX1 = [1 0 0 0; 0 cx -sx 0; 0 sx cx 0; 0 0 0 1];  % 旋转矩阵
AxisLine_temp = RX1*AxisLine_temp;  % 轴线绕x轴旋转
vertex_matrix_temp = RX1*vertex_matrix_temp;  % 物体绕x轴旋转
DrawingScene((AxisLine_temp(1:3,:))',(vertex_matrix_temp(1:3,:))',faces_matrix); % 绘制旋转后的场景
DisplatPrompt((AxisLine_temp(1:3,:))',(vertex_matrix_temp(1:3,:))',faces_matrix,'将轴线绕x轴旋转，使之与xoz平面重合');  % 显示提示信息
'按任意键继续...'
pause;

% 将轴线绕y轴旋转，使之与z轴重合
x1 = AxisLine_temp(1,2); y1 = 0; z1 = AxisLine_temp(3,2); % 轴的端点P1
x2 = 0; y2 = 0; z2 = z1; % P1在z轴上的投影
sy = -abs(x1)/sqrt(x1^2+z1^2); cy = sqrt(1-sy^2);
RY1 = [cy 0 sy 0; 0 1 0 0; -sy 0 cy 0; 0 0 0 1];  % 旋转矩阵
AxisLine_temp = RY1*AxisLine_temp;  % 轴线绕y轴旋转
vertex_matrix_temp = RY1*vertex_matrix_temp;  % 物体绕y轴旋转
DrawingScene((AxisLine_temp(1:3,:))',(vertex_matrix_temp(1:3,:))',faces_matrix); % 绘制旋转后的场景
DisplatPrompt((AxisLine_temp(1:3,:))',(vertex_matrix_temp(1:3,:))',faces_matrix,'将轴线绕y轴旋转，使之与z轴重合');  % 显示提示信息
'按任意键继续...'
pause;

% 将物体绕z轴旋转30度
alfa = pi/6; % 旋转角度
RZ = [cos(alfa) -sin(alfa) 0 0; sin(alfa) cos(alfa) 0 0; 0 0 1 0; 0 0 0 1];  % 旋转矩阵
vertex_matrix_temp = RZ*vertex_matrix_temp;  % 物体绕z轴旋转
DrawingScene((AxisLine_temp(1:3,:))',(vertex_matrix_temp(1:3,:))',faces_matrix); % 绘制旋转后的场景
DisplatPrompt((AxisLine_temp(1:3,:))',(vertex_matrix_temp(1:3,:))',faces_matrix,'将物体绕z轴旋转30度');  % 显示提示信息
'按任意键继续...'
pause;

% 将轴线绕y轴反向旋转
RY2 = [cy 0 -sy 0; 0 1 0 0; sy 0 cy 0; 0 0 0 1];  % 旋转矩阵
AxisLine_temp = RY2*AxisLine_temp;  % 轴线绕y轴旋转
vertex_matrix_temp = RY2*vertex_matrix_temp;  % 物体绕y轴旋转
DrawingScene((AxisLine_temp(1:3,:))',(vertex_matrix_temp(1:3,:))',faces_matrix); % 绘制旋转后的场景
DisplatPrompt((AxisLine_temp(1:3,:))',(vertex_matrix_temp(1:3,:))',faces_matrix,'将轴线绕y轴反向旋转');  % 显示提示信息
'按任意键继续...'
pause;

% 将轴线绕x轴反向旋转
RX2 = [1 0 0 0; 0 cx sx 0; 0 -sx cx 0; 0 0 0 1];  % 旋转矩阵
AxisLine_temp = RX2*AxisLine_temp;  % 轴线绕x轴旋转
vertex_matrix_temp = RX2*vertex_matrix_temp;  % 物体绕x轴旋转
DrawingScene((AxisLine_temp(1:3,:))',(vertex_matrix_temp(1:3,:))',faces_matrix); % 绘制旋转后的场景
DisplatPrompt((AxisLine_temp(1:3,:))',(vertex_matrix_temp(1:3,:))',faces_matrix,'将轴线绕x轴反向旋转');  % 显示提示信息
'按任意键继续...'
pause;

% 将轴线反向平移
T2 = [1 0 0 AxisLine(1,1); 0 1 0 AxisLine(1,2); 0 0 1 AxisLine(1,3); 0 0 0 1];  % 平移矩阵
AxisLine_temp = T2*AxisLine_temp;  % 轴线平移
vertex_matrix_temp = T2*vertex_matrix_temp;  % 物体平移
DrawingScene((AxisLine_temp(1:3,:))',(vertex_matrix_temp(1:3,:))',faces_matrix); % 绘制旋转后的场景
DisplatPrompt((AxisLine_temp(1:3,:))',(vertex_matrix_temp(1:3,:))',faces_matrix,'将轴线反向平移');  % 显示提示信息
'按任意键继续...'
pause;

%----------------------------------------------------------------------------
function [xmin,xmax,ymin,ymax,zmin,zmax] = SceneRange(AxisLine,vertex_matrix)
% 本函数计算场景的范围

xmin = min(min(AxisLine(:,1)),min(vertex_matrix(:,1)));
ymin = min(min(AxisLine(:,2)),min(vertex_matrix(:,2)));
zmin = min(min(AxisLine(:,3)),min(vertex_matrix(:,3)));  

xmax = max(max(AxisLine(:,1)),max(vertex_matrix(:,1)));
ymax = max(max(AxisLine(:,2)),max(vertex_matrix(:,2)));
zmax = max(max(AxisLine(:,3)),max(vertex_matrix(:,3)));  

if xmin > 0 xmin = 0; end
if ymin > 0 ymin = 0; end
if zmin > 0 zmin = 0; end
if xmax < 0 xmax = 0; end
if ymax < 0 ymax = 0; end
if zmax < 0 zmax = 0; end

%-------------------------------------------------------
function DrawingCoordAxis(xmin,xmax,ymin,ymax,zmin,zmax)
% 本函数绘制空间三个坐标轴

if xmin > 0 xmin = 0; end
if ymin > 0 ymin = 0; end
if zmin > 0 zmin = 0; end
if xmax < 0 xmax = 0; end
if ymax < 0 ymax = 0; end
if zmax < 0 zmax = 0; end
plot3([xmin,xmax],[0,0],[0,0],'g-');
plot3([0,0],[ymin,ymax],[0,0],'g-');
plot3([0,0],[0,0],[zmin,zmax],'g-');
text(xmax,0,0, 'X','Color',[1 0 0]);
text(0,ymax,0, 'Y','Color',[1 0 0]);
text(0,0,zmax, 'Z','Color',[1 0 0]);
%xlabel('x','Color',[0 1 0]);ylabel('y','Color',[0 1 0]);zlabel('z','Color',[0 1 0]);

%--------------------------------------------------------------
function DrawingScene(AxisLine,vertex_matrix,faces_matrix)
% 本函数绘制空间场景

% 计算场景范围
[xmin,xmax,ymin,ymax,zmin,zmax] = SceneRange(AxisLine,vertex_matrix);

clf; % 清除当前图形窗口
hold on; grid on;
axis equal;
view(3);
title('3D几何变换演示');  % 显示场景标题
plot3(AxisLine(:,1),AxisLine(:,2),AxisLine(:,3),'b-','LineWidth',2);  % 绘制旋转轴
DisplayCoordinates(AxisLine);  % 显示轴端点坐标值
patch('Vertices',vertex_matrix,'Faces',faces_matrix,...  % 绘制物体
      'FaceVertexCData',hsv(8),'FaceColor','interp');
DrawingCoordAxis(xmin,xmax,ymin,ymax,zmin,zmax);  % 绘制坐标轴

%------------------------------------------------------------------
function DisplatPrompt(AxisLine,vertex_matrix,faces_matrix,string)
% 本函数显示提示信息

[xmin,xmax,ymin,ymax,zmin,zmax] = SceneRange(AxisLine,vertex_matrix);
xText =(xmin+xmax)/2 ; yText = (ymin+ymax)/2; zText = (zmin+zmax)/2; 
text(xText,yText,zText+1, string,'HorizontalAlignment','center','Background',[0.7 0.9 0.7],'Color',[0 0 0], ...
         'FontName','楷体_GB2312','FontSize', 18,'FontWeight','bold');
     
%--------------------------------------------------------------------
function DisplayCoordinates(AxisLine)
% 本函数显示空间多边形顶点坐标值

nVertex = size(AxisLine,1);
for i = 1:nVertex
    for j = 1:3
        if abs(AxisLine(i,j)) < 10*eps AxisLine(i,j) = 0; end
    end
    text(AxisLine(i,1),AxisLine(i,2),AxisLine(i,3),['(' num2str(AxisLine(i,1)) ',' ...
            num2str(AxisLine(i,2)),',',num2str(AxisLine(i,3)), ')'], ...
            'FontSize',16,'Color',[0,0,1]);
end
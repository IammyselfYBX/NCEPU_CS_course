function SmoothExample2
% 这是一个演示曲线顺的Matlab程序
%
% Copyright (c) Apr, 2006.  Zhou Dengwen.  All rights reserved.
% Department of Computer Science & Technology
% North China Electric Power University(Beijing)(NCEPU)
%
% Generate random data between 0 and 15, create a sine wave with noise
x = 15*rand(150,1); 
y = sin(x) + (rand(size(x))-0.5)*0.5;
y(ceil(length(x)*rand(2,1))) = 3;

% Smooth the data using the loess and rloess methods with the span specified as 10% of the data. 
yy1 = smooth(x,y,0.1,'loess');
yy2 = smooth(x,y,0.1,'rloess');

% Plot original data and the smoothed data. 
[xx,ind] = sort(x);
subplot(2,1,1)
plot(xx,y(ind),'r.',xx,yy1(ind),'k-')
set(gca,'YLim',[-1.5 3.5])
legend('Original Data','Smoothed Data Using ''loess''')
subplot(2,1,2)
plot(xx,y(ind),'r.',xx,yy2(ind),'k-')
set(gca,'YLim',[-1.5 3.5])
legend('Original Data','Smoothed Data Using ''rloess''')
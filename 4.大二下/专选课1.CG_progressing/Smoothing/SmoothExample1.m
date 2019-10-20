function SmoothExample1
% 这是一个演示曲线顺的Matlab程序
%
% Copyright (c) Apr, 2006.  Zhou Dengwen.  All rights reserved.
% Department of Computer Science & Technology
% North China Electric Power University(Beijing)(NCEPU)
%
% Generate random data between 0 and 15, create a sine wave with noise 
load count.dat
y = count(:,1);
yy = smooth(y);

% Plot the original data and the smoothed data. 
t = 1:length(y);
plot(t,y,'r-.',t,yy,'b-')
legend('Original Data','Smoothed Data Using ''moving''')
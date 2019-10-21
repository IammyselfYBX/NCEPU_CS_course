###为文字添加背景色

由于 style 标签和标签的 style 属性不被支持，所以这里只能是借助 table, tr, td 等表格标签的 bgcolor 属性来实现背景色。故这里对于文字背景色的设置，只是将那一整行看作一个表格，更改了那个格子的背景色（bgcolor）

Markdown语法

<table><tr><td bgcolor=yellow>背景色yellow</td></tr></table>

---
换行
使用br标签

就像使用html一样，使用br标签
敲击两个以上空白，然后回车

在末尾敲击两个以上空白，然后回车
首行缩进
使用特殊占位符

不同占位符所占空白是不一样大的。

【1】 &ensp;或&#8194; //半角
【2】 &emsp;或&#8195; //全角
【3】 &nbsp;或&#160; //不断行的空白格

---
##Markdown字体
<font face="黑体">我是黑体字</font>
<font face="微软雅黑">我是微软雅黑</font>
<font face="STCAIYUN">我是华文彩云</font>
<font color=red>我是红色</font>
<font color=#008000>我是绿色</font>
<font color=Blue>我是蓝色</font>
<font size=3 >3号字</font>
<font size=4 >4号字</font>
<font size=5>我是尺寸</font>
<font face="黑体" color=green size=5>我是黑体，绿色，尺寸为5</font>

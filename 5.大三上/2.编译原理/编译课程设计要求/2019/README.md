### 终端词法语法分析器 ---- ybx compiler
---
<p align="right"> [计算1702 杨秉学](https://github.com/IammyselfYBX) <br>
<b>学号</b>:120171080212 <br>
点击链接访问 [ybx](https://github.com/IammyselfYBX/ybx_compiler) </p>

#### 支持运算法
|    运算符    |               符号               |
|   :----:    |             :----:               |
| 算术运算符    |       +  -  *  /  %             |
| 关系运算符    |	<  <=   ==   >   >=   !=      |
| 逻辑运算符	|           ！  &&  \|\|          | - 取反
| 位运算符	    |        <<   >>   ~  |  ^  &     | ^ | & ~
| 赋值运算符    |	= 及其扩展（+= -= 等）          |   += -=
| 条件运算符    |	             ?:               | *
| 逗号运算符    |       	    ，                | *
| 下标运算符    |           	[]               |  *

#### 支持流程控制
    > 1.支持条件控制if、循环控制while、for<br>
    > 不允许悬空else，所以改用 elsif ，支持break、continue、return语句<br>

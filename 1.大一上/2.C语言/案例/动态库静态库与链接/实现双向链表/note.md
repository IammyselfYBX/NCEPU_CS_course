### 问题
出现下面这种情况
![图片](problem.png)
就是因为像 “List_create”,"List_clear_destoy"等函数声明在doublelink.h中,但函数实现在doublelink.c中
解决方案
![图片](solution.png)
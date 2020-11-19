把上面的代码保存为hello.asm，并且把该文件放在解压后的nasm的目录中，并进入目录执行如下命令：
```
nasm -f elf64(elf32) hello.asm                  (注意这里使用elf64还是elf32要看操作系统的位数来决定)
gcc -o hello hello.o
./hello
```
如果输出了hello wrod 则说明安装成功了

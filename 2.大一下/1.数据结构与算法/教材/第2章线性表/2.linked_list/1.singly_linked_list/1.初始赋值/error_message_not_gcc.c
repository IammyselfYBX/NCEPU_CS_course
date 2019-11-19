#include <string.h>
#include "crowbar.h"

/*
** 格式化的编译时错误信息
*/
MessageFormat crb_compile_error_message_format[] = {
    {"dummy"},
    {"在($(token))附近发生语法错误"},
    {"不正确的字符($(bad_char))"},
    {"函数名重复($(name))"},
    {"dummy"},
};

/*
** 格式化的运行时错误信息
*/
MessageFormat crb_runtime_error_message_format[] = {
    {"dummy"},
    {"找不到变量($(name))。"},
    {"找不到函数($(name))。"},
    {"实际传入的参数比函数需要的参数多。"},
    {"实际传入的参数比函数需要的参数少。"},
    {"条件表达式的值必须是boolean型。"},
    {"减法运算符的操作数必须是数值型。"},
    {"双目运算符$(operator)的操作数不正确。"},
    {"$(operator)运算符不能用于boolean型。"},
    {"请为fopen()函数传入文件的路径和打开方式（两者都是字符串类型的）。"},
    {"请为fclose()函数传入文件指针。"},
    {"请为fgets()函数传入文件指针。"},
    {"请为fputs()函数传入文件指针和字符串。"},
    {"null只能使用运算符 == 和 != (不能进行$(operator)操作)。"},
    {"不能被0除。"},
    {"全局变量$(name)不存在。"},
    {"不能在函数外使用global语句。"},
    {"运算符$(operator)不能用于字符串。"},
    {"dummy"},
};

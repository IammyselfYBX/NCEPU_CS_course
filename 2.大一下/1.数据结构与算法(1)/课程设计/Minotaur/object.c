/*
    A Simple Object System
    主要是OOP与面向过程之间的过度，了解预处理器相关知识
    一、C预处理器是个模板处理系统,它主要的用途是让C代码的编程更加容易,
    但是它通过一个语法感知的模板机制来实现。
    以前人们主要使用C预处理器来储存常量,以及创建“宏”来简化复杂的代码。
    在现代C语言中你会实际上使用它作为代码生成器来创建模板化的代码片段。

    二、C预处理器的工作原理:
    如果你给它一个文件,比如 .c 文件,它会处理以 # (井号)字符开头的各种文本。
    当它遇到一个这样的文本时,它会对输入文件中的文本做特定的替换。
    C预处理器的主要优点是他可以包含其他文件,并且基于该文件的内容对它的宏列表进行扩展。
*/
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include "object.h"

void Object_destroy(void *self)
{
    Object *obj = self;

    if(obj){
        if(obj->description){
            free(obj->description);
            free(obj);
        }
    }
}

void Object_describe(void *self)
{
    Object *obj = self;
    printf("%s.\n", obj->description);
}

int Object_init(void *self)
{
    return 1;
}

void *Object_move(void *self, Direction direction)
{
    printf("You can't go that direction.\n");
    return NULL;
}

int Object_attack(void *self, int damage)
{
    printf("You can't attack that.\n");
    return 0;
}

void *Object_new(size_t size, Object proto, char *description)
{
    // setup the default functions in case they aren't set
    if(!proto.init){
        proto.init = Object_init;
    }
    if(!proto.describe){
        proto.describe = Object_describe;
    }
    if(!proto.destroy){
        proto.destroy = Object_destroy;
    }
    if(!proto.attack){
        proto.attack = Object_attack;
    }
    if(!proto.move){
        proto.move = Object_move;
    }

    Object *el = calloc(1, size);
    *el = proto;

    el->description = strdup(description);

    if(!el->init(el)){
        el->destroy(el);    // looks like it didn't initialize properly
        return NULL;
    }else{
        return el;
    }
}

/*
 * 上面的代码创建了基本的对象系统,但是你需要编译它和将它链接到 ex19.c 文
件,来创建出完整的程序。 object.c 文件本身并没有 main 函数,所以它不可
能被编译为完整的程序。
 */
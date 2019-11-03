;找到最小偶数（可以有负数）

DATAS SEGMENT
    BUF DW 1,2,-4,3,5,6
    COUNT EQU $-BUF
DATAS ENDS

STACKS SEGMENT

STACKS ENDS

CODES SEGMENT
    ASSUME CS:CODES,DS:DATAS,SS:STACKS,ES:DATAS
START:
    MOV AX,DATAS
    MOV DS,AX
    MOV ES,AX

    LEA DI,BUF        ;取BUF字符串的偏移地址给DI
    MOV CX,COUNT

LOOP1:
    MOV AX,[DI]       
    TEST AL,01H
    JNZ CONTINUE         ;如果不是偶数，就继续循环
    MOV BX,[DI]       ;把第一个偶数放入BL
    JMP NEXT1
CONTINUE:
    INC DI
    LOOP LOOP1
NEXT1:
    LEA DI,BUF        ;把DI清零，重新开始
    MOV CX,COUNT      


LOOP2:
    MOV AX,[DI]
    TEST AL,01H
    JZ OUSHU2
    JMP NEXT2
OUSHU2:
    CMP BX,AX
    JGE CHAN
    JMP NEXT2
CHAN: 
    MOV BX,AX
NEXT2:
    INC DI
    LOOP LOOP2
    
    MOV AH,4CH
    INT 21H
CODES ENDS
    END START

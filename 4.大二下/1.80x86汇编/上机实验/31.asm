;删除指定字符（能删除多个）

DATAS SEGMENT
    BUF DB 'alaoaoapa$'
    COUNT EQU $-BUF    
    ERROR DB 'NOT FOUND$'

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
    MOV AL,'a'
    MOV CX,COUNT
    MOV BX,COUNT
    CLD               ;CLD指令复位方向标志：DF＝0，即存储器地址自动增加
    REPNZ SCASB       ;目的字符串在ES中定义，目的字符在AL中，用来在字符串中找到第一个与AL中相同的字符
    JNZ NOTFOUND      ;JNZ:当A不等于B，即没找到时跳转到 NOTFOUND
FOUND:
	MOV AL,[DI]
	MOV [DI-1],AL     
	INC DI            ;将空格后的字符往前挪
	LOOP FOUND

   ;--------------------------------------------------------------------------删除多个字符----------------------
LOOP2:
    LEA DI,BUF        ;这是第一次找到的前提下，进行的第二次查找删除，BUF是新的字符串
    MOV AL,'a'
    SUB BX,1H         ;但是现在BX要减1,为什么是BX，而不是CX直接减1，因为CX要随着循环递减
    MOV CX,BX         

    CLD               
    REPNZ SCASB       
    JNZ NEXT           
FOUND2:
    MOV AL,[DI]
    MOV [DI-1],AL     
    INC DI            
    LOOP FOUND2            ;将空格后的字符往前挪
    JMP LOOP2              ;一直循环(没有条件，所以应该用JMP)，直到找不到相同字母
NEXT:
    LEA DX,BUF
    JMP PRINT

    ;-------------------------------------------------------------------------删除多个字符------------------------
NOTFOUND:
	LEA DX,ERROR
PRINT:
	MOV AH,9H
	INT 21H
    MOV AH,4CH
    INT 21H
CODES ENDS
    END START

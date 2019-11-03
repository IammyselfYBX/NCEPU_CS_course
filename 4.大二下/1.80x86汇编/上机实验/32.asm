;比较字符串是否相同（串指令）
DATAS SEGMENT
    BUF1 DB 'ABCDEFG$'
    BUF2 DB 'ABCDEFG$'    
    COUNT EQU $-BUF2
    BUF3 DB 'SAME!$'
    BUF4 DB 'NOT SAME!$'

DATAS ENDS

STACKS SEGMENT

STACKS ENDS

CODES SEGMENT
    ASSUME CS:CODES,DS:DATAS,SS:STACKS,ES:DATAS
START:
    MOV AX,DATAS
    MOV DS,AX
    MOV ES,AX

    LEA SI,BUF1
    LEA DI,BUF2
    MOV CX,COUNT
    CLD
    REPZ CMPSB       ;字符串比较指令，把ESI指向的数据与EDI指向的数一个一个的进行比较
    JNZ NOTSAME      ;ZF=0 不相同，于是跳转
    MOV AX,1         ;相同的话，就把AX置为1，并打出same
    LEA DX,BUF3
    JMP PRINT
NOTSAME:
	MOV AX,0
    LEA DX,BUF4
PRINT:
    MOV AH,9H
	INT 21H
    MOV AH,4CH
    INT 21H
CODES ENDS
    END START


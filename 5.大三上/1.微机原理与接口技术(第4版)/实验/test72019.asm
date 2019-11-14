;***********************************;
;* 十字路口红绿灯模拟演示程序 *;
;* 端口各灯的设置: *;
;* 1红 1黄 1绿 0 0 2红 2黄 2绿 *;
;***********************************;
data segment
    io8255a equ 28ah
    io8255b equ 28bh
    portc1 db 24h,44h,04h,44h,04h,44h,04h ;六个灯可能
    db 81h,82h,80h,82h,80h,82h,80h ;的状态数据
    db 0ffh ;结束标志
data ends

code segment
assume cs:code,ds:data
start:
    mov ax,data
    mov ds,ax
    mov dx,io8255b
    mov al,90h
    out dx,al ;设置8255为C口输出
    mov dx,io8255a

re_on: mov bx,0

on: 
    mov al,portc1[bx]
    mov cx,200 ;参数赋初值

    mov al,24h
    out dx,al
    mov cx,2000
de01: mov di,9000 ;di赋初值9000
de00:
    dec di ;减1计数
    jnz de00 ;di不为0
    loop de01

    mov al,44h
    out dx,al
    mov cx,200
de11: mov di,9000 ;di赋初值9000
de10: 
    dec di ;减1计数
    jnz de10 ;di不为0
    loop de11

    mov al,04h
    out dx,al
    mov cx,200
de21: mov di,9000 ;di赋初值9000
de20:
    dec di ;减1计数
    jnz de20 ;di不为0
    loop de21

    mov al,44h
    out dx,al
    mov cx,200
de31: mov di,9000 ;di赋初值9000
de30: 
    dec di ;减1计数
    jnz de30 ;di不为0
    loop de31

    mov al,04h
    out dx,al
    mov cx,200
de41: mov di,9000 ;di赋初值9000
de40: dec di ;减1计数
    jnz de40 ;di不为0
    loop de41

    mov al,44h
    out dx,al
    mov cx,200
de51: mov di,9000 ;di赋初值9000
de50: 
    dec di ;减1计数
    jnz de50 ;di不为0
    loop de51

    mov al,04h
    out dx,al
    mov cx,200
de61: mov di,9000 ;di赋初值9000
de60: 
    dec di ;减1计数
    jnz de60
    loop de61

    mov al,81h
    out dx,al
    mov cx,200
de03: mov di,9000 ;di赋初值9000
de04: 
    dec di ;减1计数
    jnz de04
    loop de03

    mov al,82h
    out dx,al
    mov cx,200
de13: mov di,9000 ;di赋初值9000
de14: 
    dec di ;减1计数
    jnz de14
    loop de13

    mov al,80h
    out dx,al
    mov cx,200
de23: mov di,9000 ;di赋初值9000
de24: 
    dec di ;减1计数
    jnz de24
    loop de23

    mov al,82h
    out dx,al
    mov cx,200
de33: mov di,9000 ;di赋初值9000
de34: 
    dec di ;减1计数
    jnz de34
    loop de33

    mov al,80h
    out dx,al
    mov cx,200
de43: mov di,90

00 ;di赋初值9000
de44: dec di ;减1计数
    jnz de44
    loop de43

    mov al,82h
    out dx,al
    mov cx,200
de53: mov di,9000 ;di赋初值9000
de54: dec di ;减1计数
    jnz de54
    loop de53

    mov al,80h
    out dx,al
    mov cx,200
de63: mov di,9000 ;di赋初值9000
de64: 
    dec di ;减1计数
    jnz de64
    loop de63

    jmp on ;没有,转到on

exit: 
    mov ah,4ch ;返回
    int 21h
code ends
end start

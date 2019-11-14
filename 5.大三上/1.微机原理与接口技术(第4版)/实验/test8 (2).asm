;*******************
;*    8253·ÖÆµ     *
;*******************
io8253a        equ 280h
io8253b        equ 281h
io8253c        equ 283h
code segment
    assume   cs:code
start:mov dx,io8253c     ;Ïò8253Ð´¿ØÖÆ×Ö
    mov al,36h     ;54---36h 
    out dx,al
    mov ax,10000
    mov dx,io8253a
    out dx,al        
    mov al,ah
    out dx,al     
    mov dx,io8253c
    mov al,76h     ;66---76h 
    out dx,al
    mov ax,100    
    mov dx,io8253b
    out dx,al        
    mov al,ah
    out dx,al        
    mov ah,4ch      
    int 21h
  code ends
    end start
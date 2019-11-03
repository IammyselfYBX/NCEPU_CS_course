;二分法查找指定数字
DATAS SEGMENT

    BUF DB 1,2,3,4,5,6,8,9,10
    COUNT EQU $-BUF
    BLOW DB 0
    BHIGH DB COUNT
    BMID DB COUNT/2
    NOTFOUND DB 'NOT FOUND!$'
DATAS ENDS

STACKS SEGMENT

STACKS ENDS

CODES SEGMENT
    ASSUME CS:CODES,DS:DATAS,SS:STACKS
START:
    MOV AX,DATAS
    MOV DS,AX

    
    MOV DL,8             ;想找的数
    MOV CL,2             ;除数
LOOP1:
    LEA BX,BUF
    MOV AX,0
    MOV AL,BMID
    ADD BX,AX
    CMP [BX],DL          ;[BX]是数组中最中间的那一个数（内容）
    JZ FIND              ;如果中间那个数就等于要找的数，则直接跳到“找到” 
    JG SMALL             ;当中间的数>要找的数，则跳到small
    MOV AL,BHIGH         ;否则执行下一步：判断mid是否=high（位置）
   	CMP AL,BMID          
   	JZ EXIT              ;如果mid=high，直接退出，说明没找到

    MOV AL,BMID          
   	MOV BLOW,AL
   	INC BLOW              ;LOW=MID+1（位置）

   	MOV AL,BLOW
   	ADD AL,BHIGH
   	DIV CL                
   	MOV BMID,AL           ;继续计算新的mid=（low+high）/2（位置）
   	JMP LOOP1
SMALL:
	MOV AL,BHIGH
	CMP AL,BMID
	JZ EXIT                 ;如果mid=high，直接退出，说明没找到

	MOV AL,BMID
	MOV BHIGH,AL
	DEC BHIGH               ;high=mid-1

	MOV AL,BHIGH
	ADD AL,BLOW
	DIV CL
	MOV BMID,AL             ;mid=(low+high)/2

	JMP LOOP1
FIND:
  MOV AL,[BX]             ;找到的话，就把这个数位置打出来
  ADD BX,30H
  INC BX
  MOV DX,BX
  MOV AH,2H
  INT 21H
  JMP FINALEND
EXIT:      
  LEA DX,NOTFOUND         ;没找到的话，就打出“NOT FOUND！”
  MOV AH,9H
  INT 21H
FINALEND:
	MOV AH,4CH               
  INT 21H
CODES ENDS
    END START

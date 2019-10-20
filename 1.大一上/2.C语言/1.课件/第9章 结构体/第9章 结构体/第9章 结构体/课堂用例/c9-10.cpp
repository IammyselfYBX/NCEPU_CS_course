#include <stdio.h>
#include <string.h>
#include <process.h>

#define MAXSIZE 50

/*联系人结构定义*/
struct TelInfo{
char name[10];
char telno[10];
};
int   Append(struct TelInfo telList[], int *len, struct TelInfo telInfo);
char* Find(struct TelInfo telList[], int *len, char *name);
int   Delete(struct TelInfo telList[], int *len, char *name);
void  Out(struct TelInfo telList[], int len);

/*增加联系人，插入成功返回1，否则返回0*/
int Append(struct TelInfo telList[], int *len, struct TelInfo telInfo)
{
	int length;                //局部变量，表的长度
	length = *len;        

	if( length == MAXSIZE)
        return 0;
	telList[length] = telInfo;
	length ++;

	*len = length;
	return 1;
}

/*根据联系人查找电话号，查找成功返回指向电话号的指针，否则返回空指针*/
char* Find(struct TelInfo telList[], int *len, char *name)
{ 
	int length = *len;

	for(int i = 0; i < length; i++)
		if(strcmp (telList[i].name, name) == 0)
			return telList[i].telno;
	return NULL;
}

/*删除指定姓名的联系人，删除成功返回1，否则返回0*/
int Delete(struct TelInfo telList[], int *len, char *name)
{
	int length = *len;

	for(int i = 0; i < length; i++)
		if(strcmp (telList[i].name, name) == 0)
			break;

	if(i < length)                // 删除telList[i]
	{
		for(int j=i; j<length; j++ )
			telList[j] = telList[j+1];
		(*len)--;

		return 1;
	}
	else return 0;
}

void Out(struct TelInfo telList[], int len)
{
	int length = len;

	printf("\n姓名        号码\n");
	for(int i=0; i<length; i++)
	{
	    printf("%10s%10s\n", telList[i].name, telList[i].telno);
	}
}

void main()
{
	int     choice;                         //操作项
	char    name[10];                       //联系人姓名
	struct  TelInfo telList[MAXSIZE];          //联系人信息结构数组
	int     len = 0;                         //电话表中当前记录数 

	while(1)
	{
		printf("手机通讯录功能选项：1：插入 2：删除 3：查询 4: 输出 0：退出\n");
		printf("请选择操作：");
        scanf("%d", &choice);
		switch(choice)
		{
		case 1:
			struct TelInfo  tel;
			printf("输入要插入的姓名、电话（以空格隔开）\n");
			scanf("%s%s",tel.name, tel.telno);
			Append(telList, &len, tel);
			break;
		case 2:
			printf("请输入要删除的联系人姓名：\n");
			scanf("%s",name);
			Delete(telList, &len, name);
			break;
		case 3:
			printf("请输入要查找的联系人姓名:\n");
			scanf("%s", name);
		    if(char *p = Find(telList, &len, name))
				printf("该联系人的电话为：%s\n", p);
			else
				printf("没有该联系人！\n");

			break;
		case 4:
			printf("电话号码表为：");
			Out(telList, len);
			break;
		case 0:
			exit(1);
			break;
		default:
			continue;
		}
	}
}

/*
	2007-5-21	
	�۰�����㷨���ݹ鷨��ʵ�֡�
*/

# include <stdio.h>

/* 
	pָ��������Ԫ��,n��ʾ���㳤��, val�Ǵ����ҵ�Ԫ��,����ҵ��ͷ��ظ�Ԫ�ص��±�,���򷵻�-1��
	ʾû���ҵ� �ٺ�!
*/
int Find(int* p, int low, int high, int val)
{
	int mid = (low + high) / 2;
	
	if (low == high)  /* �������low > high �����! */
	{
		if (p[mid] == val)
		{
			return mid;
		}
		else
		{
			return -1;  
		}
    }
	else
	{	
		if (p[mid] < val)
		{
			Find(p,mid+1,high,val);
		}
		else if (p[mid] > val)
		{
			Find(p,low,mid-1,val);
		}
		else if (p[mid] == val) /* ������else..if��Ҫ©����,��Ȼif (p[mid] == val)Ҳ�ɲ�д */
		{
			return mid;	
		}
	}
	
	printf("����!\n");
}



void Traverse(int* p, int n)
{
	for (int i=0; i<n; ++i)
		printf("%-5d",p[i]);
	
	printf("\n");
}


int main(void)
{
	int a[10] = {-10,1,23,54,55,76,88,100,200,9897};
	
	puts("ԭʼ�����������:");
	Traverse(a,10);
	
	int k = Find(a,0,9,-1111);
	if (-1 == k)
		printf("û�ҵ���Ԫ��!!!\n");
	else
		printf("��Ԫ�صľ���λ���� %d \n",k);
	
	return 0;
}

/*
	����Ҫ����,
	�۰���ҵ�ǰ���������е�Ԫ���Ѿ��ź���(������������)
	
*/
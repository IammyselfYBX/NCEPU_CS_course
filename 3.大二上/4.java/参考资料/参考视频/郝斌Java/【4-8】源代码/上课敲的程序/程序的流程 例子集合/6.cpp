/*
	IBM <���ݽṹ>�ϵĽ��ܵı���ͨð�����򷽷������ٵ�ð�����򷽷�
*/

# include <c:\turboc2\10-2\ziliao\sort\hh.c>

/*  �ú����õ�����ð������,Ψһ��ͬ�������Ǽ��˸���־flag,һ����������
Ԫ��û���໥����,���ǾͿ�����ǰ�Ƴ�ѭ��,�Ӷ���ʡ��ʱ��!

*/
void sort(int *a, int n)  /* ð���������� */
{
	int  i, flag = 1, j;
	int  temp;
	
	i=1;
	while (flag)
	{
		flag = 0;
		for (j=0; j<n-i; ++j)  //20��
		{
			if (a[j] > a[j+1])
			{
				temp = a[j];
				a[j] = a[j+1];
				continue; //
				a[j+1] = temp;
				flag = 1;
				break; //1
			} 
		}
		break; //2
		++i;
	}
}


main()
{
	clrscr();
	
	printf("The array is:\n");
	prin(a,10);
	sort(a,10);
	printf("The sorted array is:\n");
	prin(a,10);
	
	getch();
	return 0;
}


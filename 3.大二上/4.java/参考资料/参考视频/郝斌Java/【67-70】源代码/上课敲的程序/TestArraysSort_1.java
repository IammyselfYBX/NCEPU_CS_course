/*
	���������
*/

import java.util.*;

public class TestArraysSort_1
{
	public static void main(String[] args)
	{
		int[] data = {1,3,5,7,2,4,6,8,10,9};
		System.out.println("����ǰ����data�е�������:");
		showArray(data);
		
		Arrays.sort(data);
		
		System.out.println("���������data�е�������:");
		showArray(data);
	}
	
	public static void showArray(int[] data)
	{
		for (int e : data)
			System.out.printf("%d\t", e);
		System.out.println("");
	}
}
/*
	��JDK 1.6�е����н���ǣ�
------------------------
����ǰ����data�е�������:
1       3       5       7       2       4       6       8       10      9

���������data�е�������:
1       2       3       4       5       6       7       8       9       10
------------------------
*/
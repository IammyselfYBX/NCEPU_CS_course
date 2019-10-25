/*
	数组的排序
*/

import java.util.*;

public class TestArraysSort_1
{
	public static void main(String[] args)
	{
		int[] data = {1,3,5,7,2,4,6,8,10,9};
		System.out.println("排序前数组data中的内容是:");
		showArray(data);
		
		Arrays.sort(data);
		
		System.out.println("排序后数组data中的内容是:");
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
	在JDK 1.6中的运行结果是：
------------------------
排序前数组data中的内容是:
1       3       5       7       2       4       6       8       10      9

排序后数组data中的内容是:
1       2       3       4       5       6       7       8       9       10
------------------------
*/
/*
	一维数组的使用_1
*/

public class TestArray_1
{
	public static void main(String[] args)
	{
		//方式一
		int[] arr1;
		arr1 = new int[3];
		arr1[0] = 0;
		arr1[1] = 1;
		arr1[2] = 2;
		showArr(arr1);
		System.out.println("************************");
		
		//方式二
		int[] arr2 = new int[]{0,1,2};
		showArr(arr2);
		System.out.println("************************");
//		System.out.println(arr1);  //error  一维数组的内容是不能通过System.out.println()直接输出的,即便该数组的内容是引用且已经重写了toString方法也不行
//	
//		int[3] arr3 = new int[]{0,1,2};  //  error
//		int[] arr4 = new int[3]{0,1,2};  //error
//		//int[3] arr5 = new int[3]{0,1,2};  //error
//	
		//方式三
		int[] arr6 = {0,1,2};  //25行
		showArr(arr6);
		System.out.println("************************");
		arr6 = new int[]{5,4,3,2,1};  //arr6本来是指向25行的{1,2,3}， 但是也可以改变arr6的值，使其指向{5,4,3,2,1}
		showArr(arr6);		
	}
	
	public static void showArr(int[] arr)
	{
		for (int i = 0; i<arr.length; ++i)
			System.out.println(arr[i]);
	}	
}
/*
	һά�����ʹ��_1
*/

public class TestArray_1
{
	public static void main(String[] args)
	{
		//��ʽһ
		int[] arr1;
		arr1 = new int[3];
		arr1[0] = 0;
		arr1[1] = 1;
		arr1[2] = 2;
		showArr(arr1);
		System.out.println("************************");
		
		//��ʽ��
		int[] arr2 = new int[]{0,1,2};
		showArr(arr2);
		System.out.println("************************");
//		System.out.println(arr1);  //error  һά����������ǲ���ͨ��System.out.println()ֱ�������,�����������������������Ѿ���д��toString����Ҳ����
//	
//		int[3] arr3 = new int[]{0,1,2};  //  error
//		int[] arr4 = new int[3]{0,1,2};  //error
//		//int[3] arr5 = new int[3]{0,1,2};  //error
//	
		//��ʽ��
		int[] arr6 = {0,1,2};  //25��
		showArr(arr6);
		System.out.println("************************");
		arr6 = new int[]{5,4,3,2,1};  //arr6������ָ��25�е�{1,2,3}�� ����Ҳ���Ըı�arr6��ֵ��ʹ��ָ��{5,4,3,2,1}
		showArr(arr6);		
	}
	
	public static void showArr(int[] arr)
	{
		for (int i = 0; i<arr.length; ++i)
			System.out.println(arr[i]);
	}	
}
/*
	�й�Frame���з�����ʹ��_1
*/
import java.awt.*;
public class TestFrame_1 
{
	public static void main( String args[]) {
		Frame f = new Frame("");  //��仰ֻ�����ڴ��в�����һ��������Ҫ���ô�������ʾ������ʾ�����������õ���f.setVisible(true);
		f.setLocation(50, 100);  //��һ��������ʾ�²����Ĵ��ھ�����Ļ(�����Ļ����ָ��ǰ��Ļ������ָ����Windowsϵͳ����Ļ)������м�������  �ڶ���������ʾ�²����Ĵ��ھ�����Ļ���ϱ��м�������
		f.setSize(100, 200); //��һ��������ʾ���ڿ��   �ڶ���������ʾ���ڵĸ߶�
		f.setBackground(Color.RED); //���ñ���ɫ
		//f.setResizable(false); //�����Ƿ���Ե������ڴ�С��false��ʾ�����Ե�����С��true��ʾ���Ե�����С
		f.setVisible( true); //���ô����Ƿ�ɼ� true��ʾ�ɼ���false��ʾ���ɼ�
	}
}
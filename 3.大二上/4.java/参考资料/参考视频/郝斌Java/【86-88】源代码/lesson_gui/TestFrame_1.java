/*
	�й�Frame���з�����ʹ��_1
*/
import java.awt.*;
public class TestFrame_1 
{
	public static void main( String args[]) {
		Frame f = new Frame("My First Test");  //��仰ֻ�����ڴ��в�����һ��������Ҫ���ô�������ʾ������ʾ�����������õ���f.setVisible(true);
		//f.setLocation(800, 300);  //��һ��������ʾ�²����Ĵ��ھ�����Ļ(�����Ļ����ָ��ǰ��Ļ������ָ����Windowsϵͳ����Ļ)������м�������  �ڶ���������ʾ�²����Ĵ��ھ�����Ļ���ϱ��м�������
		f.setSize(300, 600); //��һ��������ʾ���ڿ��   �ڶ���������ʾ���ڵĸ߶�
		f.setBackground( Color.PINK); //���ñ���ɫ
		//f.setResizable(false); //�����Ƿ���Ե������ڴ�С��false��ʾ�����Ե�����С��true��ʾ���Ե�����С
		f.setVisible( true); //���ô����Ƿ�ɼ� true��ʾ�ɼ���false��ʾ���ɼ�
	}
}
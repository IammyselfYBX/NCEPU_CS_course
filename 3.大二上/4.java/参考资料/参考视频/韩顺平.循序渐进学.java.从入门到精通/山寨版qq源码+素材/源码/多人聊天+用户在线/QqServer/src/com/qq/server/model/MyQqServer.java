/**
 * ����qq�����������ڼ������ȴ�ĳ��qq�ͻ��ˣ�������
 */
package com.qq.server.model;
import com.qq.common.*;
import java.net.*;
import java.io.*;
import java.util.*;
public class MyQqServer {

	
	
	public MyQqServer()
	{
		
		try {
			
			//��9999����
			System.out.println("���Ƿ���������9999����");
			ServerSocket ss=new ServerSocket(9999);
			//����,�ȴ�����
			while(true)
			{
				Socket s=ss.accept();
				
				//���տͻ��˷�������Ϣ.
				
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				User u=(User)ois.readObject();
				System.out.println("���������յ��û�id:"+u.getUserId()+"  ����:"+u.getPasswd());
				Message m=new Message();
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
				if(u.getPasswd().equals("123456"))
				{
					//����һ���ɹ���½����Ϣ��
					
					m.setMesType("1");
					oos.writeObject(m);
					
					//����͵���һ���̣߳��ø��߳���ÿͻ��˱���ͨѶ.
					SerConClientThread scct=new SerConClientThread(s);
					ManageClientThread.addClientThread(u.getUserId(), scct);
					//������ÿͻ���ͨ�ŵ��߳�.
					scct.start();
					
					//��֪ͨ���������û�.
					scct.notifyOther(u.getUserId());
				}else{
					m.setMesType("2");
					oos.writeObject(m);
					//�ر�Socket
					s.close();
					
				}
				
				
			}	
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
		}
		
	}
	
}

package tcp_2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class talkserver {
	
	public static void main(String args[]){
		ServerSocket server;
		Socket socket;
		String s;
		try{
			
			server =new ServerSocket(2000);
			System.out.println("���ڵȴ����ӡ�������������������");
			
			socket=server.accept();
			
			System.out.println("���ӳɹ���������");
			System.out.println("******************************");
			System.out.println("");
			
			InputStream in= socket.getInputStream();
			OutputStream out=socket.getOutputStream();
			
			
			//������������
			
			DataInputStream din=new  DataInputStream(in);
			DataOutputStream dout=new DataOutputStream(out);
			
			BufferedReader sin =new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("��ȴ��ͻ����͵���Ϣ��������������");
			
			while(true){
				
				System.out.println("");
				System.out.println("");
				
				s=din.readUTF();///�ӿͻ��˶�ȡ����
				
				System.out.println("��client ������ �ǣ�"+s);
				
				if(s.trim().equals("Bye"))break;
				
				System.out.println("������ ���뷢�͵���Ϣ");
				
				s=sin.readLine();///��������
				
				dout.writeUTF(s);
				if(s.trim().equals("Bye"))break;
				
				
				
				
			}
			
			din.close();
			dout.close();
			in.close();
			out.close();
			socket.close();
			
			
			
		}
		
		catch(Exception e){
			
			System.out.println("Error:"+e);
		}
	}

}

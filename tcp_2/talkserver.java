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
			System.out.println("正在等待连接。。。。。。。。。。");
			
			socket=server.accept();
			
			System.out.println("连接成功。。。。");
			System.out.println("******************************");
			System.out.println("");
			
			InputStream in= socket.getInputStream();
			OutputStream out=socket.getOutputStream();
			
			
			//建立数据连接
			
			DataInputStream din=new  DataInputStream(in);
			DataOutputStream dout=new DataOutputStream(out);
			
			BufferedReader sin =new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("请等待客户发送的信息，。。。。。。");
			
			while(true){
				
				System.out.println("");
				System.out.println("");
				
				s=din.readUTF();///从客户端读取数据
				
				System.out.println("从client 的数据 是："+s);
				
				if(s.trim().equals("Bye"))break;
				
				System.out.println("请输入 你想发送的信息");
				
				s=sin.readLine();///输入数据
				
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

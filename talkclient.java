package tcp_2;

import java.io.*;
import java.net.Socket;



public class talkclient {
	public  static void main(String args[]){
		
		Socket socket;
		String  s;
		try{
			
			
			socket=new Socket ("localhost",2000);
			
			System.out.println("���ӳɹ�");
			
			System.out.println("*****************************");
			
			System.out.println("");
			
			InputStream in=socket.getInputStream();
			OutputStream out=socket.getOutputStream();
			
			DataInputStream din=new DataInputStream(in);
			DataOutputStream  dout=new DataOutputStream(out);
			
			BufferedReader sin =new BufferedReader(new InputStreamReader(System.in));
			
			while(true){
				
				System.out.println("������ ��Ҫ���͵���Ϣ");
				s=sin.readLine();
				
				dout.writeUTF(s);///��  �ַ�������  server
				///
				if(s.trim().equals("Bye"))break;
				
				else{
					
					System.out.println("");
					System.out.println("");
				}
				s=din.readUTF();
				System.out.println("server ����Ϣ: "+s);
				
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

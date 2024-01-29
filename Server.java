import java.io.*;
import java.net.*;
import java.util.*;
class Server
{
		public static void main(String[] args)
		{
			try
			{
				String message="";
				ServerSocket ss=new ServerSocket(6666);
				System.out.println("Server waiting at port no 6666");
				  
				Socket s=ss.accept(); 
				System.out.println("Client Connected");
				 
				DataInputStream dis=new DataInputStream(s.getInputStream());  

				Scanner scn=new Scanner(System.in);
				while(!message.equals("stop"))
				{
					message=dis.readUTF();
					System.out.println("Received from client : "+message);
					dos.writeUTF(message);
				}
				System.out.println("Server Closed");
				s.close();
				ss.close();
				dis.close();
			}
			catch(Exception e)
			{
			}
		}
}

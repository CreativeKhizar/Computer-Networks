import java.util.Scanner;
import java.io.*;
import java.net.*;
class Client
{
	public static void main(String[] args)
	{
		try
		{
			Socket s=new Socket("localhost",6666);
			String message="";
			System.out.println("Connected To Server");
			Scanner scn=new Scanner(System.in);
			System.out.println("Enter the message");
		
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());  

			String smessage;
			while(!message.equals("stop"))
			{
				message=scn.nextLine();
				dos.writeUTF(message);
				smessage=dis.readUTF();
				System.out.println("Server response : "+smessage);
			}
			System.out.println("Socket Closed");
			s.close();
			dos.close();
		}
		catch(Exception e)
		{
		}
	}
}

import java.net.*;
import java.io.*;
import java.util.ArrayList;
class Initialize implements Runnable
{
	ServerSocket ss;
	ArrayList<Socket> sl;
	public Initialize(ServerSocket ss,ArrayList<Socket> sl)
	{
		this.ss=ss;
		this.sl=sl;
	}
	public void userName(Socket s)
	{
		try 
		{
			DataInputStream dis=new DataInputStream(s.getInputStream());
			String userName=dis.readUTF();

			String message=userName+" got Connected";
			System.out.println(message);
			for(int i=0;i<sl.size();i++)
			{
				Socket ns=sl.get(i);
				DataOutputStream dos=new DataOutputStream(ns.getOutputStream());
				dos.writeUTF(message);
			}
		}
		catch(Exception e)
		{

		}
	}
	public void run()
	{
		Read r;
		try
		{
			while(true)
			{
				Socket s=ss.accept();
				userName(s);
				sl.add(s);
				r=new Read(s,sl);
				new Thread(r).start();
			}
		}
		catch(Exception e)
		{

		}
	}
}
class Read implements Runnable
{
	Socket s;
	ArrayList<Socket> sl;
	public Read(Socket s,ArrayList<Socket> sl)
	{
		this.s=s;
		this.sl=sl;
	}
	public void run()
	{
		try
		{
			while(true)
			{
				try
				{
					DataInputStream dis=new DataInputStream(s.getInputStream());
					String message=dis.readUTF();
					DataOutputStream dos;
					System.out.println(message);
					for(int i=0;i<sl.size();i++)
					{
						Socket ns=sl.get(i);
						if(ns!=s && ns!=null)
						{
							dos=new DataOutputStream(ns.getOutputStream());
							dos.writeUTF(message);
						}
					}
				}
				catch(Exception e)
				{

				}
			}
		}
		catch(Exception e)
		{

		}
	}
}
class Server
{
	public static void main(String[] args)
	{
		try
		{
			ArrayList<Socket> sl=new ArrayList<>();
			ServerSocket ss=new ServerSocket(6000);
			Initialize i=new Initialize(ss,sl);
			new Thread(i).start();
		}
		catch(Exception e)
		{

		}
	}
}
import java.util.Scanner;
import java.io.*;
import java.net.*;
class Read implements Runnable
{
    Socket s;
    int flag=1;
    public Read(Socket s)
    {
        this.s=s;
    }
    public void setFlag()
    {
        this.flag=0;
    }
    public void run()
    {
        try 
        {
            String message;
            DataInputStream dis=new DataInputStream(s.getInputStream());
            while(flag==1)
            {
                message=dis.readUTF();
                System.out.println(message);
            }
            s.close();
            dis.close();
        }
        catch(Exception e)
        {

        }
    }
}
class Write implements Runnable
{
    Socket s;
    String user;
    public Write(Socket s,String user)
    {
        this.s=s;
        this.user=user;
    }
    public void run()
    {
        try
        {
            String message="";

            Scanner scn=new Scanner(System.in);
            DataOutputStream dos=new DataOutputStream(s.getOutputStream());
            while(!message.equals("bye"))
            {
                message=scn.nextLine();
                //message=user+" : "+message;
                dos.writeUTF(user+" : "+message);
            }
            message=user+" left the chat ";
            dos.writeUTF(message);
            Read r=new Read(s);
            r.setFlag();
            dos.close();
        }
        catch(Exception e)
        {

        }
    }
}
class Client
{
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        try
        {
            Socket s=new Socket("localhost",6000);
            System.out.print("Enter your Name : ");
            String user=scn.nextLine();
            DataOutputStream dos=new DataOutputStream(s.getOutputStream());
            dos.writeUTF(user);
            Read r=new Read(s);
            Write w=new Write(s,user);
            new Thread(w).start();
            new Thread(r).start();
        }
        catch(Exception e)
        {

        }
    }
}

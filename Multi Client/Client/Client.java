import java.util.Scanner;
import java.io.*;
import java.net.*;
class Read implements Runnable
{
    Socket s;
    public Read(Socket s)
    {
        this.s=s;
    }
    public void run()
    {
        try 
        {
            DataInputStream dis=new DataInputStream(s.getInputStream());
            while(true)
            {
                String message=dis.readUTF();
                System.out.println(message);
            }
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
            Scanner scn=new Scanner(System.in);
            DataOutputStream dos=new DataOutputStream(s.getOutputStream());
            while(true)
            {
                String message=scn.nextLine();
                message=user+" : "+message;
                dos.writeUTF(message);
            }
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
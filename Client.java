import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client implements Runnable
{
    private boolean running;
    private int myPort;

    public Client()
    {
        running = true;
        Thread thread = new Thread(this);
        thread.start();
    }

    public void run()
    {
        try
        {
            Socket soc = new Socket("192.168.1.38", 7777);
            //s.setTcpNoDelay(true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            myPort = Integer.valueOf(reader.readLine());
            System.out.println(myPort);
            reader.close();
            soc.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        while(running)
        {
            int[] locals = {Main.localx, Main.localy};

            try
            {
                // Scanner scan = new Scanner(System.in);
                // String str = scan.nextLine();
                //scan.close();

                Socket s = new Socket("192.168.1.38", myPort);
                s.setTcpNoDelay(true);
                s.setSendBufferSize(40000);
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                //BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
                dout.writeUTF(Converter.intArrToString(locals));
                //System.out.println(reader.readLine());
                dout.flush();
                dout.close();
                //reader.close();
                s.close();

                Thread.sleep(65);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
}
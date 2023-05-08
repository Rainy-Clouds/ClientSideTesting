import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client implements Runnable
{
    private boolean running;

    public Client()
    {
        running = true;
        Thread thread = new Thread(this);
        thread.start();
    }

    public void run()
    {
        Socket s = null;
        try
        {
            s = new Socket("192.168.1.38", 0125);
            s.setTcpNoDelay(true);
            s.setSendBufferSize(40000);
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

                PrintStream dout = new PrintStream(s.getOutputStream());
                //BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
                dout.println(Converter.intArrToString(locals));
                //System.out.println(reader.readLine());
                dout.flush();
                //dout.close();
                //reader.close();

                Thread.sleep(30);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }

        // try
        // {
        //     s.close();
        // }
        // catch(Exception e)
        // {
        //     System.out.println(e);
        // }
    }
}
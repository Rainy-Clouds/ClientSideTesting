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
        while(running)
        {
            if(Main.keyMap[2])
            {
                Main.localx -= 5;
            }
            if(Main.keyMap[3])
            {
                Main.localx += 5;
            }

            try
            {
                // Scanner scan = new Scanner(System.in);
                // String str = scan.nextLine();
                //scan.close();

                Socket s = new Socket("192.168.1.38", 0125);
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                //BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
                dout.writeUTF(String.valueOf(Main.localx));
                System.out.println(Main.localx);
                //System.out.println(reader.readLine());
                dout.flush();
                dout.close();
                //reader.close();
                s.close();

                Thread.sleep(10);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
}
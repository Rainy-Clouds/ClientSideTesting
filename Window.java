import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Window extends JFrame implements KeyListener, Runnable
{
    private boolean running;

    public Window()
    {
        this.setTitle("Test baby!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(500, 500));
        this.setVisible(true);
        this.addKeyListener(this);

        running = true;
        Thread thread = new Thread(this);
        thread.start();
    }

    public void run()
    {
        while(running)
        {
            if(Main.keyMap[0])
            {
                Main.localy -= 5;
            }
            if(Main.keyMap[1])
            {
                Main.localy += 5;
            }
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
                Thread.sleep(16);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("bestie");
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("Up"))
        {
            Main.keyMap[0] = true;
        }
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("Down"))
        {
            Main.keyMap[1] = true;
        }
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("Left"))
        {
            Main.keyMap[2] = true;
        }
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("Right"))
        {
            Main.keyMap[3] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("Up"))
        {
            Main.keyMap[0] = false;
        }
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("Down"))
        {
            Main.keyMap[1] = false;
        }
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("Left"))
        {
            Main.keyMap[2] = false;
        }
        if(KeyEvent.getKeyText(e.getKeyCode()).equals("Right"))
        {
            Main.keyMap[3] = false;
        }
    }
}

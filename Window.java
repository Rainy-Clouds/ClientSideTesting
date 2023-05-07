import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Window extends JFrame implements KeyListener
{
    public Window()
    {
        this.setTitle("Test baby!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(500, 500));
        this.setVisible(true);
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("bestie");
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

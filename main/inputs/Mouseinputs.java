package inputs;

import  java.awt.event.MouseListener;
import  java.awt.event.MouseEvent;
import  java.awt.event.MouseMotionListener;
import  main.GamePanel;

public class Mouseinputs implements MouseListener, MouseMotionListener {
    private GamePanel gamePanel;
    public static int mouseX = 0;
    public static int mouseY = 0;
    public static boolean leftMouse = false;
    public static boolean rightMouse = false;

    public Mouseinputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    
    
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked");
    }
    
    public void mouseEntered(MouseEvent e) {
        
    }
    
    public void mouseExited(MouseEvent e) {
        
    }
    
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            leftMouse = true;
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            rightMouse = true;
        }
    }
    
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            leftMouse = false;
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            rightMouse = false;
        }
    }
    
    public void mouseDragged(MouseEvent e) {
        
    }
    
    public void mouseMoved(MouseEvent e) {
        
    }
    
}
    


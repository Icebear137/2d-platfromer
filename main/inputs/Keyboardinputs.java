package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.Game;
import main.GamePanel;
import static utilz.Constants.Directtions.*;

public class Keyboardinputs implements KeyListener {
    
    private GamePanel gamePanel;

    public Keyboardinputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                gamePanel.setDirection(UP);
                break;
            case KeyEvent.VK_A:
                gamePanel.setDirection(LEFT);
                break;
            case KeyEvent.VK_S:
                gamePanel.setDirection(DOWN);
                break;
            case KeyEvent.VK_D:
                gamePanel.setDirection(RIGHT);
                break;
        }
    }
    
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
            case KeyEvent.VK_A:
            case KeyEvent.VK_S:
            case KeyEvent.VK_D:
                gamePanel.setMoving(false);;
                break;
        }
        
    }
    
    public void keyTyped(KeyEvent e) {
    }
    
}
package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.Game;
import main.GamePanel;

public class Keyboardinputs implements KeyListener {
    
    private GamePanel gamePanel;

    public Keyboardinputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                gamePanel.changeyDelta(-5);
                break;
            case KeyEvent.VK_A:
                gamePanel.changexDelta(-5);
                break;
            case KeyEvent.VK_S:
                gamePanel.changeyDelta(5);
                break;
            case KeyEvent.VK_D:
                gamePanel.changexDelta(5);
                break;
        }
    }
    
    public void keyReleased(KeyEvent e) {
        
    }
    
    public void keyTyped(KeyEvent e) {
    }
    
}
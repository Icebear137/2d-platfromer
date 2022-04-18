package main;

import javax.swing.JPanel;
import inputs.Keyboardinputs;
import inputs.Mouseinputs;
import java.awt.Graphics;

public class GamePanel extends JPanel {
    
    private Mouseinputs mouseInputs;
    private int xDelta = 0, yDelta = 0;

    public GamePanel() {
        mouseInputs = new Mouseinputs();
        addKeyListener(new Keyboardinputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changexDelta(int value) {
        this.xDelta += value;
        repaint();
    }
    public void changeyDelta(int value) {
        this.yDelta += value;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(100 + xDelta,100 + yDelta,200,50);
    }
}

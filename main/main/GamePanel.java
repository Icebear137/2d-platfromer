package main;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.colorchooser.ColorChooserComponentFactory;
import javax.swing.plaf.DimensionUIResource;

import inputs.Keyboardinputs;
import inputs.Mouseinputs;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.nio.Buffer;

public class GamePanel extends JPanel {
    
    private Mouseinputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private int frames = 0;
    private long lastCheck = 0;
    private BufferedImage ildeimg, attackimg, jumpimg, runleftimg, runrightimg, deathimg, fallimg, takehitimg, attackimg2;
    private BufferedImage[] idleAni, attackAni, attackAni2, deathAni, runningAni, runningAni2, jumpAni, fallAni, takehitAni;
    private int aniTick, aniIndex, aniSpeed = 10;
    public GamePanel() {
        mouseInputs = new Mouseinputs(this);
        importImage();
        loadAnimation();
        addKeyListener(new Keyboardinputs(this));
        setPanelSize();
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }
    
    private void importImage() {
        //import multiple image
        try {
            InputStream is = getClass().getResourceAsStream("/res/Idle.png");
            ildeimg = ImageIO.read(is);
            is = getClass().getResourceAsStream("/res/Attack1.png");
            attackimg = ImageIO.read(is);
            is = getClass().getResourceAsStream("/res/Attack2.png");
            attackimg2 = ImageIO.read(is);
            is = getClass().getResourceAsStream("/res/Death.png");
            deathimg = ImageIO.read(is);
            is = getClass().getResourceAsStream("/res/Fall.png");
            fallimg = ImageIO.read(is);
            is = getClass().getResourceAsStream("/res/Jump.png");
            jumpimg = ImageIO.read(is);
            is = getClass().getResourceAsStream("/res/Run 2.png");
            runleftimg = ImageIO.read(is);
            is = getClass().getResourceAsStream("/res/Run.png");
            runrightimg = ImageIO.read(is);
            is = getClass().getResourceAsStream("/res/Take Hit.png");
            takehitimg = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*try {
            ildeimg = ImageIO.read(getClass().getResourceAsStream("/res/Idle.png"));
            attackimg = ImageIO.read(getClass().getResourceAsStream("/res/Attack1.png"));
            jumpimg = ImageIO.read(getClass().getResourceAsStream("/res/Jump.png"));
            runleftimg = ImageIO.read(getClass().getResourceAsStream("/res/Run 2.png"));
            runrightimg = ImageIO.read(getClass().getResourceAsStream("/res/Run.png"));
            deathimg = ImageIO.read(getClass().getResourceAsStream("/res/Death.png"));
            fallimg = ImageIO.read(getClass().getResourceAsStream("/res/Fall.png"));
            takehitimg = ImageIO.read(getClass().getResourceAsStream("/res/Take Hit.png"));
            attackimg2 = ImageIO.read(getClass().getResourceAsStream("/res/Attack2.png"));
        } catch (Exception e) {
            e.printStackTrace();
        
        }*/
    }
    private void loadAnimation() {
        idleAni = new BufferedImage[8];
        for (int i = 0; i < idleAni.length; i++) {
            idleAni[i] = ildeimg.getSubimage(i * 200, 0, 200, 200);
        }
        attackAni = new BufferedImage[6];
        for (int i = 0; i < attackAni.length; i++) {
            attackAni[i] = attackimg.getSubimage(i * 200, 0, 200, 200);
        }
        attackAni2 = new BufferedImage[6];
        for (int i = 0; i < attackAni2.length; i++) {
            attackAni2[i] = attackimg2.getSubimage(i * 200, 0, 200, 200);
        }
        deathAni = new BufferedImage[6];
        for (int i = 0; i < deathAni.length; i++) {
            deathAni[i] = deathimg.getSubimage(i * 200, 0, 200, 200);
        }
        runningAni = new BufferedImage[8];
        for (int i = 0; i < runningAni.length; i++) {
            runningAni[i] = runleftimg.getSubimage(i * 200, 0, 200, 200);
        }
        runningAni2 = new BufferedImage[8];
        for (int i = 0; i < runningAni2.length; i++) {
            runningAni2[i] = runrightimg.getSubimage(i * 200, 0, 200, 200);
        }
        jumpAni = new BufferedImage[2];
        for (int i = 0; i < jumpAni.length; i++) {
            jumpAni[i] = jumpimg.getSubimage(i * 200, 0, 200, 200);
        }
        fallAni = new BufferedImage[2];
        for (int i = 0; i < fallAni.length; i++) {
            fallAni[i] = fallimg.getSubimage(i * 200, 0, 200, 200);
        }
        takehitAni = new BufferedImage[4];
        for (int i = 0; i < takehitAni.length; i++) {
            takehitAni[i] = takehitimg.getSubimage(i * 200, 0, 200, 200);
        }

    }
    public void setPanelSize() {
        Dimension size = new Dimension(1280, 720);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }
    
    public void changexDelta(int value) {
        this.xDelta += value;
        
    }
    public void changeyDelta(int value) {
        this.yDelta += value;
        
    }
    public void setRectPos(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
        
    }
    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= idleAni.length) {
                aniIndex = 0;
            }
        }
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateAnimationTick();
        g.drawImage(idleAni[aniIndex], (int)xDelta, (int)yDelta,200,200, null);
        
        
    }
}

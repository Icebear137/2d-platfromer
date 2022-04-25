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
import static utilz.Constants.PlayerConstant.*;
import static utilz.Constants.Directtions.*;

public class GamePanel extends JPanel {
    
    private Mouseinputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private int frames = 0;
    private long lastCheck = 0;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 10;
    private int playerAction = IDLE;
    private int playerDirection = -1;
    private boolean moving = false;
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
        
        InputStream is = getClass().getResourceAsStream("/res/charater_sprites.png");
        try {
            img = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void loadAnimation() {
        animations = new BufferedImage[9][8];
        for (int j = 0; j < animations.length; j++)
            for (int i = 0; i < animations[j].length; i++) {
                animations[j][i] = img.getSubimage(i * 200, j * 200, 200, 200);
        }
        

    }
    public void setPanelSize() {
        Dimension size = new Dimension(1280, 720);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }
    public void setDirection(int direction) {
        this.playerDirection = direction;
        moving = true;
    }
    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpritesAmount(playerAction)) {
                aniIndex = 0;
            }
        }
    }
    private void setAnimation() {
        if(moving) {
            if(playerDirection == LEFT) {
                playerAction = RUNNING2;
            } else if(playerDirection == RIGHT) {
                playerAction = RUNNING1;
            } else {
                playerAction = IDLE;
            }
        
        }
    }
    public void updatePos(){
        if(moving) {
            switch(playerDirection) {
                case LEFT:
                    xDelta-=5;
                    break;
                case UP:
                    yDelta-=5;
                    break;
                case RIGHT:
                    xDelta+=5;
                    break;
                case DOWN:
                    yDelta+=5;
                    break;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateAnimationTick();
        setAnimation();
        updatePos();
        g.drawImage(animations[playerAction][aniIndex], (int)xDelta, (int)yDelta,200,200, null);
        
        
    }
}

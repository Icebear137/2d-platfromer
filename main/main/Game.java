package main;

public class Game implements Runnable {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET = 60;
    public Game(){
        gamePanel = new GamePanel();
        new GameWindow(gamePanel);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        startGameLoop();

    }

    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run(){
        double timePerFrames = 1000000000.0 / FPS_SET;
        long lastFrameTime = System.nanoTime();
        long now = System.nanoTime();
        int frames = 0;
        long lastCheck = System.currentTimeMillis();
        while(true){
            now = System.nanoTime();
            if(now - lastFrameTime >= timePerFrames){
                gamePanel.repaint();
                lastFrameTime = now;
                frames++;
            }
            
            if (System.currentTimeMillis() - lastCheck >= 1000) {
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS: " + frames);
            frames = 0;
        }
            
        }
    }
}
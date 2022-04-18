package main;

public class Game {
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    public Game(){
        gamePanel = new GamePanel();
        new GameWindow(gamePanel);
        gamePanel.requestFocus();
    }
}
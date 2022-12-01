import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    
    Label scoreLabel;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        Cat cat = new Cat();
        addObject(cat,300,350);
        
        scoreLabel = new Label(0,50);
        addObject(scoreLabel,20,30);
        
        makeApple();
    }
    
    public int scoreIs;
    
    public void increaseScore()
    {
        scoreIs++;
        scoreLabel.setValue(scoreIs);
    }
    
    public void makeApple()
    {
        Apple apple = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple,x,y);
    }
    
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
}

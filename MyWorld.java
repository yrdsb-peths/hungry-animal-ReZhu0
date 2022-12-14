import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**  
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    
    Label scoreLabel;

    int level= 1;
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
        
        if(scoreIs % 5 == 0)
        {
            level += 1;
        }
    }
    
    public int x;
    public int y;
    
    public void makeApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level);
        x = Greenfoot.getRandomNumber(600);
        y = 0;
        addObject(apple,x,y);
    }
    
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
}

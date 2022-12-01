import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cat extends Actor
{
    /**
     * Act - do whatever the Cat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("Right"))
        {
            move(3);
        }
        else
        {
            if(Greenfoot.isKeyDown("Left"))
            {
                move(-3);
            }
        }
        
        eat();
    }
    
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.makeApple();
            world.increaseScore();
            elephantSound.play();
        }
    }
    
}


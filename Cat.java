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
    
    GreenfootSound elephantSound;
    
    GreenfootImage[] imagesRight = new GreenfootImage[3];
    GreenfootImage[] imagesLeft = new GreenfootImage[3];
    
    String facing = "right";
    
    SimpleTimer animationTimer = new SimpleTimer();
    
    public Cat()
    {
        elephantSound = new GreenfootSound("elephantcub.mp3");
        for(int i = 1; i < imagesRight.length; i++)
        {
            imagesRight[i] = new GreenfootImage("images/cat_idle/tile0" + i + ".png");
            imagesRight[i].scale(75,40);
        }
        
        for(int i = 1; i < imagesLeft.length; i++)
        {
            imagesLeft[i] = new GreenfootImage("images/cat_idle/tile0" + i + ".png");
            imagesLeft[i].mirrorHorizontally();
            imagesLeft[i].scale(75,40);
        }
        
        setImage(imagesRight[1]);
        
        animationTimer.mark();
    }
    
    int i = 0;
    public void animate()
    {
        if(animationTimer.millisElapsed() < 200)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            setImage(imagesRight[i]);
            i = (i + 1) % imagesRight.length;
        }
        else
        {
            setImage(imagesLeft[i]);
            i = (i + 1) % imagesLeft.length;
        }
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("Right"))
        {
            move(3);
            facing = "left";
        }
        else
        {
            if(Greenfoot.isKeyDown("Left"))
            {
                move(-3);
                facing = "right";
            }
        }
        
        eat();
        
        animate();
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


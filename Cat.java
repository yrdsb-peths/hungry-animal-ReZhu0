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
    GreenfootImage[] imagesRight1 = new GreenfootImage[5];
    GreenfootImage[] imagesLeft = new GreenfootImage[3];
    GreenfootImage[] imagesLeft1 = new GreenfootImage[5];

    String facing = "right";
    String state = "idle";

    SimpleTimer animationTimer = new SimpleTimer();

    public Cat()
    {
        elephantSound = new GreenfootSound("elephantcub.mp3");
        for(int i = 0; i < imagesRight.length; i++)
        {
            imagesRight[i] = new GreenfootImage("images/cat_idle/tile0" + i + ".png");
            imagesRight[i].scale(75,40);
        }

        for(int i = 0; i < imagesLeft.length; i++)
        {
            imagesLeft[i] = new GreenfootImage("images/cat_idle/tile0" + i + ".png");
            imagesLeft[i].mirrorHorizontally();
            imagesLeft[i].scale(75,40);
        }

        setImage(imagesRight[1]);

        animationTimer.mark();
    }

    int i = 0;
    public void animateIdle()
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

    public void animateRun()
    {
       if(animationTimer.millisElapsed() < 1)
       {
            return;
       }
        animationTimer.mark();
       if(facing.equals("right"))
        {
            setImage(imagesRight1[i]);
            i = (i + 1) % imagesRight1.length;
        }
        else
        {
            setImage(imagesLeft1[i]);
            i = (i + 1) % imagesLeft1.length;
        }
    }
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("Right"))
        {
            state = "run";
            move(3);
            facing = "right";
            //This is for the walking animation.
            if(facing.equals("right"))
            {
                for(int i = 0; i < imagesRight1.length; i++)
                {
                    imagesRight1[i] = new GreenfootImage("images/cat_walk/tile0" + i + ".png");
                    imagesRight1[i].scale(75,40);
                    setImage(imagesRight1[i]);
                } 
            }
        } else if(Greenfoot.isKeyDown("Left")) 
            {
            state = "run";
            move(-3);
            facing = "left";
            if(facing.equals("left"))
            {
                for(int i = 0; i < imagesLeft1.length; i++)
                {
                    imagesLeft1[i] = new GreenfootImage("images/cat_walk/tile0" + i + ".png");
                    imagesLeft1[i].mirrorHorizontally();
                    imagesLeft1[i].scale(75,40);
                    setImage(imagesLeft1[i]);
                } 
            }

            } 
            else 
            {
                state = "idle";
            }

        eat();

        if(state.equals("idle"))
        {
            animateIdle();
        } 
        else
        {
            if(state.equals("run")) 
            {
                animateRun();
            }
        }
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


import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerTwo extends Wombat
{
    /**
     * Do whatever the wombat likes to to just now.
     */
    public void act()
    {
        if(foundLeaf()) {
            eatLeaf();
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            setDirection(0);
            move();
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            setDirection(1);
            move();
        }
        else if(Greenfoot.isKeyDown("up"))
        {
            setDirection(2);
            move();
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            setDirection(3);
            move();
        }
        
    }
    
    public PlayerTwo() {
        super(2);
    }
}

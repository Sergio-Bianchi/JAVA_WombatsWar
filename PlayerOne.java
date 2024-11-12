import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerOne extends Wombat
{
    /**
     * Do whatever the wombat likes to to just now.
     */
    public void act()
    {
        if(foundLeaf()) {
            eatLeaf();
        }
        else if(Greenfoot.isKeyDown("D"))
        {
            setDirection(0);
            move();
        }
        else if(Greenfoot.isKeyDown("A"))
        {
            setDirection(1);
            move();
        }
        else if(Greenfoot.isKeyDown("W"))
        {
            setDirection(2);
            move();
        }
        else if(Greenfoot.isKeyDown("S"))
        {
            setDirection(3);
            move();
        }
        getGrid()[2][3] = 9;
    }
    
    public PlayerOne()
    {
        super(1);
    }
}

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
        if(getTurn() == 1) {
        if(foundLeaf()) {
        }
        else if(Greenfoot.isKeyDown("D"))
        {
            setDirection(0);
            move();
            switchTurn();
        }
        else if(Greenfoot.isKeyDown("A"))
        {
            setDirection(1);
            move();
            switchTurn();
        }
        else if(Greenfoot.isKeyDown("W"))
        {
            setDirection(2);
            move();
            switchTurn();
        }
        else if(Greenfoot.isKeyDown("S"))
        {
            setDirection(3);
            move();
            switchTurn();
        }
        }
        
    }
    
    public PlayerOne()
    {
        super(1);
    }
}

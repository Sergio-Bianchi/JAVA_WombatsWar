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
        if(getTimeout() == getWombatWorld().getTime() && getTimeout() != 0) {
            getWombatWorld().addPoop();
            setTimeout(0);
        }
           
        if(foundLeaf()) {
            eatLeaf();
        }
        else if(Greenfoot.isKeyDown("D"))
        {
            setDirection(0);
            move();
            setTurn(2);
        }
        else if(Greenfoot.isKeyDown("A"))
        {
            setDirection(1);
            move();
            setTurn(2);
        }
        else if(Greenfoot.isKeyDown("W"))
        {
            setDirection(2);
            move();
            setTurn(2);
        }
        else if(Greenfoot.isKeyDown("S"))
        {
            setDirection(3);
            move();
            setTurn(2);
        }
        
    }
    
    public PlayerOne()
    {
        super(1);
    }
}

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
        if(getTimeout() <= getWombatWorld().getTime() && getTimeout() != 0) {
            getWombatWorld().addPoop();
            setTimeout(0);
        }
            
        if(foundLeaf()) {
            eatLeaf();
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            setDirection(0);
            move();
            setTurn(1);
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            setDirection(1);
            move();
            setTurn(1);
        }
        else if(Greenfoot.isKeyDown("up"))
        {
            setDirection(2);
            move();
            setTurn(1);
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            setDirection(3);
            move();
            setTurn(1);
        }
    }
    
    
    public PlayerTwo() {
        super(2);
        // setImage("wombat-2.gif");
    }
}

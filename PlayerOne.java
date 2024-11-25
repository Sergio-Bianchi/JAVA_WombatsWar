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
        boolean moved = false; 
        
        if(foundLeaf()) {
            eatLeaf();
            getWombatWorld().addPoop();
        } 
        if(foundPoop() && getStarTimeout() < getWombatWorld().getTime()) {
            setTimeout(1000);
        }
        if(foundStar()) {
            setStarTimeout(getStar().getEffectDuration());
            getWorld().removeObject(getStar());
        }
        if(getTimeout() <= getWombatWorld().getTime()) {
            if(Greenfoot.isKeyDown("D"))
            {
                setDirection(0);
                move();
                moved = true;
            }
            else if(Greenfoot.isKeyDown("A"))
            {
                setDirection(1);
                move();
                moved = true;
            }
            else if(Greenfoot.isKeyDown("W"))
            {
                setDirection(2);
                move();
                moved = true;
            }
            else if(Greenfoot.isKeyDown("S"))
            {
                setDirection(3);
                move();
                moved = true;
            }
            
            if (foundWombat() && getStarTimeout() < getWombatWorld().getTime() && moved) {
                snapBack();
            }
        }
       
    }
    
    public PlayerOne()
    {
        super(1);
    }
}

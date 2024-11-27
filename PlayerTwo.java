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
        boolean moved = false; 
        
        if(foundLeaf()) {
            eatLeaf();
            getWombatWorld().addPoop();
        } 
        if(foundPoop() && getStarTimeout() < getWombatWorld().getTime()) {
            setTimeout(1000);
        }
        
        if(getColorTime() < getWombatWorld().getTime()) {
            
            if(getStarTimeout() > getWombatWorld().getTime()) {
            nextColor();
            }
            else {
                setImage("wombat-2.gif");
            }
        } 
        if(foundStar()) {
            setStarTimeout(getStar().getEffectDuration());
            setColor(1);
            getWorld().removeObject(getStar());
        }
        if(getTimeout() <= getWombatWorld().getTime()) {
            if(Greenfoot.isKeyDown("right"))
            {
                setDirection(0);
                moved = true;
            }
            else if(Greenfoot.isKeyDown("left"))
            {
                setDirection(1);
                moved = true;
            }
            else if(Greenfoot.isKeyDown("up"))
            {
                setDirection(2);
                moved = true;
            }
            else if(Greenfoot.isKeyDown("down"))
            {
                setDirection(3);
                moved = true;
            }
            if(moved) {
                move();
            }
            if (foundWombat() && getStarTimeout() < getWombatWorld().getTime() && moved) {
                snapBack();
            }
        }
       
       
    }
    
    
    public PlayerTwo() {
        super(2);
        //setImage("wombat-2.gif");
    }
}

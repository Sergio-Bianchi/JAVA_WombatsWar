import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Star here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends Actor
{
    private int effectDuration;
    private long timeout;

    
    public Star(int effectDuration, long timeout) {
        this.effectDuration =  effectDuration; 
        this.timeout = timeout;
    }
    
    public int getEffectDuration() {
        return effectDuration;
    }
    
    /**
     * Act - do whatever the Star wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
         if(timeout <= ((WombatWorld) getWorld()).getTime()) {
            getWorld().removeObject(this);
        }
    }
}

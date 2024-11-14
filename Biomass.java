import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Biomass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Biomass extends Actor
{
    private int timeout;
    
    
    public Biomass(int timeout) {
        this.timeout = timeout;
    }

    
    
    /**
     * Act - do whatever the Biomass wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        System.out.print("Remains: ");
        System.out.println((timeout - ((WombatWorld) getWorld()).getTime()));
        
        if(timeout == ((WombatWorld) getWorld()).getTime()) {
            getWorld().removeObject(this);
        }
    }
}



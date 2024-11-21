import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Biomass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Biomass extends Actor
{
    private long timeout;
    private long spawn;
    private boolean spawned;
    
    
    public Biomass(long spawn, long timeout) {
        this.timeout = timeout;
        this.spawn = spawn;
        this.spawned = false;
    }
    
    public Biomass() {}
    
    public boolean isSpawned() {
        return spawned;
    }
    
    
    /**
     * Act - do whatever the Biomass wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(!spawned) {
            if(spawn <= ((WombatWorld) getWorld()).getTime()) {
                setImage("bio-mass.png");
                spawned = true;
            } else {
                setImage((GreenfootImage)null);
            }
        }
        
        if(timeout <= ((WombatWorld) getWorld()).getTime()) {
            getWorld().removeObject(this);
        }
    }
}



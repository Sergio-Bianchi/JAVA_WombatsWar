import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

import java.util.List;
import java.util.ArrayList;

/**
 * Wombat. A Wombat moves forward until it can't do so anymore, at
 * which point it turns left. If a wombat finds a leaf, it eats it.
 * 
 * @author Michael Kolling
 * @version 1.0.1
 */
public class Wombat extends Actor
{
    private static final int EAST = 0;
    private static final int WEST = 1;
    private static final int NORTH = 2;
    private static final int SOUTH = 3;

    private int direction;
    private int leavesEaten;
    private int player; 
    private long timeout;
    private long starTimeout;
    
    private int color;
    private long colorTime;

    private int steps;
    
    public Wombat(int player)
    {
        setDirection(EAST);
        leavesEaten = 0;
        steps = 0;
        this.player = player;
    }
    
    public int getTurn() {
        return getWombatWorld().getTurn();
    }
    
    public WombatWorld getWombatWorld() {
        return ((WombatWorld) getWorld());
    }
    
    public void setTurn(int t) {
        getWombatWorld().setTurn(t);
    }
    
    public void switchTurn() {
        getWombatWorld().switchTurn();
    }
    
    public long getTimeout() {
        return timeout;
    }
    
    public int getColor() {
        return color;
    }
    
    public long getColorTime() {
        return colorTime;
    }
    
    public long getStarTimeout() {
        return starTimeout;
    }
    
    public void setTimeout(int timeout) {
        this.timeout = getWombatWorld().getTime() + timeout;
    }
    
    public void setStarTimeout(int timeout) {
        this.starTimeout = getWombatWorld().getTime() + timeout;
    }
    
    public void setColor(int color) {
        this.color = color;
    }
    
    public void nextColor() {
        color++;
        if(color == 9) {
            color = 1;
        }
        colorTime = getWombatWorld().getTime() + 200;
        setImage(String.format("wombat-rainbow-%dW.png", color));
    }
    
    public void setColorTime(long time) {
        this.colorTime = time;
    }
    
    
  

    
    
    
    public void poo() {
        switch(direction) {
            case SOUTH :
                setLocation(getX(), getY() - 1);
                break;
            case EAST :
                setLocation(getX() - 1, getY());
                break;
            case NORTH :
                setLocation(getX(), getY() + 1);
                break;
            case WEST :
                setLocation(getX() + 1, getY());
                break;
        }
    }
        
    /**
     * Check whether there is a leaf in the same cell as we are.
     */
    public boolean foundLeaf()
    {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        if(leaf != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    
    /** 
     * Check if wombat is on a Biomass
     * @return true/false
     */
    public boolean foundPoop() {
        Actor biomass = getOneObjectAtOffset(0, 0, Biomass.class);
        if(biomass != null && ((Biomass) biomass).isSpawned()) {
            return true;
        }
        else {
            return false;
        }
    }
    /** Check if wombat is on a Star
     * @return true/false
     */
    public boolean foundStar() {
        Actor star = getOneObjectAtOffset(0,0,Star.class);  
        if(star != null) {
            return true;
        } else {
            return false; 
        }
    }
    
    public Star getStar() {
        return ((Star) getOneObjectAtOffset(0,0,Star.class));
    }
    
    /** Check if wombat is on a Wombat
     * @return true/false
     */
      public boolean foundWombat() {
        Actor wombat = getOneObjectAtOffset(0, 0, Wombat.class);
        if(wombat != null) {
            return true;
        }
        else {
            return false;
        }
    
    }
    
    /**
     * Eat a leaf.
     */
    public void eatLeaf()
    {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        if(leaf != null) {
            // eat the leaf...
            getWorld().removeObject(leaf);
            
            leavesEaten = leavesEaten + 1; 
            getWombatWorld().addPoint(player-1);
            getWombatWorld().updateScore();
            getWombatWorld().addLeave();
        }
    }
    
    /**
     * Move one cell forward in the current direction.
     */
    public boolean move()
    {
        WombatWorld myWorld = (WombatWorld) getWorld();
        if (!canMove()) {
            return false;
        }
        switch(direction) {
            case SOUTH :
                setLocation(getX(), getY() + 1);
                break;
            case EAST :
                setLocation(getX() + 1, getY());
                break;
            case NORTH :
                setLocation(getX(), getY() - 1);
                break;
            case WEST :
                setLocation(getX() - 1, getY());
                break;
        }
        return true;
    }
    
    /** Go back of one cell 
     */
    public void snapBack() {
        switch(direction) {
            case SOUTH :
                setLocation(getX(), getY() - 1);
                break;
            case EAST :
                setLocation(getX() - 1, getY());
                break;
            case NORTH :
                setLocation(getX(), getY() + 1);
                break;
            case WEST :
                setLocation(getX() + 1, getY());
                break;
        }
    }
    

    /**
     * Test if we can move forward. Return true if we can, false otherwise.
     */
    public boolean canMove()
    {
        World myWorld = getWorld();
        int x = getX();
        int y = getY();
        switch(direction) {
            case SOUTH :
                y++;
                break;
            case EAST :
                x++;
                break;
            case NORTH :
                y--;
                break;
            case WEST :
                x--;
                break;
        }
        // test for outside border
        if (x >= myWorld.getWidth() || y >= myWorld.getHeight()) {
            return false;
        }
        else if (x < 0 || y < 1 ) {
            return false;
        }
        return true;
    }

    /**
     * Turns towards the left.
     */
    public void turnLeft()
    {
        switch(direction) {
            case SOUTH :
                setDirection(EAST);
                break;
            case EAST :
                setDirection(NORTH);
                break;
            case NORTH :
                setDirection(WEST);
                break;
            case WEST :
                setDirection(SOUTH);
                break;
        }
    }

    /**
     * Sets the direction we're facing.
     */
    public void setDirection(int direction)
    {
        this.direction = direction;
        switch(direction) {
            case SOUTH :
                setRotation(90);
                break;
            case EAST :
                setRotation(0);
                break;
            case NORTH :
                setRotation(270);
                break;
            case WEST :
                setRotation(180);
                break;
            default :
                break;
        }
    }

    /**
     * Tell how many leaves we have eaten.
     */
    public int getLeavesEaten()
    {
        return leavesEaten;
    }
}
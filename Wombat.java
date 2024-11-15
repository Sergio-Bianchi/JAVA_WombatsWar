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
    private int timeout;
    private int steps;
    
    public Wombat(int player)
    {
        setDirection(EAST);
        leavesEaten = 0;
        steps = 0;
        this.player = player;
    }
    
    public int[][] getGrid() {
        return getWombatWorld().getGrid();
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
    
    public int getTimeout() {
        return timeout;
    }
    
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
    
    public boolean foundWombat() {
        Actor wombat = getOneObjectAtOffset(0, 0, Wombat.class);
        if(wombat != null) {
            return true;
        }
        else {
            return false;
        }
    
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
     * Eat a leaf.
     */
    public void eatLeaf()
    {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        if(leaf != null) {
            // eat the leaf...
            getWorld().removeObject(leaf);
            
            leavesEaten = leavesEaten + 1; 
            timeout = getWombatWorld().getTime() + 2;
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
        myWorld.grid[getX()][getY()] = 2;
        return true;
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
        else if (x < 0 || y < 0) {
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
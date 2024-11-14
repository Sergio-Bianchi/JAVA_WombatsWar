import greenfoot.*;  // imports Actor, World, Greenfoot, GreenfootImage

import java.util.Random;

/**
 * A world where wombats fight.
 * 
 * @author Sergio Bianchi & Michael Kolling
 * @version 12.11.2024
 */
public class WombatWorld extends World
{
    public int[][] grid;
    private int turn;
    private int time;
    
    /**
     * Create a new world with 8x8 cells and
     * with a cell size of 60x60 pixels
     */
    public WombatWorld() 
    {
        super(8, 8, 60);        
        turn = 0;
        time = 0;
        grid = new int[8][8];
        setBackground("cell.jpg");
    }
    
    /** 
     * @return      world Grid
     */
    public int[][] getGrid() {
        return grid;
    }
    
    /** 
     * @return      world turn
     */
    public int getTurn() {
        return turn;
    }
    
     /** Adds a tick to the time
     */
    public void tick() {
        time++;
    }
    
    /** 
     * @return      Returns the current game time (the total moves)
     */
    public int getTime() {
        return time;
    }
    
    public void switchTurn() {
        tick();
        switch(turn) {
            case 1:
                turn = 2;
                break;
            case 2:
                turn = 1;
                break;
        }
    }
    
    
    /** Imposta il valore del turno 
     *  @param  turn    Has to be 1 or 2
     */
    public void setTurn(int t) {
        turn = t;
    }
    
    /** Setup the game to start 
     * 
     */
    public void setup() {
        grid = new int[8][8];
        turn = 1;
        time = 0;
        for(int i = 0; i < 2;) {
            int wX = Greenfoot.getRandomNumber(getWidth());
            int wY = Greenfoot.getRandomNumber(getHeight());
            if(grid[wX][wY] == 0) {
                if(i == 1) {
                    Wombat w1 = new PlayerTwo();
                    addObject(w1, wX, wY);
                    grid[wX][wY] = 2;
                    i++;
                }
                else {
                    Wombat w1 = new PlayerOne();
                    addObject(w1, wX, wY);
                    grid[wX][wY] = 1;
                    i++;
                }
                
            }
        }
        
        for(int i = 0; i < 3;) {
            int wX = (int) (Math.random() * 8);
            int wY = (int) (Math.random() * 8);
            if(getObjectsAt(wX, wY, null).isEmpty()) {
                 Leaf l1 = new Leaf();
                addObject(l1, wX, wY);
                grid[wX][wY] = 3;
                i++;
            }    
        }
    }
    
    /**
     * Place a number of leaves into the world at random places, if the slot is empty.
     * The number of leaves can be specified.
     */
    public void randomLeaves(int howMany)
    {
        for(int i=0; i<howMany;) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            if(getObjectsAt(x, y, null).isEmpty()) {
                Leaf leaf = new Leaf();
                addObject(leaf, x, y);
                i++;
            }  
        }
    }
    
    public void addLeave() {
        randomLeaves(1);
    }
}
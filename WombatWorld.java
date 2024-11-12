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
    /**
     * Create a new world with 8x8 cells and
     * with a cell size of 60x60 pixels
     */
    public WombatWorld() 
    {
        super(8, 8, 60);        
        setBackground("cell.jpg");
    }
    
    /** 
     * @return      world Grid
     */
    public int[][] getGrid() {
        return grid;
    }
    
    /** Setup the game to start 
     * 
     */
    public void setup() {
        grid = new int[8][8];
        for(int i = 0; i < 2;) {
            int wX = (int) (Math.random() * 8);
            int wY = (int) (Math.random() * 8);
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
            if(grid[wX][wY] == 0) {
                Leaf l1 = new Leaf();
                addObject(l1, wX, wY);
                grid[wX][wY] = 3;
                i++;
            }
        }
    }
    
    /**
     * Place a number of leaves into the world at random places.
     * The number of leaves can be specified.
     */
    public void randomLeaves(int howMany)
    {
        for(int i=0; i<howMany; i++) {
            Leaf leaf = new Leaf();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(leaf, x, y);
        }
    }
}
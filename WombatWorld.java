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
    private int turn;
    private long time;
    private int speed = 35;

    /**
     * Create a new world with 12x12 cells and
     * with a cell size of 60x60 pixels
     */
    public WombatWorld() 
    {
        super(11, 12, 60,false);  
        Greenfoot.setSpeed(speed);
        turn = 0;
        time = System.currentTimeMillis();
        setBackground("cell.jpg");
        prepare();
        randomPoop(1,1,1);
    }

    public void act() {
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
    public long getTime() {
        return System.currentTimeMillis() - time;
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
        turn = 1;
        for(int i = 0; i < 2;) {
            int wX = Greenfoot.getRandomNumber(getWidth());
            int wY = Greenfoot.getRandomNumber(getHeight()-1)+1;
             if(getObjectsAt(wX, wY, null).isEmpty()) {   
                if(i == 1) {
                   
                    Wombat w1 = new PlayerTwo();
                    addObject(w1, wX, wY);
                    i++;
                }
                else {
                    Wombat w1 = new PlayerOne();
                    addObject(w1, wX, wY);
                    i++;
                }
            }
        }

        for(int i = 0; i < 3;) {
            int wX = Greenfoot.getRandomNumber(getWidth());
            int wY = Greenfoot.getRandomNumber(getHeight() -1)+1;
            if(getObjectsAt(wX, wY, null).isEmpty()) {
                Leaf l1 = new Leaf();
                addObject(l1, wX, wY);
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
            int y = Greenfoot.getRandomNumber(getHeight() -1)+1;
            if(getObjectsAt(x, y, null).isEmpty()) {
                Leaf leaf = new Leaf();
                addObject(leaf, x, y);
                i++;
            }  
        }
    }

    /**
     * Place a number of biomasses into the world at random places, if the slot is empty.
     * The number of biomasses can be specified.
     */
    public void randomPoop(int howMany, int spawn, int timeout)
    {
        for(int i=0; i<howMany;) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight()-1)+1;
            if(getObjectsAt(x, y, null).isEmpty()) {
                Biomass biomass = new Biomass(
                getTime() + spawn,
                getTime() + timeout);
                addObject(biomass, x, y);
                biomass.setImage((GreenfootImage)null);
                i++;
            }  
        }
    }
    
    /**
     * Place a number of biomasses with 10 seconds of timeout  
     */
    public void randomPoop(int howMany) {
        randomPoop(howMany, 2000, 10000);
    }

    public void addPoop() {
        randomPoop(1);
    }    

    public void addLeave() {
        randomLeaves(1);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        setup();
        Score score = new Score();
        addObject(score,5,0);
    }
}
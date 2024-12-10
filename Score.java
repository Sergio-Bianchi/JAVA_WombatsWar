import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    
    int playerOne = 0;
    int playerTwo = 0;
    
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public Score() {
    
    }
    
    public void update() {
        int[] scores = ((WombatWorld) getWorld()).getScore();
        StringBuilder string = new StringBuilder()
        .append(scores[0])
        .append(" - ")
        .append(scores[1]);
        
        setImage(new GreenfootImage(string.toString(), 50, Color.BLACK, new Color(0,0,0,0)));
    }
    
    public void setWinner(int winner) {
         if(winner == 1) {
            String string = new String("Player one WINS!");
            setImage(new GreenfootImage(string, 50, Color.BLACK, new Color(0,0,0,0)));

        } else {
           String string = new String("Player two WINS!");
                setImage(new GreenfootImage(string, 50, Color.BLACK, new Color(0,0,0,0)));

        }
        Greenfoot.delay(20);
        WombatWorld newWorld = new WombatWorld();
        Greenfoot.setWorld(newWorld);

        //((WombatWorld)getWorld()).restart();
    }    
}

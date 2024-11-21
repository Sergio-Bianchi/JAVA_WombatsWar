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
    
    public void updateScore() {
        StringBuilder string = new StringBuilder()
        .append(5)
        .append(" - ")
        .append(10);
        
        setImage(new GreenfootImage(string.toString(), 50, Color.BLACK, new Color(0,0,0,0)));
    }
    
}

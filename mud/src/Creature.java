import java.util.List;
import java.util.Random;
/**
 * Creature is abstract class which handles all the creatures the player can interact with
 */
public abstract class Creature extends Interaction 
{
   
    public String name;

    public Creature(String name)
    {
        this.name = name;
    }

    public abstract void talk();
    
    public Course getCurrentCourse()
    {
        return null;
    }

    /**
     * @return the name of the Creature
     */
    public String toString()
    {
        return name;
    }

   public Item getItem()
    {
        return null;
    }

    /**
     * @return null
     */
    public Course getCourse()
    {
        return null;
    }

    public abstract String getCreatureType();

    /**
     * @return null
     */
    public Book getCourseBook()
     {
        return null;
     }

    /**
     * @return the name of the Creature
     */
    public String getCreatureName()
    {
        return name;
    }

    /** 
     * @return an empty String
     */
    public String getQuestion()
    {
     return " ";
    }

}

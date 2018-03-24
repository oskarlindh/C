import java.util.List;
import java.util.ArrayList;
/** 
 * Key is a subclass to Item and handles the keys the player can find
 */

public class Key extends Item
{
    List<String> validInteractions;
    /**
    *Default constructor for a Key
    */
   public Key()
    {
        super("Key",1);
        validInteractions = new ArrayList<String>();
        validInteractions.add("pick upp");
    }

    
    public void interact(String interaction)
    {
        if(interaction == "pick upp")
            System.out.println( "You picked up a key");
        System.out.println("Not a valid action");
    }
    /**
     * @return a list of valid ineractions
     */ 
    public List<String> getValidInteractions()
    {
        return validInteractions;
    }

    public boolean validInteraction(String action)
    {    
        for (int i = 0;i < validInteractions.size();i++ ) {
            if(action == validInteractions.get(i))
            return true;
        }  
        return false;
    }

    /**
     *@return "a key" string
     */
    public String toString()
    {
        return "a " + super.getName();
    }
    

} 

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
/**
 *The sfinx is controlls the end of the game and holds all relevant data 
 * for finnihing the game
 */ 
public class Sfinx extends Creature 
{
    String wordsOfWisdom[];
    List<String> validInteractions;

   /**
     * Default constructor for sfinx
     * @param wordsOfWisdom a list with sayings the for interaction with the sfinx
     *
     */
    public Sfinx(String[] wordsOfWisdom)
    {   super("Sphinx");
        this.wordsOfWisdom = wordsOfWisdom;
        validInteractions = new ArrayList<String>(); 
        validInteractions.add("talk");
        validInteractions.add("take");
    }

   
    /**
     * @return a list of the vaild interactions that can be preformed
     */ 
    public List<String> getValidInteractions()
    {
        return validInteractions;
    }

    /**
     *  Checks if an interaction is valid
     *  @param interaction the action to test for validity
     *  @return true if the interaction is a valid one
     */ 
    public boolean validInteraction(String interaction)
    {
        for (int i = 0;i < validInteractions.size();i++ ) {
            if(interaction.equals(validInteractions.get(i)))
                return true;
        }  
        return false;


    }

    /**
     * a String containing a random wisdom
     */
    public void talk()
    { 
        Random rand = new Random();
        int length = wordsOfWisdom.length-1;
        String wisdom = wordsOfWisdom[rand.nextInt(length)];
        System.out.println("The Sphinx says\n"+wisdom);  
    }

    /**
     * @return a String containing "Sphinx"
     */
    public String getCreatureType()
    {
        return "Sphinx";
    }

    /**
     * @return a empty string to counter a double print 
     */
    public String toString()
    {
        return "";
    }
}

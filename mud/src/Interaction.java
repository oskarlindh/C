import java.util.List;

public abstract class Interaction 
{
  
    /** 
     * Gets the actions that are valid to preforme on given object
     * @return a list of strings where the strings is the valid actions that can be used
     * to interact with the objcet.
     *
     */

    public List<String> getValidInteractions()
    {
        return null;
    }
    /**
     * Tests if a string is a valid action
     * @param interaction a string wished to test for as an interactive action for the given object.
     * tests if a given string is a valid action for a given object.
     * @return true if the given string is a valid action for the object.
     */
    public boolean validInteraction(String interaction)
    {
        return false;
    }
    
}

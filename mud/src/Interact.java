import java.util.List;
/* 
 * Interface for interaction through strings with 
 * diffrent objects. An interaction returns a string as an answer from the object
 * to the given interaction
 */ 
interface Interact 
{   
    /**
     * Intertacts with a give object
     * @param interaction the interaction wished to preform on the object. 
     * @return a string representing the the result of the interaction. 
     */
    String interact(String interaction);
    /** 
     * Gets the actions that are valid to preforme on given object
     * @return a list of strings where the strings is the valid actions that can be used
     * to interact with the objcet.
     *
     */
    List<String> getValidInteractions(); 
    /**
     * Tests if a string is a valid action
     * @param a string wished to test for as an interactive action for the given object.
     * tests if a given string is a valid action for a given object.
     * @return true if the given string is a valid action for the object.
     */
    boolean validInteraction(String interaction);
    
} 

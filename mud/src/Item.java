/**
 *Item is a abstact class that handels all the items the player can find and store in the backpack
 */
public abstract class Item extends Interaction 
{
    public String name;
    private double volume;

    /**
     * Default contuctor for a Item
     * @param name the name of the item
     * @param volume the volume an item will take in the backpack
     */
    
    public Item(String name, int volume) 
    {
        this.name = name;
        this.volume = volume;
    }
    
    /**
     * @return the name of the item
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return the volume of the item
     *  
     */
    public double getVolume()
    {
        return volume;
    }

    public abstract String toString();
    
    /**
     * @return an empty string
     */    
    public String getCourse()
    {
        return "";
    }

}

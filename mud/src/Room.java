import java.lang.Boolean;

public class Room //implements interact
{

    private Item     item;
    private Creature creature;
    private String   roomName;
    private String   north;
    private String   east;
    private String   south;
    private String   west;
    private boolean  northLocked;
    private boolean  eastLocked;
    private boolean  southLocked;
    private boolean  westLocked;

    /**
     * Default constructor for the Room object
     * @param roomArr a String array containing the data for the room
     * @param index an int to where to start in the array
     */
    public Room(String[] roomArr, int index)
    {
        roomName = roomArr[index];
        north = roomArr[index+1];
        east = roomArr[index+2];
        south = roomArr[index+3];
        west = roomArr[index+4];
        northLocked = Boolean.valueOf(roomArr[index+5]);
        eastLocked = Boolean.valueOf(roomArr[index+6]);
        southLocked = Boolean.valueOf(roomArr[index+7]);
        westLocked = Boolean.valueOf(roomArr[index+8]);
    }

    /**
     * @return an String containing all the directions, and the item and creature is they exists
     */
    public String toString()
    {
        String roomPrint = "You are standing in " + this.roomName;
        if (!north.equals("X")){
            roomPrint += "\nTo the north is " + this.north;
            if(northLocked == true)
                roomPrint += ", but the door is locked";
        }
        if (!east.equals("X")){
            roomPrint += "\nTo the east is " + this.east;
            if(eastLocked == true)
               roomPrint += ", but the door is locked";
        }
        if (!south.equals("X")){
            roomPrint += "\nTo the south is " + this.south;
            if(southLocked == true)
                roomPrint += "but the door is locked";
        }
        if (!west.equals("X")){
            roomPrint += "\nTo the west is " + this.west;
            if(westLocked == true)
                roomPrint += ", but the door is locked";
          }
        if(item != null){
            roomPrint += "\n\nLaying on the ground is " + item;
            if(item instanceof Book)
                roomPrint += "\nfor the course " + item.getCourse();
        }
        if(creature != null)
            roomPrint += "\n\nStanding in the room is the " + creature.getCreatureType() + " " + creature;
        return roomPrint + "\n";
    }

    /**
     * Checks if an door is locked 
     * @param direction the direction whished to check for if locked
     * @return true if the door in the dirrection is locked
     *
     */
    public boolean isLocked(String direction)
    {
        if(direction.equals("north"))
            return this.northLocked;
        if(direction.equals("east"))
            return this.eastLocked;
        if(direction.equals("south"))
            return this.southLocked;
        if(direction.equals("west"))
            return this.westLocked;
        return false;
    }

    /**
     * Opens a locked direction
     * @param direction which direction to be unlocked
     */ 
    public void openLocked(String direction)
    {
        if(direction == "north")
            this.northLocked = false;
        if(direction == "east")
            this.eastLocked = false;
        if(direction == "south")
            this.southLocked = false;
        if(direction == "west")
            this.westLocked = false;
    }

    /**
     * @return the creature object from the room
     */
    public Creature getCreature()
    {
        return creature;
    }

    /**
     * @return the name of the creature object in the room, if no creature exists returns null 
     */
    public String getCreatureName()
    {
        if(!(creature == null))
            return creature.toString();
        return null;
    }

    /**
     * @return the item object from the room object
     */
    public Item getItem()
    {
        return item;
    }

    /** 
     * Sets item to a certain Item object
     * @param item the item to be set
     */
    public void setItem(Item item)
     {
        this.item = item;
     }

    /** 
     * Sets creature to a certain Creature object
     * @param creature the creature to be set
     */
    public void setCreature(Creature creature)
    {
        this.creature = creature;
    }

    /**
     * @return true if there is an item in the room 
     */
    public boolean hasItem()
    {
        return(item != null);
    }

    /**
     * @return true if there is a creature in the room else return false
     */
    public boolean hasCreature()
    {
        return(creature != null);
    }

    /**
     * @return the name of the room
     */
    public String getRoomName()
    {
        return roomName;
    }

    /**
     * @return the name of the room in a certain direction
     * @param direction the direction to go
     */
    public String getInDirection(String direction)
    {
        if(direction.equals("north") && !north.equals("X"))
            return north;
         
        if(direction.equals("east") && !east.equals("X"))
            return east;
             
        if(direction.equals("south") && !south.equals("X"))
            return south;
        
        if(direction.equals("west") && !west.equals("X"))
            return west;

        else return null;
    }
}            

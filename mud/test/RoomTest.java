import org.junit.Test;
import static org.junit.Assert.*;

public  class RoomTest 
{   
    String[] roomArr = {"name","north","east","south","X","True","X","X","X"};
    Room room = new Room(roomArr,0);
    Teacher teacher = new Teacher("name");
    Key key = new Key();

    @Test
    public void testDirections()
    {
        assertTrue(room.isLocked("north"));
        room.openLocked("north");
        assertFalse(room.isLocked("north"));
        assertFalse(room.isLocked("south")); 
        assertEquals("south",room.getInDirection("south"));
        assertEquals(null,room.getInDirection("west"));
    }
    
    @Test
    public void testCreature()
    {
        room.setCreature(teacher);
        assertEquals("name",room.getCreatureName());
        assertEquals(teacher,room.getCreature()); 
        assertTrue(room.hasCreature());
    }
    
     @Test
     public void testItem()
     {
        room.setItem(key);
        assertTrue(room.hasItem());
        assertEquals(key,room.getItem());

     
     }
}

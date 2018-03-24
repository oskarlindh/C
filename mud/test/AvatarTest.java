import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class AvatarTest
{
    String[] bookArr = {"name","author","1990","3","course"};
    String[] courseArr = {"Hej","book","180"};
    Book book = new Book(bookArr,0);
    Course course = new Course(courseArr,0,book);
    Avatar avatar = new Avatar();
 
    @Test    
    public void backpackTest()
    {
        Key key = new Key();
        assertEquals(10,avatar.getBackpackVolume(),0.05);
        avatar.addItemBackpack(book);
        assertEquals(7,avatar.getBackpackVolume(),0.05);
        assertTrue(avatar.checkForItem(book));
        assertTrue(avatar.removeItemBackpack(book));
        assertEquals(10,avatar.getBackpackVolume(),0.05);
        
        avatar.addItemBackpack(key);
        assertTrue(avatar.removeItemBackpack(key));
        assertEquals(null,avatar.haveKey());
       
    }
    
    @Test
    public void courseTest() 
    {
        avatar.removeFinnishedCourse(course);
        assertEquals(0,avatar.getHp());
        avatar.addFinnishedCourse(course);
        assertEquals(180,avatar.getHp());
        assertTrue(avatar.checkFinnishedCourses(course));
        assertTrue(avatar.checkIfDone());
        avatar.addUnfinnishedCourse(course);
        assertFalse(avatar.checkIfDone());
        avatar.removeFinnishedCourse(course);
        assertEquals(0,avatar.getHp());
        

        assertFalse(avatar.checkIfDone());
        avatar.addUnfinnishedCourse(course);
        assertEquals(0,avatar.getHp());
        assertTrue(avatar.checkUnfinnishedCourses(course));
        assertFalse(avatar.checkIfDone());


    }
}



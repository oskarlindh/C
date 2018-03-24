import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;

public class GameTest  
{  

   
    @Test
    public void testCreate() throws IOException 
    {   
        
        Game game = new Game();
        Room room = game.getRoom("Hallway 1.0"); 
        assertEquals("Hallway 1.0",room.getRoomName());
        assertTrue(game.getAvatar() instanceof Avatar);

    }
    
    @Test
    public void testEnroll() throws IOException 
    {   
        
        Game game = new Game();
        String[] bookArr     = {"name","author","1990","3","course"};
        String[] courseArr   = {"Hej","book","180"};

        Book book = new Book(bookArr,0);
        Course course = new Course(courseArr,0,book);
        Teacher teacher = new Teacher("Name");
        Avatar av = game.getAvatar();
        
        assertEquals(0,game.checkEnroll(teacher));
        teacher.setCourse(course);
        assertEquals(0,game.checkEnroll(teacher));
        av.addUnfinnishedCourse(course);
        assertEquals(75,game.checkEnroll(teacher));
        
        av.removeUnfinnishedCourse(course);
        av.addFinnishedCourse(course);
        assertEquals(50,game.checkEnroll(teacher));
    }


}

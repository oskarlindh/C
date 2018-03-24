import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest 
{
    String[] bookArr = {"name","author","1990","10","course"};
    String[] courseArr = {"Hej","book","10"};
    Book book = new Book(bookArr,0);
    Course course = new Course(courseArr,0,book);
    Student student = new Student("Name");


    @Test
    public void courseTest()
    {           
        student.setFinnishedCourse(course);
        assertEquals(course,student.getFinnishedCourse());

        student.setCurrentCourse(course);
        assertEquals(course,student.getCurrentCourse());

    }
    
    @Test
    public void interactionTest()
    {    
        assertTrue(student.validInteraction("talk"));

        assertEquals("Student",student.getCreatureType());
    }
}

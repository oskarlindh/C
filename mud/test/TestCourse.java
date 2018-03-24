import org.junit.Test;
import static org.junit.Assert.*;

public class TestCourse
{   
    
    String[] bookArr = {"name","author","1990","10","course"};
    String[] courseArr = {"Hej","book","10"};
    Book book = new Book(bookArr,0);
    Course c = new Course(courseArr,0,book);
   
    String[] qArray = {"Why","a","b","c","1"}; 
    
    @Test
    public void testCourse() 
    {
        
        c.setQuestion(qArray,0); 
        assertEquals("a",c.getQuestionAnswer());
        assertTrue(c.checkAnswer(1));
        assertFalse(c.checkAnswer(2));
    
    }



}


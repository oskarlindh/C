import org.junit.Test;
import static org.junit.Assert.*;



public class TeacherTest 
{
    String[] bookArr     = {"name","author","1990","3","course"};
    String[] courseArr   = {"Hej","book","180"};
    String[] questionArr = {"question","alternative1","alternative2","alternative3","1"};

    Book book = new Book(bookArr,0);
    Course course = new Course(courseArr,0,book);
    Teacher teacher = new Teacher("Name");

    @Test
    public void interactionTest()
    {
            
        course.setQuestion(questionArr,0);
        assertTrue(teacher.validInteraction("talk"));
        assertFalse(teacher.validInteraction("enroll"));
        teacher.setCourse(course);
        assertTrue(teacher.validInteraction("enroll")); 
        assertEquals("Teacher",teacher.getCreatureType());
    }
    
    @Test
    public void courseTest()
    {
       teacher.setCourse(course);
       course.setQuestion(questionArr,0);
       assertEquals(course,teacher.getCourse());
       assertEquals(book,teacher.getCourseBook());
       assertTrue(teacher.checkAnswer(1));
       assertFalse(teacher.checkAnswer(2));
       assertFalse(teacher.checkAnswer(100));
    }

}





import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.StringBuilder;

/**
 * Teacher is subclass to Creature and handles the avatar courses interaction
 */
public class Teacher extends Creature 
{   
   private Course course; 
   private List<String> validInteractions;

    /**
     *Default constructor for the Teacher object
     * @param name the name of the Teacher
     */
   public Teacher(String name)
    {
        super(name);
        
        validInteractions = new ArrayList<String>();
        validInteractions.add("talk");
    }

   
    /**
     * Prints the Teachers name and it's course
     */
    public void talk()
    {
        String talk = "Hi my name is " +super.name+"\n";
        talk +=  "The subject i am teaching is " + course;
        System.out.println(talk);
    }

    /**
     * Prints the Teachers question 
     */
    public void askQuestion()
    { 
       StringBuilder question = new StringBuilder(); 
       question.append("Teacher "+super.name+" asks you a question\n\n"); 
       question.append(course.questionToString());
       System.out.println(question.toString());
    }
    
    /**
     *  Checks if an interaction is valid
     *  @param action the action to test for validity
     *  @return true if the interaction is a valid one
     */ 
    
    public boolean validInteraction(String action)
    {    
        for (int i = 0;i < validInteractions.size();i++ ) {
            if(action.equals(validInteractions.get(i)))
            return true;
        }  
        return false;
    }
   
    public List<String> getValidInteractions()
    {
        return validInteractions;
    }    

    /**
     * Prints the Teachers questions with one less alternativ
     */
    public void askQuestionAlternativeRemoved()
    {   if(course == null)
            System.out.println("I have no question to ask you");
        System.out.println(course.questionRemoveAnswer());
    }

    /**
     * Checks if the answer to the question is correct
     * @param answer the alternative for the teachers quesion wished to test
     * for corectness
     * @return true if the answer i correct
     */
    public boolean checkAnswer(int answer)
    { 
        return course.checkAnswer(answer);   
    }

    /**
     * Set the object course
     * @param course the course to set for the teacher.
     */
    public void setCourse(Course course)
    {    if(this.course == null){
         this.course = course;
         validInteractions.add("enroll");
         }
    }

    /**
     * Returns the Book for the objects course
     * @return the book corresponding to the teachers course
     */
    public Book getCourseBook()
    {
        return course.getBook();
    }

    /**
     * @return a string containing "Teacher"
     */
    public String getCreatureType()
    {
        return "Teacher";
    }

    /**
     * @return the objects course object
     */
    public Course getCourse()
    {
        return course;
    }
}

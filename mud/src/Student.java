import java.util.List;
import java.util.ArrayList;

/**
 *Student is a subclass to Creature
 */
public class Student extends Creature 
{
    private Course currentCourse;
    private Course finnishedCourse;
    private List<String> validInteractions;

    /**
     * Default constructor for the Student Class
     * @param name of the student
     */
    public Student(String name)
    {
        super(name);
        validInteractions = new ArrayList<String>();
        validInteractions.add("talk");
        validInteractions.add("trade");
    }

       public List<String> getValidInteractions()
    {  
       return validInteractions;
    }

    /**
     * prints which course the student have finninsh and which course it's taking
     */
    public void talk()
    {
        String talk = "Hi my name is "+ super.name + " i am studying\n";
        talk += currentCourse+"\n";
        talk += "I just finnished\n";
        talk += finnishedCourse;
        System.out.println(talk);
    }
    
     /**
     *  Checks if an interaction is valid
     *  @param interaction the action to test for validity
     *  @return true if the interaction is a valid one
     */ 
    
    public boolean validInteraction(String interaction)
    {
        for (int i = 0;i < validInteractions.size();i++ ) {
            if(interaction.equals(validInteractions.get(i)))
                return true;
        }  
        return false;

    }
    

    /**
     * Set the Finnished Course
     * @param course The Course
     */
    public void setFinnishedCourse(Course course)
    {
        finnishedCourse = course;
    }

    /**
     * @return the Current Course
     */
    public Course getCurrentCourse()
    {
        return currentCourse;
    }

    /**
     * @return the finnsied course
     */
    public Course getFinnishedCourse()
    {
        return finnishedCourse;
    }

    /**
     * Sets the Current Course
     * @param course The Course
     */
    
    public void setCurrentCourse(Course course)
    {
        currentCourse = course;
    }    
    /**
     * @return the a String containing "Student" 
     */
    public String getCreatureType()
    {
        return "Student";
    }   
}

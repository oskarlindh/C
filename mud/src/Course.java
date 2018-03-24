import java.lang.Integer;

/**
 * Course is a class containing the questions the player need to answer. And the hp is need collect to finnish the game
 */
public class Course
{
    private Book courseBook;
    private String name;
    private int hp;
    private Question question;

    /**
     * Default constructor for the Course object
     * @param courseArr array conatining the info to build a course 
     * @param index to start fom in courseArr
     * @param courseBook the book for the course 
     */
    public Course(String[] courseArr, int index,Book courseBook)
    {
        name = courseArr[index];
        this.courseBook = courseBook;
        hp   = Integer.parseInt(courseArr[index+2]); 
    }

    public static class Question
    {
        private String question;
        private String alternative1;
        private String alternative2;
        private String alternative3;
        private int answer;

        public Question(String[] question, int  i)
        {
            this.question = question[i];
            this.alternative1 = question[i+1];
            this.alternative2 = question[i+2];
            this.alternative3 = question[i+3];
            this.answer = Integer.parseInt(question[i+4]);
        }

        
    }

    /**
     * @return a string with all the question and all alternatives
     */
    public String questionToString()
        {
            String questionPrint = question.question + "\n";
            questionPrint += "1. " + question.alternative1 + "\n";
            questionPrint += "2. " + question.alternative2 + "\n";
            questionPrint += "3. " + question.alternative3 + "\n";
            return(questionPrint);
        }

    /**
     * @return a string with the question, one wrong and the right alternativ
     */

    public String questionRemoveAnswer()
    {   
        String questionPrint = question.question + "\n";
        if (question.answer == 1){
            questionPrint += "1. " + question.alternative1 + "\n";
            questionPrint += "2. " + question.alternative2 + "\n";
        }
        if (question.answer == 2){
            questionPrint += "1. " + question.alternative2 + "\n";
            questionPrint += "2. " + question.alternative3 + "\n";
        }
         if(question.answer == 3){ 
            questionPrint += "1. " + question.alternative1 + "\n";
            questionPrint += "2. " + question.alternative3 + "\n";
        }
        return questionPrint;   
    }

    /**
     * Set the Course Question
     * @param question an array containing the question and the alternatives
     * @param index an int to where in the array to start 
     */
    public void setQuestion(String[] question ,int index)
    {
        this.question = new Question(question,index);
    }

   
    /**
     * @return the correct answer
     */
    public String getQuestionAnswer()
    {
        if(question.answer == 1)
            return question.alternative1;
        
        if(question.answer == 2)
            return question.alternative2; 
       
        else 
            return question.alternative3; 
    }

    /**
     * Checks if the answer is correct
     * @param answer an to compare with the correct answer
     * @return true if the answer is correct
     */
    public boolean checkAnswer(int answer)
    {
        return (question.answer == answer);
    }

    /**
     * @return the Course corresponding Book object
     */
    public Book getBook()
    {
        return this.courseBook;
    }

    /**
     * @return the name of the Course 
     */
    public String toString()
    {
        return name;
    }

    /**
     * @return the number of hp the Course is worth
     */
    public int getHp()
    {
        return hp;
    }
    
   
}


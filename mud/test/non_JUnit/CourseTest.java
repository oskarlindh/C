public class CourseTest
{
        public static void main(String[] args) 
        {
            Book book = new Book("Book",1,"Author",1890);
            Course c = new Course(book,"Name",90);
            c.setQuestion("Why","a\nb\nc\n",1);    
        
            System.out.print(c.checkAnswer(1)+"\n");
            c.askQuestion();
        }


}

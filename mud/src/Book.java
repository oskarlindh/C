import java.util.List;
import java.util.ArrayList;
/**
 * Book is a subclass to Item and handels the books the player can find
 */

public class Book extends Item
{   String author;
    int year;
    String course;
    
    List<String> validInteractions;
    /**
     * Default constructor for a Book
     * @param bookArr an arrat containing the information for a book 
     * @param index where to start in the bookArray
     * to be created
     */
    public Book(String[] bookArr, int index)
    {
        super(bookArr[index],Integer.parseInt(bookArr[index+3]));
        author = bookArr[index+1];
        year = Integer.parseInt(bookArr[index+2]);
        course = bookArr[index+4];
        validInteractions = new ArrayList<String>();
        validInteractions.add("pickup");
   }
    
    
    /**
     *@return the author of the book
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * @return the year the book was written
     */
    public int  getYear()
    {
        return year;
    }

    /**
     * @return  the name of the book
     */
    public String getName()
    {
        return super.getName();
    }

    /**
     * @return the name of the book with "the book" infront 
     * and the volume of the book
     */
    public String toString()
    {
        String string =  "the book\n"+ super.getName();
        string += "\nwith volume " + super.getVolume();
        return string;
    }

    /**
     * @return book to know which type the object is
     */
    public String getType()
    {
        return "Book";
    }

    /**
     * @return the course the book is for
     */
    public String getCourse()
    {
        return course;
    }
    
    /**
     *  Checks if an interaction is valid
     *  @param  action to test for validity
     *  @return true if the interaction is a valid one
     */ 
    public boolean validInteraction(String action)
    {    
        for (int i = 0;i < validInteractions.size();i++ ) {
            if(action == validInteractions.get(i))
            return true;
        }  
        return false;
    }
   
    public List<String> getValidInteractions()
    {
        return validInteractions;
    }  

}


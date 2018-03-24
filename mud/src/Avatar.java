import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class Avatar
{
    private List<Course> finnishedCourses;
    private List<Course> unfinnishedCourses;
    private Backpack backpack;
    private int hp;

    /**
     * Default constructor for the Avatar object
     */
    public Avatar()
    {
        finnishedCourses = new LinkedList<Course>();
        unfinnishedCourses = new LinkedList<Course>();
        backpack = new Backpack();
    }
    
    public void setHp(int i)
    {
        hp = i;
    }
    
    /**
     * A constructor that can be use to load prior played avatar
     * @param finnished a LinkedList containing the completed courses
     * @param unfinnished a LinkedList containing the unfinnish courses
     * @param hp an int with the number of hp the finnish courses add up to
     */
    public Avatar(LinkedList<Course> finnished,LinkedList<Course> unfinnished, int hp)
    {
        finnishedCourses = finnished;
        unfinnishedCourses = unfinnished;
        this.hp = hp;
    }

    
    private class Backpack
    {
        double volume;
        List<Item> items;

        private Backpack()
        {
            volume = 10;
            items = new LinkedList<Item>();
        }

        private void printBp()
        {   System.out.println("You got "+ volume + " of space left");
            System.out.println("Your backpack contains");
            for (int i = 0;i< items.size();i++) {
                System.out.println((i+1) + ". " + items.get(i));
            }
            System.out.println(" ");
        }

        private boolean checkForItem(Item item)
        {
            for(int i = 0;i< items.size();i++) {
                if(items.get(i) == item)
                    return true;
            }
            return false;
        }
    } 

    /**
     * Return the item for the backpack at a certain place
     * @param index an int to which item to return
     * @return returns item at given index in backpack
     */
    public Item getItem(int index)
    {
        return backpack.items.get(index);
    }

    /**
     * Prints the items in the backpack
     */
    public void printBackpack()
    {
        backpack.printBp();
    }

    /**
     * @return the remaining volume of the avatars backpack
     */
    public double getBackpackVolume()
    {
        return backpack.volume;
    }

    /**
     * Tries to an item to the avatars backpack
     * @param item the item to be added
     * @return true if it can add an item to the backpack 

     */
    public boolean addItemBackpack(Item item)
    {
        if(item.getVolume() <= backpack.volume)
        {
            backpack.items.add(item);
            backpack.volume -= item.getVolume();
            return true;   
        }
        else return false;
    }

    /**
     * Returns a key if there is one in the backpack 
     * @return A key if there is one in the backpack
     * else null
     */
    public Item haveKey()
    {
        for (int i = 0; i < backpack.items.size(); i++) {
            if(backpack.items.get(i) instanceof Key)
                return backpack.items.get(i);
        }
        return null;
    }

    /**
     * Tries to remove an item from the backpack if successful 
     * @param  item to be removed
     * @return true else false
     */
    public boolean removeItemBackpack(Item item)
    {
        backpack.volume += item.getVolume();
        return(backpack.items.remove(item));
    }


    /**
     * Add a Course to list of finnished courses
     * @param course the course to be added
     */
    public void addFinnishedCourse(Course course)
    {
        this.hp += course.getHp();
        finnishedCourses.add(course);
    }

    /**
     * tries to remove a course from the list of unfinnish courses,
     * @param course the course to be removed
     * @return true if successful else return false
     */
    public boolean removeUnfinnishedCourse(Course course)
    {
        return unfinnishedCourses.remove(course);
    }

    /**
     * tries to remove an course from the list of finnish courses 
     * @param course the coursse to be removed
     * @return true if successful else return false
     */
    public boolean removeFinnishedCourse(Course course)
    {

        if(hp != 0)
        this.hp -= course.getHp();
        
        return finnishedCourses.remove(course);

    }

    /**
     * Add an Course to list of unfinnished courses
     * @param course the course to be added
     */
    public void addUnfinnishedCourse(Course course)
    {
        unfinnishedCourses.add(course);
    }

    /**
     * returns the number hp the avatar has
     * @return the current hp of the avatar
     */
    public int getHp()
    {
        return hp;
    }  

    /**
     * Prints the list of finnish courses
     */
    public void printFinnishedCourses()
    {
        System.out.println("Finnished courses");
        for (int i = 0;i <finnishedCourses.size();i++) {
            System.out.println(finnishedCourses.get(i));
        }

    }

    /**
     * checks if a specific item exists in the list of Items 
     * @param item  to checked for
     * @return true if does else return false
     */
    public boolean checkForItem(Item item)
    {
        return backpack.checkForItem(item); 

    }

    /**
     * Prints the list of unfinnished courses
     */
    public void printUnfinnishedCourses()
    {
        System.out.println("\nUnfinnished courses");
        for (int i = 0;i < unfinnishedCourses.size();i++) {
            System.out.println(unfinnishedCourses.get(i));
        }
    }

    /**
     * checks if the a certain course exists in the list of finnish course
     * @param course the course to be checked for
     * @return  returns true if the avatar has finnnished the course 
     */
    public boolean checkFinnishedCourses(Course course)
    {
        Iterator<Course> courseIt = finnishedCourses.iterator();
        return checkCourses(course,courseIt);
    }

    /**
     * checks if the a certain course exists in the list of unfinnish courses
     * @param course the course to be checked for
     * @return  returns true if the avatar is taking the course 
     */
    public boolean checkUnfinnishedCourses(Course course)
    {
        Iterator<Course> courseIt = unfinnishedCourses.iterator();
        return checkCourses(course,courseIt);
    }

    private boolean checkCourses(Course course,Iterator<Course> courseIt)
    {   
        Course current = null;
        while(courseIt.hasNext()){
            current = courseIt.next();
            if(current == course)
                return true;
        }
        return false;
    }

    /**
     * Prints the avatar finnished and unfinnished courses, hp and backpack
     */
    public void printAvatar()
    {
        System.out.println("Your current hp is: "+hp);
        printUnfinnishedCourses();
        printFinnishedCourses();
        backpack.printBp();
    }

    /**
     * Returns true if hp got atleast a value of 180 and the unfinnished courses list is empty else return false
     * @return true if the avatar has no unfinnished courses and 
     * has taken more than 180 hp.
     */
    public boolean checkIfDone()
    {
        if(hp >= 180 && unfinnishedCourses.size() == 0)
            return true;
        else
            return false;
    }
} 








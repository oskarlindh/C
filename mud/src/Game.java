import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.lang.StringBuilder;
import java.io.File;
import java.util.LinkedList;
import java.util.Random;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;


/**
 * Game is a class that handles all small objects and interaction 
 * between them.
 */
public  class Game
{
    private Avatar avatar;
    private List<Creature> creatures;
    private List<Room> rooms;
    private List<Course> courses; //TODO Fler kurser
    private List<Book> books;
    private List<Item>  items;
    private Sfinx sfinx; //TODO Words of wisdom

    private String wisdomFile;
    private String nameFile;
    private String roomFile;
    private String courseFile;
    private String bookFile;
    private String questionFile;
    private int numberOfTeachers;
    private int numberOfStudents;
    private int numberOfKeys; 

    /**
     * Default contsructor for the Game class
     * @throws IOException if files given do not exist
     */
    public Game() throws IOException 
    {  
        wisdomFile = "wisdoms.txt";
        nameFile   = "firstName.txt";
        roomFile   = "rooms.txt";
        courseFile = "courses.txt";
        bookFile   = "books.txt";
        questionFile = "questions.txt";
        numberOfKeys     = 50;
        

        avatar = new Avatar();
        courses = new LinkedList<Course>();
        creatures = new LinkedList<Creature>();
        rooms = new LinkedList<Room>();
        items = new LinkedList<Item>();
        books = new LinkedList<Book>();
        
        
        createBooks();
        
        createCourses();
        numberOfTeachers = courses.size();
        numberOfStudents = courses.size()*2;
        
       
        createTeachers();
        createStudents();
        createSfinx();
        
        createKeys();
        createRooms();
        creaturesToRooms();
        itemsToRooms();
   
        placeTrade(); 
        avatar.setHp(60);
           
    }

    /**
     * @return the room the player start in
     */
    public Room begin()
    {
        return getRoom("Hallway 1.0");
    }

                                             
//////////////////TESTFUNKTIONER///////////////////////////////////    

    private void addItemsBp()
    {
       Random rand = new Random();
       int i = rand.nextInt(items.size());
       boolean notFull = true;
       Item it;
       while(notFull){    
           i = rand.nextInt(items.size());
           it = (items.get(i));
           notFull = avatar.addItemBackpack(it);
           if(avatar.checkForItem(it))
              notFull = true;
       }
    
    }

    private void placeCreature()
    {   Creature cr;
        Room rm;
        for (int i = 0;i<creatures.size() ;i++ ) {
            cr = creatures.get(i);
            if(cr instanceof Teacher){
                rm = getRoom("Hallway 1.0");
                rm.setCreature(cr);
                break;
            }
    
        }
    }
    
    private void placeTrade()
    {   Creature cr;
        Room rm;
        for (int i = 0;i<creatures.size() ;i++ ) {
            cr = creatures.get(i);
            if(cr instanceof Student){
                avatar.addItemBackpack(cr.getCurrentCourse().getBook());
                rm = getRoom("Hallway 1.0");
                rm.setCreature(cr);
                
                break;
            }
    
        }
    }
    
    private void placeItem()
    {   Item it;
        Room rm;
        for (int i = 0;i<items.size() ;i++ ) {
            it = items.get(i);
            if(it instanceof Book){
                rm = getRoom("Hallway 1.0");
                rm.setItem(it);
                break;
            }
    
        }
    }


////////////////////////////////////////////////////////////////////    
    
   private void createTeachers() throws IOException 
    {   
        String[] names = fileToArray(nameFile); 
        Random rand = new Random();
        int i = rand.nextInt(names.length);


        for(int j = 0; j < numberOfTeachers ;i++,j++){
            if(i > names.length-1)
                i = 0;
            Teacher teacher = new Teacher(names[i]);
            if(!(j+1 > courses.size())){
                teacher.setCourse(courses.get(j));
                creatures.add(teacher);
            }
            else 
                creatures.add(teacher);

        }
    }

    
    private void createStudents() throws IOException 
    {   

        String[] names = fileToArray(nameFile); 
        Random rand = new Random();
        int i = rand.nextInt(names.length);
        int courseIndex1;
        int courseIndex2;
        int courseBook;
        for(int j = 0; j < numberOfStudents-1 ;i++,j++){
            if(i > names.length-1)
                i = 0;
            Student student = new Student(names[i]);
            courseIndex1 = rand.nextInt(courses.size());
            student.setCurrentCourse(courses.get(courseIndex1));
            
            do{
                courseIndex2 = rand.nextInt(courses.size());
            }while(courseIndex1 == courseIndex2);
                
            student.setFinnishedCourse(courses.get(courseIndex2));
            creatures.add(student);
            
        }


    }

    private void createBooks() throws IOException
    {
        String[] bookArr = fileToArray(bookFile);
        for (int i = 0;i < bookArr.length;i += 5) {
            Book book = new Book(bookArr,i);
            books.add(book);
            items.add(book);
        }
    }

    private void createRooms() throws IOException
    {
        String[] roomNames = fileToArray(roomFile); 
        for(int i = 0; i < roomNames.length;i += 9){

            Room room = new Room(roomNames,i);
            rooms.add(room);
        }

    }

    private void creaturesToRooms()
    {   
        Random rand = new Random();
        Room creatureRoom = null;
        int roomIndex = 0; 
        Creature creature;
        for(int i = 0; i < creatures.size();i++){
            do{ 
                
                roomIndex =  rand.nextInt(rooms.size()-1)+1;
                creatureRoom = rooms.get(roomIndex);
            
               }while(creatureRoom.hasCreature());

            creatureRoom.setCreature(creatures.get(i));
        }

    }
    
    private void itemsToRooms()
    {  
        Random rand = new Random();
        int roomIndex; 
        Room itemRoom = null;
        Item item;
        for(int i = 0; i < items.size();i++){

            do{
                roomIndex = rand.nextInt(rooms.size()-1)+1;
                itemRoom = rooms.get(roomIndex);

            }while(itemRoom.hasItem());

            itemRoom.setItem(items.get(i));
        }

    }

    private void createCourses() throws IOException
    {
        String[] courseNames = fileToArray(courseFile);
        String[] questions = fileToArray(questionFile);
        int i = 0;
        int k = 0;
        for(int j = 1;i < courseNames.length;i+=3, j+=6,k++){
            Book courseBook = books.get(k);
            Course course = new Course(courseNames,i,courseBook);
            courses.add(course);
            if(j > questions.length-1) 
               j = 0;
            course.setQuestion(questions,j);
            }

     }


   private Book getBook(String name)
    {
        for(int i = 0; i<books.size();i++){
            if(books.get(i).getName().equals(name))
            return books.get(i); 
    
        }
        return null;
    }
   
   private void createKeys()
    {
        for (int i = 1;i<numberOfKeys;i++) {
            Key key = new Key();
            items.add(key);
        }
    }

    private void createSfinx() throws IOException
    {
        String[] wisdoms = fileToArray(wisdomFile);
        Sfinx sfinx = new Sfinx(wisdoms);
        creatures.add(sfinx);
    }

    /**
     * Returns a room at a chosen index in the room list
     * @param index the index
     * @return a room at a given index i room list held in game
     */
    public Room getRoom(int index)
    {   
        if (index < rooms.size())
            return rooms.get(index);
        else return null;
    }

    /**
     * @param name the name of the room
     * @return room corresponding to a given name 
     * if it does not exist it returns the last room
     */
    public Room getRoom(String name)
    {
        Iterator<Room> roomIt = rooms.iterator();
        Room current = null; 
        while(roomIt.hasNext()){
            current = roomIt.next();
            if(current.getRoomName().compareTo(name) == 0)
                return current; 
        }
        return current;
    }

    /**
     * @return the avatar object from game
     */
    public Avatar getAvatar()
    {
        return avatar;
    }

    /**
     * Checks if the door is locked and if not checks if you have a key to open the door with. Returns true if the door is unlocked or if you can open it else returns false.
     * @param direction the direction the player wish to go
     * @param room the room the player is standing in
     * @return true if a door can be opend
     */
    public boolean openDoor(String direction, Room room)
    {
        if(!room.isLocked(direction)){
            return true;}
        Item ifKey = avatar.haveKey();
        System.out.println(ifKey == null);
        if(room.isLocked(direction) && !(ifKey == null)){
            avatar.removeItemBackpack(ifKey);
            room.openLocked(direction);
            return true;
        }
        else{
            System.out.println("You dont have a key to open the door");
            return false;
        }
    }

    /**
     * Checks if a course exists in either the unfinnished or finnished lists.
     * Return 75 if it exists in unfinnished, 50 in finnished else returns 0
     * @param teacher the teacher with a course to be checked
     * @return 75 if the avatar is taking the given course
     * 50 if the avatar has finnished the given course
     * 0 if none of the above
     */
    public int checkEnroll(Creature teacher)
    {
        if(avatar.checkUnfinnishedCourses(teacher.getCourse()))
            return 75; 
        if(avatar.checkFinnishedCourses(teacher.getCourse()))
            return 50;
        else return 0;
    }


    /**
     * Checks if the player can trade with a student and what the player want to trade for
     * @param student the student to trade with
     */
    public void trade(Student student)
    {
        Course finnished   = student.getFinnishedCourse();
        Course unfinnished = student.getCurrentCourse();
        Book wantedBook = unfinnished.getBook();
        Book tradeBook  = finnished.getBook();  
        String interaction;
        
        if(avatar.checkForItem(wantedBook)){
            interaction  = "\n"+student + " says:\n\n";
            interaction += "Great!\nyou have the book ";
            interaction += wantedBook.getName()+",\n";
            interaction += "I have been looking for that one.\n";
            interaction += "I just finnished "+finnished+",\n";
            interaction += "I can either give you the book for that course,\n";
            interaction +="or the answer for it´s question.\n";
            interaction += "which would you like to trade for?\n";
            System.out.println(interaction);   
            makeTrade(finnished,wantedBook);
        }
        else System.out.println("You have nothing to trade");
    }


    private void makeTrade(Course course,Book wantedBook)
    {
        Scanner input = new Scanner(System.in);
        String alternatives = "To trade for the book write: book\n";
        alternatives += "To trade for the answer write: answer"; 
        System.out.println(alternatives);
        String answer = input.nextLine();
        String questionAnswer = "The Answer to question in "+course +"is\n";
        questionAnswer += course.getQuestionAnswer();
        
        while(!(answer.equals("book") || (answer.equals("answer")))){
            System.out.println("Invalid answer");
            answer = input.nextLine();  
        }

        if(answer.equals("book")){
            if(!(avatar.addItemBackpack(course.getBook()))){
                System.out.println("Your backpack is to full\n");
                System.out.println("Here is the answer to the question instead\n");
                System.out.println(questionAnswer);    
            
            }else{
                String message = "\nAlright here is book ";  
                message += course.getBook().getName()+".\n";
                message += "Pleasure doing buisness with you!\n"; 
                System.out.println(message);
                avatar.removeItemBackpack(wantedBook);
            }
            
        } 
            if(answer.equals("answer")){
                System.out.println(questionAnswer);
            } 
        
    }

    /**
     * place an item in a random room
     * @param item the item to be placed
     */
    public void placeItemRandom(Item item)
    {
        Random rand = new Random();
        int roomIndex; 
        Room itemRoom = null;
        do{
            roomIndex = rand.nextInt(rooms.size()-1)+1;
            itemRoom = rooms.get(roomIndex);

        }while(itemRoom.hasItem());
        itemRoom.setItem(item);
    }
    
   
    /**
     * replace a creature in a random room
     * @param room the room to with the creature to be replaced
     */
    public void placeCreatureRandom(Room room)
    {
        Creature creatureToMove = room.getCreature();
        room.setCreature(null);
        Random rand = new Random();
        int roomIndex; 
        Room itemRoom = null;
        do{
            roomIndex = rand.nextInt(rooms.size()-1)+1;
            itemRoom = rooms.get(roomIndex);

        }while(itemRoom.hasCreature());
        itemRoom.setCreature(creatureToMove);
    }

    private String[] fileToArray(String fileName) throws IOException
    {  
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String[] strings;
        try{
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while(line != null){
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();

            }

            String every = sb.toString();
            String everything = every.replace("\n","");
            strings = everything.split(";") ;
        }

        finally {
            br.close();


        }
        return strings;
    }
}




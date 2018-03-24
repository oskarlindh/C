import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.lang.StringBuilder;
import java.io.File;
import java.util.List;
import java.util.LinkedList;
import java.util.Random;
public class TeacherStudentCreate
{   
    List<Creature> creatureList;
    
    public TeacherStudentCreate(String filename,int teachers, int students) throws IOException 
    {   
        creatureList = new LinkedList<Creature>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        
        try{
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while(line != null){
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            
           String everything = sb.toString();
           String[] names = everything.split(";");
           Random rand = new Random();
           int i = rand.nextInt(names.length)-1;
           
           for(int j = 0; j < teachers ;i++,j++){
               if(i == names.length)
                    i = 0;
                Teacher teacher = new Teacher(names[i]);
                creatureList.add(teacher);
           }
           for(int j = 0; j < students ;i++,j++){
               int placeIndex = rand.nextInt(creatureList.size());
               if(i == names.length)
                    i = 0;
                Student student = new Student(names[i]);
                creatureList.add(placeIndex,student);
            }
        
        }
        finally {
            br.close();
        }
    }
    
    public Creature getCreature(int index)
    {   if (index < creatureList.size()){
        return creatureList.get(index);
    }
        else return null;
    }

}


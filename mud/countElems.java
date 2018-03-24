import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.lang.StringBuilder;
import java.io.File;
import java.util.LinkedList;
import java.util.Random;
import java.util.List;
public class countElems
{
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new FileReader("rooms.txt"));
        String[] done;
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
            done = everything.split(";");

        }

        finally {
            br.close();


        }
        for(String s: done)
            System.out.println(s);
    }
}


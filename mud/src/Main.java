import java.util.Scanner;
import java.io.IOException;
import java.lang.Exception;

/**
 * The main class handles the mud class and makes the player decide what it what to do and changes room 
 */
public class Main
{      private static final String welcome = "Welcome to Polhacks.\nA school of many mysteries and hard questions.\nYou will soon be dropt into the school, and your jobb is to complete your education.\nThis is done by finish courses, talking to students and answering the teachers questions.\nYour goal is to get 180 hp and finding the sphinx.\nWrite help for a list of commands.\n\nTo start the game write start";


    public static void main(String[] args) throws noRoomException,  IOException{

        Mud mud = new Mud(); 
        int numberOfRooms = 0;
        System.out.println(welcome);
        mud.start();
        while(true){
            System.out.println(mud.getRoom());
            String moveToRoom = mud.playerAction();
            if(moveToRoom == null){
                System.out.println("You cant walk that way");
                continue;
            }
            if(moveToRoom.equals("X"))
                throw new noRoomException("You went outside of the game");
            if(moveToRoom.equals("Complete"))
                break;

            numberOfRooms += 1;
            mud.moveToRoom(moveToRoom);
        }
        System.out.println("Congratz, you have completed the game.\nIt took you " + numberOfRooms + "turns.");
    }



}

import java.util.Scanner;

public class Mud 
{
    public static void main(String[] args) throws noRoomException {
        Game game = new Game();
        Avatar player = game.getAvatar();
        int numberOfRooms = 0;
        System.out.println("Welcome to Polhacks.\nA school of many mysteries and hard questions.\n You will soon be dropt into the school, and your jobb is to complete your education.\n This is done by finish courses, talking to students and answering the teachers questions.\n Your goal is to get 180 hp and finding the sphinx.\nWrite help for a list of commands.\n\n\n");
        Thread.sleep(1);
        System.out.println("You wake up, you find yourself in a hallway.\n Next to you you find a ragged backpack,\n you pick it up and somehow knows it has volume of 10.\n Now to the big question, which way to go?\n");
        Room place = game.start();
        while(true){
            System.out.println("hej");
            String moveToRoom = playerAction(place,game,player);
            if(moveToRoom == null){
                System.out.println("You cant walk that way");
                continue;
            }
            if(moveToRoom.equals("X"))
              throw new noRoomException("You went outside of the game");
            if(moveToRoom.equals("Complete"))
                break;
            Creature moveCreature = place.getCreature();
            place.setCreature(null);
                place = game.getRoom(moveToRoom);
            numberOfRooms += 1;
        }
        System.out.println("Congratz, you have completed the game.\nIt took you " + numberOfRooms + "turn.");
    }

    private static String playerAction(Room place, Game game, Avatar player)
    {
        String answer;
        Scanner input = new Scanner(System.in);
        //TODO Check if teacher gonna ask question
        while(true)
            {
                System.out.println("What do want to do?");
                answer = input.nextLine();
                answer = answer.toLowerCase();
                if(answer.equals("north") && game.openDoor(answer,place))
                    return place.getInDirection(answer);
                else if(answer.equals("east") && game.openDoor(answer,place))
                    return place.getInDirection(answer);
                else if (answer.equals("south") && game.openDoor(answer,place))
                    return place.getInDirection(answer);
                else if (answer.equals("west") && game.openDoor(answer,place))
                    return place.getInDirection(answer);
                else if (answer.equals("help"))
                    System.out.println("\nTo move just write the direction. Example west or south.\n Write Pickup item to pickup the item.\n Talk and name to talk to teacher and students\n Write Trade and students name to trade a course book for either an answer or another couse book.\n Write Enroll to take a couse a teacher is teaching.\nStatus to get your status\nWrite Take degree to complete the game if you got 180hp, no unfinished course and standing in the same room as the sphinx\n");
                else if(answer.toLowerCase().equals("talk" + place.getCreatureName().toLowerCase()))
                    place.getCreature().talk();
                else if(answer.equals("pickup item"))
                    {
                       player.pickupItem(place);
                    }
                else if(answer.equals("enroll") && place.getCreature().getCreatureType().equals("Teacher"))
                    {
                        if(game.checkEnroll((Teacher)place.getCreature()) == 0)
                            player.addUnfinnishedCourse(place.getCreature().getCourse());
                        else if(game.checkEnroll((Teacher)place.getCreature()) == 75)
                            System.out.println("You have already finnish this course");
                        else
                            System.out.println("You are already taking thi course");
                    }
                else if(answer.equals("status"))
                    player.printAvatar();
                else if(answer.equals("take degree") && place.getCreature().getCreatureType().equals("Sphinx"))
                    {
                        if(player.checkIfDone())
                            return "Complete";
                        else
                            System.out.println("You can't fool me, shame on you");
                    }
                else
                    System.out.println("Invalid action");
            }
    }
}


   

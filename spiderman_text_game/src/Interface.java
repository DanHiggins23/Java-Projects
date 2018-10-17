//Import scanner to allow user input
import java.util.Scanner;

//Class created to run/manage the whole program
public class Interface {

    //Create a new instance of the scanner and link classes
    Scanner input = new Scanner(System.in);
    World w = new World();

    //Main
    public static void main(String[] args) {
        Interface i = new Interface();
        i.menu();
    }

    //Display menu to user at the start of the game
    //Request user to enter name and display some story
    void menu() {
        System.out.println("\n////// WELCOME TO THE SPIDER-MAN ADVENTURE GAME! //////\n");
        System.out.print("Please enter your Spider-Man name: ");
        String userName = input.nextLine();

        System.out.println("\nWelcome " + userName + "! Lets save New York!!");
        System.out.print("______________________________________________________________\n");

        System.out.print("\nIt's just another day in New York for Spider-Man. Crime is at an all time high, and Spider-Man's radar isn't working. \nYou must utilise the Spidey-Compass to navigate the city!\n");
        jump();
    }

    //Method that requires user to enter 'jump' before continuing
    void jump() {
        System.out.print("\nYou are perched on the top of the Avengers Tower. Try 'jump'\n");

        String userJump = input.nextLine();

        if (userJump.equals("jump")) {
            System.out.print("\nYou dive off the Avengers tower and are diving towards the ground!");
            navigate();
        } else {
            System.out.println("\nYou must jump off the Avengers Tower to navigate the city!");
            System.out.print("______________________________________________________________\n");
            jump();

        }
    }

    //Call method for World class for navigation depending on user input
    void navigate() {
        System.out.print("\nSpider-Man can hear sirens and explosions, but can't locate them due to his radar. \nYou must use the compass to choose his way");
        System.out.print("\n______________________________________________________________\n");
        System.out.print("\nTry 'north', 'south', 'east', 'west'\n");
        String compassSelection = input.nextLine();

        //If statement to determine the location that the user will go to
        if (compassSelection.equals("north")) {
            w.financialDistrict();
        } else if (compassSelection.equals("east")) {
            w.timeSquare();
        } else if (compassSelection.equals("south")) {
            w.centralPark();
        } else if (compassSelection.equals("west")) {
            w.hellsKitchen();
        } else {
            System.out.println("Please enter a valid direction!");
            navigate();
        }

    }
}

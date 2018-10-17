//Import scanner to allow user input
import java.util.Scanner;
//Import random to allow the generation of random numbers
import java.util.Random;

public class Attacks {

    int health = 100;
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    Gadgets g  = new Gadgets();

    public static void main(String[] args) {
        Attacks a = new Attacks();
    }

    //Request user input for attack type and run method depending on choice
    void attackChoice() {
        System.out.println("How would you like to attack..enter [1] for stealth or [2] for all-guns-blazing.");
        int userAttack = input.nextInt();

        if (userAttack == 1) {
            stealth();
        } else if (userAttack == 2) {
            allGunsBlazing();
        } else {
            System.out.println("Please enter either 1 or 2!!");
            attackChoice();
        }
    }

    void stealth() {
        //Display story
        System.out.print("______________________________________________________________\n");
        System.out.println("\nYou go round different vantage points taking enemies out 1-by-one.");
        System.out.println("You have defeated 3 out of 4 enemies");
        System.out.println("\nAn enemy shoots you, grazing the side of your chest. You have lost 20 health!!");
        health = health - 20;
        System.out.println("You have " + health + " health points left.");

        //Allow user to choose a gadget to finish last enemy
        System.out.println("\nWhich gadget would you like to use to defeat the final enemy?");
        g.gadgetChoice();

        System.out.println("All enemies have now been defeated!");
        System.out.println("You head back to base.");
    }

    void allGunsBlazing() {
        System.out.print("______________________________________________________________\n");
        System.out.println("\nYou web-strike the first enemy and the others rush you!!");

        //Random number created to determine how much health is lost
        //Max bound set to 120 to increase the chances of dying
        int healthLost = rand.nextInt(120);
        health = health - healthLost;

        //Show to user how much health you have lost
        System.out.println("You have lost " + healthLost + " health! You have " + health + " health left.");

        //If statement to allow user to use a different approach for the attack
        //If health is greater than 0 return to base and all enemies defeated
        if (health > 0) {
            System.out.println("All enemies have now been defeated!");
            System.out.println("You head back to base.");
        //If health is less than 0, user has died and can try again
        } else {
            System.out.print("______________________________________________________________\n");
            System.out.println("\nYou have died. Maybe consider another approach next time!!");
            attackChoice();
        }
    }
}

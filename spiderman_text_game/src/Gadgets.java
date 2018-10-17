//Import scanner to allow user input
import java.util.Scanner;

public class Gadgets {

    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Gadgets g = new Gadgets();
    }

    //Allow user to make a selection for which gadget they would like to use
    //Store choice in variable
    void gadgetChoice() {
        System.out.println("Enter [1] for impact web | Enter [2] for web bomb | Enter [3] for electricWeb");
        int userGadget = input.nextInt();

        if (userGadget == 1) {
            impactWeb();
        } else if (userGadget == 2) {
            webBomb();
        } else if (userGadget == 3) {
            electricWeb();
        }
    }

    //Show story based on gadget selection
    void impactWeb() {
        System.out.println("\nYou have selected impact web!");
        System.out.println("Spider-man fires the impact web, which attaches to the enemy, launching him to the side of the wall.");
    }

    //Show story based on gadget selection
    void webBomb() {
        System.out.println("\nYou have selected web bomb!");
        System.out.println("Spider-man fires the web bomb, which attaches to the enemy on impact..");
        System.out.println("Spider-man web zips the enemy and sticks him to a wall!");
    }

    //Show story based on gadget selection
    void electricWeb() {
        System.out.println("\nYou have selected electric web!");
        System.out.println("Spider-man fires the electric web, which stuns the enemy..");
        System.out.println("Spider-man web zips to the enemy and deals a final knockout blow!.");
    }
}

//Import scanner to allow user input
import java.util.Scanner;
//Import random to allow the generation of random numbers
import java.util.Random;

public class Story {

    //Create new instances of scanner and random and declare variables for use throughout class
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    String location;
    int bossStrength;
    int userGadget;
    int damageGiven;
    int damageTaken;
    int gadgetRequired;
    int spidermanHealth = 150;

    //Link other classes
    Enemy e = new Enemy();
    Gadgets g = new Gadgets();
    Attacks a = new Attacks();

    public static void main(String[] args) {
        Story s = new Story();
        s.story();
    }

    void story() {
        //Display story
        System.out.print("______________________________________________________________\n");
        System.out.println("\nYou gather samples of the smoke - the smoke is Dragon Breath. This is bad.");
        System.out.println("You follow the trail of smoke for a while. You reach a dark alley.");
        System.out.println("At the end of the alley you see a dark figure..");
        System.out.println("Do you wish to proceed? Try 'yes' or 'no'");
        String userProceed = input.nextLine();

        if (userProceed.equals("yes")) {
            //Random number created between 1 & 3 to determine the enemy
            int enemyNumber = rand.nextInt(3) + 1;

            //If statement to call the enemy from the enemy class depending on random number
            if (enemyNumber == 1) {
                e.drOctopus();
                //Set enemy strength - different for each enemy type
                bossStrength = 120;
                //Set the gadget that is required to beat the enemy type
                gadgetRequired = 1;
                //Call method to allow user to select gadget to fight boss with
                bossGadgetChoice();
            } else if (enemyNumber == 2) {
                e.electro();
                bossStrength = 80;
                gadgetRequired = 2;
                bossGadgetChoice();
            } else if (enemyNumber == 3) {
                e.mrNegative();
                bossStrength = 100;
                gadgetRequired = 3;
                bossGadgetChoice();
            }
        } else if (userProceed.equals("no")) {
            //Return to previous step if user doesn't want to proceed
            story();
        } else {
            System.out.println("Please enter either 1 or 2!!");
            story();
        }
    }

    void bossGadgetChoice() {
        //Method to allow user to select a gadget then attack
        System.out.println("\nYou must use the correct gadget to beat your enemy!!");
        System.out.println("Which gadget would you like to use?");

        System.out.println("Enter [1] for impact web | Enter [2] for web bomb | Enter [3] for electricWeb");
        userGadget = input.nextInt();

        bossAttack();
    }

    void bossAttack() {
        //Call method from gadgets class to display info about the gadget
        if (userGadget == 1) {
            g.impactWeb();
        } else if (userGadget == 2) {
            g.webBomb();
        } else if (userGadget == 3) {
            g.electricWeb();
        }

        System.out.print("______________________________________________________________\n\n");

        //While loop for the fight between Spider-man and the enemy
        //Loop will continue until spider-man's/enemy's health is less than or equal to 0
        while (bossStrength >= 0 && spidermanHealth >= 0) {
            //If the user has selected the correct gadget to fight the enemy, then attack
            if (userGadget == gadgetRequired) {
                //Random number created to show damage taken
                damageGiven = rand.nextInt(120);
                //damageTaken lower than damageGiven to give a higher chance of the user winning
                damageTaken = rand.nextInt(80);
                System.out.println("You attack..");
                System.out.println("You have caused " + damageGiven + " damage!!");
                bossStrength = bossStrength - damageGiven;

                System.out.println("\nThe enemy attacks..");
                System.out.println("They have caused " + damageTaken + " damage!!\n");
                spidermanHealth = spidermanHealth - damageTaken;
            //Break the loop if health is less than or equal to 0
            } else if (bossStrength <= 0) {
                break;
            } else if (spidermanHealth <= 0) {
                break;
            //Otherwise, tell the user they are using the wrong gadget
            } else {
                System.out.println("You have caused 0 damage. Try another gadget!!");
                bossGadgetChoice();
            }
        }

        //If enemy health is <= to 0 output enemy has been defeated
        if (bossStrength <= 0) {
            System.out.println("////// You have defeated the enemy!! //////");
            finish();
        }

        //If spider-man's health is <= to 0 output you have died and get user to select gadget again
        if (spidermanHealth <= 0) {
            System.out.println("\n////// You have died! Please try again!! //////");
            System.out.print("\n______________________________________________________________\n");
            bossGadgetChoice();
        }
    }

    void finish() {
        System.out.print("\n______________________________________________________________\n");
        System.out.println("\n//// CONGRATULATIONS, YOU HAVE FOUND THE BOSS AND DEFEATED THEM!!! NEW YORK IS SAFE!! ////");
        //Exit game when user has defeated the boss
        System.exit(0);
    }
}

//Import scanner to allow user input
import java.util.Scanner;

//Class created to create the world
public class World {

    String location;
    int swingAmount;
    int userSwings = 0;
    Scanner input = new Scanner(System.in);
    Crimes c = new Crimes();
    Story s = new Story();

    public static void main(String[] args) {
        World w = new World();
    }

    //World sectioned into five - Central / North / East / South / West

    //Central
    //This is where the user will return to to navigate anywhere else
    void avengersTower() {
        location = "avengersTower";
        System.out.print("______________________________________________________________\n");
        System.out.println("\n////// AVENGERS TOWER //////");
        System.out.println("\nYou are back at the Avengers Tower!");
        System.out.println("You can see for miles around. This is you base and your location!");

        System.out.print("\nTry 'north', 'south', 'east', 'west'\n");
        String compassSelection = input.nextLine();

        //If statement to determine the location that the user will go to
        if (compassSelection.equals("north")) {
            financialDistrict();
        } else if (compassSelection.equals("east")) {
            timeSquare();
        } else if (compassSelection.equals("south")) {
            centralPark();
        } else if (compassSelection.equals("west")) {
            hellsKitchen();
        } else {
            System.out.println("Please enter a valid direction!\n");
            avengersTower();
        }
    }

    //North
    //Here there will be a crime type that the user can tackle
    void financialDistrict() {
        location = "financialDistrict";

        System.out.print("______________________________________________________________\n");
        System.out.println("\n////// FINANCIAL DISTRICT //////");
        System.out.println("\nYou have entered the Financial District!");
        System.out.println("People are everywhere, traffic is busy. The buildings are high, great for swinging!");

        //Ask user if they want to explore financial district or go back to base
        System.out.println("Please enter [1] if you would like explore | Enter [2] if you would like to go back to base: ");
        userSwings = input.nextInt();

        if (userSwings == 1) {
            System.out.print("______________________________________________________________\n");
            System.out.println("\nYour spider-sense goes off!!");
            System.out.println("You hear sirens, it sounds like a crime!");

            System.out.println("Do you wish to help? Enter 'yes' or 'no");
            String userChoice = input.nextLine();
            userChoice = input.nextLine();

            //If user wishes to fight crime, run a crime method within the crime class
            if (userChoice.equals("yes")) {
                c.kidnap();
                avengersTower();
            } else if (userChoice.equals("no")) {
                avengersTower();
            }
        } else if (userSwings == 2) {
            avengersTower();
        } else {
            System.out.println("Please enter either 1 or 2!!");
            financialDistrict();
        }
    }

    //East
    //This is the section of the world where the main story will happen
    void timeSquare() {
        location = "timeSquare";
        System.out.print("______________________________________________________________\n");
        System.out.println("\n////// TIME SQUARE //////");
        System.out.println("\nYou have entered Time Square!");
        System.out.println("The billboards are lit, the sun glistens off the bright lights.");

        System.out.println("Please enter [1] if you would like explore | Enter [2] if you would like to go back to base: ");
        int userSwings = input.nextInt();

        if (userSwings == 1) {
            System.out.print("______________________________________________________________\n");
            System.out.println("\nYour spider-sense goes off!!");
            System.out.println("You're in the center of time square. The place is covered in red smoke..");
            System.out.println("There is something strange going on..");

            System.out.println("\nWould you like to explore further or go back?");
            System.out.println("Enter [1] to explore | Enter [2] to go back");
            int userChoice = input.nextInt();

            //Run story method in story class
            if (userChoice == 1) {
                s.story();
            } else if (userChoice == 2) {
                timeSquare();
            }
        } else if (userSwings == 2) {
            avengersTower();
        } else {
            System.out.println("Please enter either 1 or 2!!");
            timeSquare();
        }
    }

    //South
    //Here there will be a crime type that the user can tackle
    void centralPark() {
        location = "centralPark";
        System.out.print("______________________________________________________________\n");
        System.out.println("\n////// CENTRAL PARK //////");
        System.out.println("\nYou have entered Central Park!");
        System.out.println("The park is busy, birds are tweeting, families are having picnic's. The trees are low, swinging is not great here!");

        System.out.println("Please enter [1] if you would like explore | Enter [2] if you would like to go back to base: ");
        userSwings = input.nextInt();

        if (userSwings == 1) {
            System.out.print("______________________________________________________________\n");
            System.out.println("\nYour spider-sense goes off!!");
            System.out.println("You hear sirens, it sounds like a crime!");

            System.out.println("Do you wish to help? Enter 'yes' or 'no");
            String userChoice = input.nextLine();
            userChoice = input.nextLine();

            //If user wishes to fight crime, run a crime method within the crime class
            if (userChoice.equals("yes")) {
                c.burgulary();
                avengersTower();
            } else if (userChoice.equals("no")) {
                avengersTower();
            }
        } else if (userSwings == 2) {
            avengersTower();
        } else {
            System.out.println("Please enter either 1 or 2!!");
            centralPark();
        }
    }

    //West
    //Here there will be a crime type that the user can tackle
    void hellsKitchen() {
        location = "hellsKitchen";
        System.out.print("______________________________________________________________\n");
        System.out.println("\n////// HELLS KITCHEN //////");
        System.out.println("\nYou have entered Hells Kitchen!");
        System.out.println("Hells Kitchen looks dark and gloomy. Dark allys everywhere.");

        System.out.println("Please enter [1] if you would like explore | Enter [2] if you would like to go back to base: ");
        userSwings = input.nextInt();

        if (userSwings == 1) {
            System.out.print("______________________________________________________________\n");
            System.out.println("\nYour spider-sense goes off!!");
            System.out.println("You hear sirens, it sounds like a crime!");

            System.out.println("Do you wish to help? Enter 'yes' or 'no");
            String userChoice = input.nextLine();
            userChoice = input.nextLine();

            //If user wishes to fight crime, run a crime method within the crime class
            if (userChoice.equals("yes")) {
                c.carHijack();
                avengersTower();
            } else if (userChoice.equals("no")) {
                avengersTower();
            }
        } else if (userSwings == 2) {
            avengersTower();
        } else {
            System.out.println("Please enter either 1 or 2!!");
            hellsKitchen();
        }
    }
}

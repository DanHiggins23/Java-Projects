//Import scanner to allow user input
import java.util.Scanner;

public class Crimes {

    Scanner input = new Scanner(System.in);
    Attacks a = new Attacks();

    public static void main(String[] args) {
        Crimes c = new Crimes();
    }

    //Display story and call attack choice method from attacks class to allow user to choose an attack
    void kidnap() {
        System.out.print("______________________________________________________________\n");
        System.out.println("\nPOLICE REPORT: Code 197, kidnap has been reported! All units please converge in the financial district. Shots have been fired!");

        System.out.println("\n////// KIDNAP //////\n");
        System.out.println("There are 4 enemies in sight and 1 hostage.\n");
        System.out.println("You web-swing onto the nearest lamp post to assess your options!");

        a.attackChoice();
    }

    //Display story and call attack choice method from attacks class to allow user to choose an attack
    void carHijack() {
        System.out.print("______________________________________________________________\n");
        System.out.println("\nPOLICE REPORT: Code 194, car hijack has been reported! All units please converge in hells kitchen. Shots have been fired!");

        System.out.println("\n////// CAR HIJACK //////\n");
        System.out.println("There are 4 enemies in sight and 1 hostage.\n");
        System.out.println("You web-swing onto the nearest lamp post to assess your options!");

        a.attackChoice();
    }

    //Display story and call attack choice method from attacks class to allow user to choose an attack
    void burgulary() {
        System.out.print("______________________________________________________________\n");
        System.out.println("\nPOLICE REPORT: Code 196, burgulary has been reported! All units please converge in central park. Shots have been fired!");

        System.out.println("\n////// BURGULARY //////\n");
        System.out.println("There are 4 enemies in sight and 1 hostage.\n");
        System.out.println("You web-swing onto the nearest lamp post to assess your options!");

        a.attackChoice();
    }

}

public class Enemy {

    int strength;

    public static void main(String[] args) {
        Enemy e = new Enemy();
    }

    //Method created for each enemy type
    //Display story
    void mrNegative() {
        System.out.print("______________________________________________________________\n");
        System.out.println("\n////// MR NEGATIVE BOSS FIGHT //////");
        System.out.println("\nIt's Mr Negative. You are in for a fight!!");

        //Set strength of the enemy
        strength = 100;
        System.out.println("He has " + strength + " strength. This will be tough!!");
    }

    void electro() {
        System.out.print("______________________________________________________________\n");
        System.out.println("\n////// ELECTRO BOSS FIGHT //////");
        System.out.println("\nIt's Electro. You are in for a fight!!");

        strength = 80;
        System.out.println("He has " + strength + " strength. This will be tough!!");
    }

    void drOctopus() {
        System.out.print("______________________________________________________________\n");
        System.out.println("\n////// DR OCTOPUS BOSS FIGHT //////");
        System.out.println("\nIt's Dr Octopus. You are in for a fight!!");

        strength = 120;
        System.out.println("He has " + strength + " strength. This will be tough!!");
    }

}

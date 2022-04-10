import java.util.Scanner;
public class Shop {
    private int itemMenu;
    private static int playerPurchase;
    private static int itemPrice;


     public static void shop(Bank personal, double inflation, Charachter main)
    {
        Scanner scan= new Scanner(System.in);
        System.out.println("[Welcome to the Shop]\n" +
                "Upgrade your equipment to perform better in the ring!");
        System.out.println("Your current balance is $" + personal.getBalance());
        System.out.println("Please chose a category \n1) Gloves \n2) Shorts \n3) Shoes \n4) Exit");
        int itemMenu = scan.nextInt();
        switch(itemMenu){
            case 1:
                System.out.println("[Boxing Gloves]");
                System.out.println("Which ones do you want to buy?");
                System.out.println("1) Silver Pro Gloves $" + (200*personal.getInflation()) + " - upgrades damage by +2");
                System.out.println("2) Diamond Champion Gloves $" + (650*personal.getInflation()) + " - upgrades damage by +7");
                System.out.println("3) Exit");
                int playerPurchase= scan.nextInt();
                switch (playerPurchase){
                    case 1:

                        double itemPrice=(200*personal.getInflation());
                        personal.subBalance(itemPrice);
                        main.addDamage(2);
                        break;

                    case 2:

                        itemPrice=(650*personal.getInflation());
                        personal.subBalance(itemPrice);
                        main.addDamage(5);
                        break;
                    default:
                        break;
                }
                System.out.println("Your balance is now $" + personal.getBalance());
                System.out.println();


            break;
            case 2:
                System.out.println("[Boxing Shorts]");
                System.out.println("Which ones do you want to buy?");
                System.out.println("1) Rookie Shorts $" + (200*personal.getInflation()) + " - upgrades health by +2");
                System.out.println("2) Champion Shorts $" + (750*personal.getInflation()) + " upgrades health by +9");
                System.out.println("3) Exit");
                playerPurchase= scan.nextInt();
                switch (playerPurchase){
                    case 1:
                        double itemPrice=(200*personal.getInflation());
                        personal.subBalance(itemPrice);
                        main.addHealth(2);
                        break;
                    case 2:
                        itemPrice=(750*personal.getInflation());
                        personal.subBalance(itemPrice);
                        main.addHealth(10);
                        break;
                    default:
                        break;
                }
                System.out.println("Your balance is now $" + personal.getBalance());
                System.out.println();

            break;

            case 3:
                System.out.println("[Boxing Shoes]");
                System.out.println("Which ones do you want to buy?");
                System.out.println("1- Semi Pro Shoes $" + (200* personal.getInflation()) + " - upgrades damage by +1 and health by +1");
                System.out.println("2- Grand Master Shoes $" + (850*personal.getInflation()) + " - upgrades damage by +2 and health by +8");
                System.out.println("3) Exit");
                playerPurchase= scan.nextInt();
                switch (playerPurchase){
                    case 1:
                        double itemPrice=(200*personal.getInflation());
                        personal.subBalance(itemPrice);
                        main.addDamage(1);
                        main.addHealth(1);
                        break;
                    case 2:
                        itemPrice=(850*personal.getInflation());
                        personal.subBalance(itemPrice);
                        main.addDamage(2);
                        main.addHealth(8);
                        break;
                    default:
                        break;

                }
                System.out.println("Your balance is now $" + personal.getBalance());
                System.out.println();

                break;
            case 4:
                break;
            default:
                System.out.println("Invalid Selection.");
            break;
        }

}
}

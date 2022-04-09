import java.util.Scanner;
public class Shop {
    private int itemMenu;
    private static int playerPurchase;
    private static int itemPrice;


    Shop() {
        Scanner scan= new Scanner(System.in);
        System.out.println("[Welcome to the Shop]\n" +
                "Upgrade your equipment to perform better in the ring!");
        System.out.println("Your current balance is " + get_balance()); //add player balance
        System.out.println("Please chose a category \n 1- Gloves \n 2- Shorts \n 3- Shoes");
        itemMenu= scan.nextShort();
        switch(itemMenu){
            case 1: gloves(); break;
            case 2: shorts(); break;
            case 3: shoes(); break;
            default: System.out.println("Invalid Selection."); break;
        }

    }

    public static float shorts()
    {
        itemPrice = 0;
        Scanner scan= new Scanner(System.in);
        System.out.println("[Boxing Shorts]");
        System.out.println("1- Basic Shorts $50 \n 2- Rookie Shorts $100 \n 3- Veteran Striped Shorts $300 \n 4- Legendary Shorts $550");
        playerPurchase= scan.nextInt();
        switch (playerPurchase){
            case 1: itemPrice=50; break;
            case 2: itemPrice=100; break;
            case 3: itemPrice=300; break;
            case 4: itemPrice=550; break;
        }
        float newBalance = get_balance() - itemPrice;
        return newBalance;
    }

    public static float shoes()
    {
        itemPrice = 0;
        Scanner scan= new Scanner(System.in);
        System.out.println("[Boxing Shoes]");
        System.out.println("1- Semi Pro Shoes $150 \n 2- Pro Shoes $250 \n 3- Champion Shoes $850 \n 4- Grand Master Shoes $1250");
        playerPurchase= scan.nextInt();
        switch (playerPurchase){
            case 1: itemPrice=150; break;
            case 2: itemPrice=250; break;
            case 3: itemPrice=850; break;
            case 4: itemPrice=1250; break;
        }
        float newBalance = get_balance() - itemPrice;
        return newBalance;
    }

    public static float gloves()
    {
        itemPrice = 0;
        Scanner scan= new Scanner(System.in);
        System.out.println("[Boxing Gloves]");
        System.out.println("1- Silver Pro Gloves $100 \n 2- Gold Pro Gloves $250 \n 3- Diamond Champion Gloves $650 \n 4- Platinum Master Gloves $1000");
        playerPurchase= scan.nextInt();
        switch (playerPurchase){
            case 1: itemPrice=100; break;
            case 2: itemPrice=250; break;
            case 3: itemPrice=650; break;
            case 4: itemPrice=1000; break;
        }
        float newBalance = get_balance() - itemPrice;
        return newBalance;
    }



    private static float get_balance()
    {
        return 1000;
    }

    private int getItemBoost(int boost)
    {
        return boost * 15;
    }

    public int setPlayerItems(int playerPurchase)
    {
        return playerPurchase;
    }

    public float setCurrencySpent(int spent)
    {
        spent = itemPrice;
        return spent;
    }


}


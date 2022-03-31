import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);


        titlescreen();
        System.out.println("\nIf you want to enter the Club we need your fighter name. Enter it below: ");
        String name = input.nextLine();
        Charachter main = new Charachter(name);
        System.out.println("Welcome " + main.getPlayerName()+ "!\n");
        boolean c = false;



        do {
            System.out.println("[Menu]");
            System.out.println("1) Start League ");
            System.out.println("2) Shop ");
            System.out.println("3) ");
            System.out.println("4) Tutorial Fight");
            System.out.println("5) Help ");
            System.out.println("6) Return to Title Screen ");
            System.out.println("7) Exit");
            System.out.println("\nEnter a Choice: " );
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("<<<League Games>>>");
                    break;
                case 2:
                    System.out.println("<<<Shop>>>");
                    break;
                case 3:
                case 4:
                    tutorial();
                case 5:
                    System.out.println("<<<Help Menu>>>");
                    break;
                case 6:
                    titlescreen();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("");

            }
        }while(c == false);

    }








    public static void titlescreen()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("\n" +
                "  ██╗ ██╗ ██╗    ███████╗██╗ ██████╗ ██╗  ██╗████████╗     ██████╗██╗     ██╗   ██╗██████╗     ██╗ ██╗ ██╗  \n" +
                " ██╔╝██╔╝██╔╝    ██╔════╝██║██╔════╝ ██║  ██║╚══██╔══╝    ██╔════╝██║     ██║   ██║██╔══██╗    ╚██╗╚██╗╚██╗ \n" +
                "██╔╝██╔╝██╔╝     █████╗  ██║██║  ███╗███████║   ██║       ██║     ██║     ██║   ██║██████╔╝     ╚██╗╚██╗╚██╗\n" +
                "╚██╗╚██╗╚██╗     ██╔══╝  ██║██║   ██║██╔══██║   ██║       ██║     ██║     ██║   ██║██╔══██╗     ██╔╝██╔╝██╔╝\n" +
                " ╚██╗╚██╗╚██╗    ██║     ██║╚██████╔╝██║  ██║   ██║       ╚██████╗███████╗╚██████╔╝██████╔╝    ██╔╝██╔╝██╔╝ \n" +
                "  ╚═╝ ╚═╝ ╚═╝    ╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═╝   ╚═╝        ╚═════╝╚══════╝ ╚═════╝ ╚═════╝     ╚═╝ ╚═╝ ╚═╝  \n" +
                "                                                                                                            ");
        System.out.println("Welcome to the Fight Club!");
        System.out.print("Press any key to start!");
        input.nextLine();
    }









    public static void tutorial()
    {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        Charachter tut = new Charachter("Player");
        Charachter tute = new Charachter("Tutorial");
        System.out.println("[Tutorial Fight]");
        System.out.println(   "        |||||||||                                                    |||||||||                                                                                         \n" +
                "        | _   _ |                                                    | _   _ |                                                                                \n" +
                "       (  ' _ '  )                                                  (  ' _ '  )                                                                                   \n" +
                "        |  ___  |                                                    |  ___  |                                       \n" +
                "         |_____|                                                      |_____|                                    \n" +
                "  _______/     \\_______                                        _______/     \\_______                                    \n" +
                " /                     \\                                      /                     \\                                                                                  \n" +
                "|   |\\             /|   |                                    |   |\\             /|   |                                               \n" +
                "|   ||  .       .  ||   |          __      _______           |   ||  .       .  ||   |                                           \n" +
                "|   / \\           / \\   |          \\ \\    / / ____|          |   / \\           / \\   |                                                                                     \n" +
                "\\  |   | |_ | _| |   |  /           \\ \\  / / (___            \\  |   | |_ | _| |   |  /                                                                                     \n" +
                "|==|   | |_ | _| |   |==|            \\ \\/ / \\___ \\           |==|   | |_ | _| |   |==|                                                                                 \n" +
                "/  /_ _|_|__|__|_|_ _\\  \\             \\  /  ____) |          /  /_ _|_|__|__|_|_ _\\  \\                                                                               \n" +
                "|___| /            \\|___|              \\/  |_____(_)         |___| /            \\|___|                                                                               \n" +
                "      |     |      |                                               |     |      |                                                                              \n" +
                "      |     |      |                                               |     |      |                                                                       \n" +
                "      |PLA  |   PLA|                                               |TUT  |   TUT|                                                                 \n" +
                "      |     |      |                                               |     |      |                                                                    \n" +
                "      \"|\"\"|\"\"\"|\"\"|\"\"                                               \"|\"\"|\"\"\"|\"\"|\"\"                                                                   \n" +
                "       |  |   |  |      -Player-                                    |  |   |  |      -Tutorial Enemy-                                                                   \n" +
                "       |  |   |  |                                                  |  |   |  |                                                                      \n" +
                "      /   )   (   \\                                                /   )   (   \\                                                                     \n" +
                "     Ooooo     ooooO                                              Ooooo     ooooO                                                               \n" +
                "\n");
        System.out.println("Player Health: " + tut.getPlayerHealth() + "            Opponents Health: " + tute.getPlayerHealth());
        boolean end = false;
        do {

            System.out.println("Options: ");
            System.out.println("1)Hit \n2)Dodge\n3)Rest");
            int pc = input.nextInt();
            int oc = (int)(Math.random()*(4-1)) + 1;
            System.out.println(oc);

            if(pc == 1 && oc == 1)
            {
                System.out.println("Both Hit!");
                tut.getHit(tute.getPlayerDamage());
                tute.getHit(tut.getPlayerDamage());
                System.out.println("Player Health: " + tut.getPlayerHealth() + "            Opponents Health: " + tute.getPlayerHealth());
            }
            else if(pc == 1 && oc == 2)
            {
                System.out.println("Opponent dodged your attack and countered!");
                tut.getHit(tute.getPlayerDamage());
                System.out.println("Player Health: " + tut.getPlayerHealth() + "            Opponents Health: " + tute.getPlayerHealth());
            }
            else if(pc == 1 && oc == 3)
            {
                System.out.println("You Hit while opponent was resting!");
                tute.getHit(tut.getPlayerDamage());
                System.out.println("Player Health: " + tut.getPlayerHealth() + "            Opponents Health: " + tute.getPlayerHealth());
            }
            else if(pc == 2 && oc == 1)
            {
                System.out.println("You dodged your opponents attack and countered!");
                tute.getHit(tut.getPlayerDamage());
                System.out.println("Player Health: " + tut.getPlayerHealth() + "            Opponents Health: " + tute.getPlayerHealth());
            }
            else if(pc == 2 && oc == 2 )
            {
                System.out.println("Both Dodged!");
                System.out.println("Player Health: " + tut.getPlayerHealth() + "            Opponents Health: " + tute.getPlayerHealth());
            }
            else if(pc == 2 && oc == 3)
            {
                System.out.println("Opponent Rested!");
                tute.rest();
                System.out.println("Player Health: " + tut.getPlayerHealth() + "            Opponents Health: " + tute.getPlayerHealth());
            }
            else if(pc == 3 && oc == 1)
            {
                System.out.println("Opponent Hit while you were resting!");
                tut.getHit(tute.getPlayerDamage());
                System.out.println("Player Health: " + tut.getPlayerHealth() + "            Opponents Health: " + tute.getPlayerHealth());
            }
            else if(pc == 3 && oc == 2)
            {
                System.out.println("You Rested!");
                tut.rest();
                System.out.println("Player Health: " + tut.getPlayerHealth() + "            Opponents Health: " + tute.getPlayerHealth());
            }
            else if(pc == 3 && oc == 3)
            {
                System.out.println("Both Rested");
                tut.rest();
                tute.rest();
                System.out.println("Player Health: " + tut.getPlayerHealth() + "            Opponents Health: " + tute.getPlayerHealth());
            }



            if(tut.getPlayerHealth() <= 0)
            {
                System.out.println("You got Knocked Out");
                System.out.println("Tutorial Over");
                end = true;
                break;
            }
            if(tute.getPlayerHealth() <= 0)
            {
                System.out.println("You win");
                end = true;
                break;
            }

        }while(end == false);
    }










    public static void leaugeGame(Charachter a, Charachter b)
    {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("[Tutorial Fight]");
        System.out.println(   "        |||||||||                                                    |||||||||                                                                                         \n" +
                "        | _   _ |                                                    | _   _ |                                                                                \n" +
                "       (  ' _ '  )                                                  (  ' _ '  )                                                                                   \n" +
                "        |  ___  |                                                    |  ___  |                                       \n" +
                "         |_____|                                                      |_____|                                    \n" +
                "  _______/     \\_______                                        _______/     \\_______                                    \n" +
                " /                     \\                                      /                     \\                                                                                  \n" +
                "|   |\\             /|   |                                    |   |\\             /|   |                                               \n" +
                "|   ||  .       .  ||   |          __      _______           |   ||  .       .  ||   |                                           \n" +
                "|   / \\           / \\   |          \\ \\    / / ____|          |   / \\           / \\   |                                                                                     \n" +
                "\\  |   | |_ | _| |   |  /           \\ \\  / / (___            \\  |   | |_ | _| |   |  /                                                                                     \n" +
                "|==|   | |_ | _| |   |==|            \\ \\/ / \\___ \\           |==|   | |_ | _| |   |==|                                                                                 \n" +
                "/  /_ _|_|__|__|_|_ _\\  \\             \\  /  ____) |          /  /_ _|_|__|__|_|_ _\\  \\                                                                               \n" +
                "|___| /            \\|___|              \\/  |_____(_)         |___| /            \\|___|                                                                               \n" +
                "      |     |      |                                               |     |      |                                                                              \n" +
                "      |     |      |                                               |     |      |                                                                       \n" +
                "      |PLA  |   PLA|                                               |USA  |   USA|                                                                 \n" +
                "      |     |      |                                               |     |      |                                                                    \n" +
                "      \"|\"\"|\"\"\"|\"\"|\"\"                                               \"|\"\"|\"\"\"|\"\"|\"\"                                                                   \n" +
                "       |  |   |  |      -Player-                                    |  |   |  |      -"+b.getPlayerName()+"-                                                                   \n" +
                "       |  |   |  |                                                  |  |   |  |                                                                      \n" +
                "      /   )   (   \\                                                /   )   (   \\                                                                     \n" +
                "     Ooooo     ooooO                                              Ooooo     ooooO                                                               \n" +
                "\n");
        System.out.println("Player Health: " + a.getPlayerHealth() + "            Opponents Health: " + b.getPlayerHealth());
        boolean end = false;
        do {

            System.out.println("Options: ");
            System.out.println("1)Hit \n2)Dodge\n3)Rest");
            int pc = input.nextInt();
            int oc = (int)(Math.random()*(4-1)) + 1;
            System.out.println(oc);

            if(pc == 1 && oc == 1)
            {
                System.out.println("Both Hit!");
                a.getHit(b.getPlayerDamage());
                b.getHit(a.getPlayerDamage());
                System.out.println("Player Health: " + a.getPlayerHealth() + "            Opponents Health: " + b.getPlayerHealth());
            }
            else if(pc == 1 && oc == 2)
            {
                System.out.println("Opponent dodged your attack and countered!");
                a.getHit(b.getPlayerDamage());
                System.out.println("Player Health: " + a.getPlayerHealth() + "            Opponents Health: " + b.getPlayerHealth());
            }
            else if(pc == 1 && oc == 3)
            {
                System.out.println("You Hit while opponent was resting!");
                b.getHit(a.getPlayerDamage());
                System.out.println("Player Health: " + a.getPlayerHealth() + "            Opponents Health: " + b.getPlayerHealth());
            }
            else if(pc == 2 && oc == 1)
            {
                System.out.println("You dodged your opponents attack and countered!");
                b.getHit(a.getPlayerDamage());
                System.out.println("Player Health: " + a.getPlayerHealth() + "            Opponents Health: " + b.getPlayerHealth());
            }
            else if(pc == 2 && oc == 2 )
            {
                System.out.println("Both Dodged!");
                System.out.println("Player Health: " + a.getPlayerHealth() + "            Opponents Health: " + b.getPlayerHealth());
            }
            else if(pc == 2 && oc == 3)
            {
                System.out.println("Opponent Rested!");
                b.rest();
                System.out.println("Player Health: " + a.getPlayerHealth() + "            Opponents Health: " + b.getPlayerHealth());
            }
            else if(pc == 3 && oc == 1)
            {
                System.out.println("Opponent Hit while you were resting!");
                a.getHit(b.getPlayerDamage());
                System.out.println("Player Health: " + a.getPlayerHealth() + "            Opponents Health: " + b.getPlayerHealth());
            }
            else if(pc == 3 && oc == 2)
            {
                System.out.println("You Rested!");
                a.rest();
                System.out.println("Player Health: " + a.getPlayerHealth() + "            Opponents Health: " + b.getPlayerHealth());
            }
            else if(pc == 3 && oc == 3)
            {
                System.out.println("Both Rested");
                a.rest();
                b.rest();
                System.out.println("Player Health: " + a.getPlayerHealth() + "            Opponents Health: " + b.getPlayerHealth());
            }



            if(a.getPlayerHealth() <= 0)
            {
                System.out.println("You got Knocked Out");
                System.out.println("Tutorial Over");
                end = true;
                break;
            }
            if(b.getPlayerHealth() <= 0)
            {
                System.out.println("You win");
                end = true;
                break;
            }

        }while(end == false);





    }
}



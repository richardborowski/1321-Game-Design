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
        Charachter one = new Charachter("a", 10, 0, 2);
        Charachter two = new Charachter("b", 11, 0, 2);
        Charachter three = new Charachter("c", 12, 0, 2);
        Charachter four = new Charachter("d", 13, 0, 2);
        Charachter five = new Charachter("e", 15, 0, 3);
        Charachter[] leagueone = {one,two,three,four,five};

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
                    int a = leaugeGame(main, leagueone);
                    if(a == 1)
                    {
                        System.out.println("\nYou have reached the next league! Your enemies will get harder now.\n");
                        for(int i = 0; i<leagueone.length; i++)
                        {
                            leagueone[i].resethealth();
                            leagueone[i].nextleauge();
                            leagueone[i].resethealth();
                        }
                    }
                    if(a == 2)
                    {
                        System.out.println("\nYou lost the league. Get stronger and try again\n");
                        for(int i = 0; i<leagueone.length; i++)
                        {
                            leagueone[i].resethealth();
                        }
                    }
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










    public static int leaugeGame(Charachter a, Charachter[] arr)
    {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int win = 0;
        int loose = 0;
        for( int i = 0; i < arr.length; i++)
        {
            a.resethealth();
            System.out.println("Fight " + (i+1));
            System.out.println("        |||||||||                                                    |||||||||                                                                                         \n" +
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
                    "       |  |   |  |      -"+a.getPlayerName()+"-                                    |  |   |  |      -" + arr[i].getPlayerName() + "-                                                                   \n" +
                    "       |  |   |  |                                                  |  |   |  |                                                                      \n" +
                    "      /   )   (   \\                                                /   )   (   \\                                                                     \n" +
                    "     Ooooo     ooooO                                              Ooooo     ooooO                                                               \n" +
                    "\n");
            System.out.println("Player Health: " + a.getFighthealth() + "            Opponents Health: " + arr[i].getFighthealth());
            boolean end = false;
            do {

                System.out.println("Options: ");
                System.out.println("1)Hit \n2)Dodge\n3)Rest");
                int pc = input.nextInt();
                int oc = (int) (Math.random() * (4 - 1)) + 1;
                System.out.println(oc);

                if (pc == 1 && oc == 1) {
                    System.out.println("Both Hit!");
                    a.getHit(arr[i].getPlayerDamage());
                    arr[i].getHit(a.getPlayerDamage());
                    System.out.println("Player Health: " + a.getFighthealth() + "            Opponents Health: " + arr[i].getFighthealth());
                } else if (pc == 1 && oc == 2) {
                    System.out.println("Opponent dodged your attack and countered!");
                    a.getHit(arr[i].getPlayerDamage());
                    System.out.println("Player Health: " + a.getFighthealth() + "            Opponents Health: " + arr[i].getFighthealth());
                } else if (pc == 1 && oc == 3) {
                    System.out.println("You Hit while opponent was resting!");
                    arr[i].getHit(a.getPlayerDamage());
                    System.out.println("Player Health: " + a.getFighthealth() + "            Opponents Health: " + arr[i].getFighthealth());
                } else if (pc == 2 && oc == 1) {
                    System.out.println("You dodged your opponents attack and countered!");
                    arr[i].getHit(a.getPlayerDamage());
                    System.out.println("Player Health: " + a.getFighthealth() + "            Opponents Health: " + arr[i].getFighthealth());
                } else if (pc == 2 && oc == 2) {
                    System.out.println("Both Dodged!");
                    System.out.println("Player Health: " + a.getFighthealth() + "            Opponents Health: " + arr[i].getFighthealth());
                } else if (pc == 2 && oc == 3) {
                    System.out.println("Opponent Rested!");
                    arr[i].rest();
                    System.out.println("Player Health: " + a.getFighthealth() + "            Opponents Health: " + arr[i].getFighthealth());
                } else if (pc == 3 && oc == 1) {
                    System.out.println("Opponent Hit while you were resting!");
                    a.getHit(arr[i].getPlayerDamage());
                    System.out.println("Player Health: " + a.getFighthealth() + "            Opponents Health: " + arr[i].getPlayerHealth());
                } else if (pc == 3 && oc == 2) {
                    System.out.println("You Rested!");
                    a.rest();
                    System.out.println("Player Health: " + a.getFighthealth() + "            Opponents Health: " + arr[i].getFighthealth());
                } else if (pc == 3 && oc == 3) {
                    System.out.println("Both Rested");
                    a.rest();
                    arr[i].rest();
                    System.out.println("Player Health: " + a.getFighthealth()+ "            Opponents Health: " + arr[i].getFighthealth());
                }


                if (a.getFighthealth() <= 0) {
                    System.out.println("You got Knocked Out");
                    loose += 1;
                    end = true;
                    break;
                }
                if (arr[i].getFighthealth() <= 0) {
                    System.out.println("You win");
                    win += 1;
                    end = true;
                    break;
                }

            } while (end == false);


        }

        if(win>=3)
        {
            return 1;
        }
        else
        {
            return 2;
        }


    }

}



import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args)
    {
        double inflation = 1;
        Scanner input = new Scanner(System.in);


        titlescreen();
        System.out.println("\nIf you want to enter the Club we need your fighter name. Enter it below: ");
        String name = input.nextLine();

        Charachter main = new Charachter(name);
        Bank personal = new Bank("Personal", 600,.5);
        Bank club = new Bank("Club", 0,.5);

        Charachter one = new Charachter("M. Tyson", 10, 0, 2);
        Charachter two = new Charachter("J. Frazier", 11, 0, 2);
        Charachter three = new Charachter("H. Armstrong", 12, 0, 2);
        Charachter four = new Charachter("SR. Robinson", 13, 0, 2);
        Charachter five = new Charachter("M. Ali", 15, 0, 3);

        Charachter[] leagueone = {one,two,three,four,five};

        Leauge starter = new Leauge("Starter", leagueone, 50);
        Leauge amateur = new Leauge("Amateur", leagueone, 50);
        Leauge pro = new Leauge("Pro", leagueone, 150);
        Leauge champion = new Leauge("Champion", leagueone, 200);
        Leauge legend = new Leauge("Legend", leagueone, 250);


        System.out.println("Welcome " + main.getPlayerName()+ "!\n");
        boolean c = false;



        do {
            System.out.println("[Menu]");
            System.out.println("1) Start League ");
            System.out.println("2) Shop ");
            System.out.println("3) Check Bank Balances ");
            System.out.println("4) Check your stats ");
            System.out.println("5) Tutorial Fight");
            System.out.println("6) Help ");
            System.out.println("7) Return to Title Screen ");
            System.out.println("8) Exit");
            System.out.println("\nEnter a Choice: " );
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("<<<League Games>>>");

                    //Amateur League play through
                    if(starter.getWon() == false)
                    {
                        System.out.println("You have $" + personal.getBalance() + " in your account");
                        System.out.println("Press \"y\" to pay the starter leauge fee of " + starter.getEntryfee());
                        input.nextLine();
                        String enter = input.nextLine();

                        if(enter.equalsIgnoreCase("y"))
                        {
                            personal.subBalance(starter.getEntryfee());
                            personal.checkBankruptcy();
                            System.out.println("You now have $" + personal.getBalance()+ " in your personal account");
                            personal.addinflation();
                            System.out.println("Inflation has rose to " + personal.getInflation());
                        }
                        else
                        {
                            break;
                        }
                        int a = leaugeGame(main, leagueone, club, personal);
                        if(a == 1)
                        {
                            System.out.println("\nYou have reached the next league! Your enemies will get harder now.\n");
                            for(int i = 0; i<leagueone.length; i++)
                            {
                                leagueone[i].resethealth();
                                leagueone[i].nextleauge();
                                leagueone[i].resethealth();
                                starter.setwin(true);
                                personal.transfer(club);
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
                    }


                    else if(starter.getWon() == true)
                    {
                        System.out.println("You have $" + personal.getBalance() + " in your account");
                        System.out.println("Press \"y\" to pay the amateur league fee of " + amateur.getEntryfee());
                        input.nextLine();
                        String enter = input.nextLine();

                        if(enter.equalsIgnoreCase("y"))
                        {
                            personal.subBalance(amateur.getEntryfee());
                            personal.checkBankruptcy();
                            System.out.println("You now have $" + personal.getBalance()+ " in your personal account");
                            personal.addinflation();
                            System.out.println("Inflation has rose to " + personal.getInflation());
                        }
                        else
                        {
                            break;
                        }
                        int a = leaugeGame(main, leagueone, club, personal);
                        if(a == 1)
                        {
                            System.out.println("\nYou have reached the next league! Your enemies will get harder now.\n");
                            for(int i = 0; i<leagueone.length; i++)
                            {
                                leagueone[i].resethealth();
                                leagueone[i].nextleauge();
                                leagueone[i].resethealth();
                                amateur.setwin(true);
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

                    }
                    else if(starter.getWon() == true && amateur.getWon() == true)
                    {
                        System.out.println("You have $" + personal.getBalance() + " in your account");
                        System.out.println("Press \"y\" to pay the pro league fee of " + pro.getEntryfee());
                        input.nextLine();
                        String enter = input.nextLine();

                        if(enter.equalsIgnoreCase("y"))
                        {
                            personal.subBalance(pro.getEntryfee());
                            personal.checkBankruptcy();
                            System.out.println("You now have $" + personal.getBalance()+ " in your personal account");
                            personal.addinflation();
                            System.out.println("Inflation has rose to " + personal.getInflation());
                        }
                        else
                        {
                            break;
                        }
                        int a = leaugeGame(main, leagueone, club, personal);
                        if(a == 1)
                        {
                            System.out.println("\nYou have reached the next league! Your enemies will get harder now.\n");
                            for(int i = 0; i<leagueone.length; i++)
                            {
                                leagueone[i].resethealth();
                                leagueone[i].nextleauge();
                                leagueone[i].resethealth();
                                pro.setwin(true);
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

                    }
                    else if(starter.getWon() == true && amateur.getWon() == true && pro.getWon() == true)
                    {
                        System.out.println("You have $" + personal.getBalance() + " in your account");
                        System.out.println("Press \"y\" to pay the champion league fee of " + champion.getEntryfee());
                        input.nextLine();
                        String enter = input.nextLine();

                        if(enter.equalsIgnoreCase("y"))
                        {
                            personal.subBalance(champion.getEntryfee());
                            personal.checkBankruptcy();
                            System.out.println("You now have $" + personal.getBalance()+ " in your personal account");
                            personal.addinflation();
                            System.out.println("Inflation has rose to " + personal.getInflation());
                        }
                        else
                        {
                            break;
                        }
                        int a = leaugeGame(main, leagueone, club, personal);
                        if(a == 1)
                        {
                            System.out.println("\nYou have reached the next league! Your enemies will get harder now.\n");
                            for(int i = 0; i<leagueone.length; i++)
                            {
                                leagueone[i].resethealth();
                                leagueone[i].nextleauge();
                                leagueone[i].resethealth();
                                champion.setwin(true);
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

                    }
                    else if(starter.getWon() == true && amateur.getWon() == true && pro.getWon() == true && champion.getWon() == true)
                    {
                        System.out.println("You have $" + personal.getBalance() + " in your account");
                        System.out.println("Press \"y\" to pay the legend league fee of " + legend.getEntryfee());
                        input.nextLine();
                        String enter = input.nextLine();

                        if(enter.equalsIgnoreCase("y"))
                        {
                            personal.subBalance(legend.getEntryfee());
                            personal.checkBankruptcy();
                            System.out.println("You now have $" + personal.getBalance()+ " in your personal account");
                            personal.addinflation();
                            System.out.println("Inflation has rose to " + personal.getInflation());
                        }
                        else
                        {
                            break;
                        }
                        int a = leaugeGame(main, leagueone, club, personal);
                        if(a == 1)
                        {
                            System.out.println("\nYou have reached the next league! Your enemies will get harder now.\n");
                            for(int i = 0; i<leagueone.length; i++)
                            {
                                leagueone[i].resethealth();
                                leagueone[i].nextleauge();
                                leagueone[i].resethealth();
                                legend.setwin(true);
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

                    }

                    break;
                case 2:
                    System.out.println("<<<Shop>>>");
                    shop(personal, inflation, main);
                    break;
                case 3:
                    System.out.println("Which Bank would you like to access?");
                    System.out.println("1) Personal\n2) Club");
                    int bc = input.nextInt();
                    if(bc == 1)
                    {
                        System.out.println("$"+personal.getBalance());
                    }
                    if(bc == 2)
                    {
                        System.out.println("$"+club.getBalance());
                    }
                    break;
                case 4:
                    System.out.println("<<<Stats>>>");
                    System.out.println("Name: " + main.getPlayerName());
                    System.out.println("Health: " + main.getPlayerHealth());
                    System.out.println("Damage: " + main.getPlayerDamage());
                    System.out.println();
                    break;
                case 5:
                    tutorial();
                case 6:
                    help();
                    break;
                case 7:
                    titlescreen();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Selection");
                    break;

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










    public static int leaugeGame(Charachter a, Charachter[] arr, Bank bank, Bank pbank)
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
                    bank.subBalance(25);
                    loose += 1;
                    end = true;
                    break;
                }
                if (arr[i].getFighthealth() <= 0) {
                    System.out.println("You win");
                    bank.addBalance(50);
                    pbank.addIr();
                    System.out.println("Your new club balance is " + bank.getBalance());
                    System.out.println("Your new personal balance is " + pbank.getBalance());
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
            bank.setBalance(0);
            return 2;
        }


    }

    public static void help()
    {
        System.out.println ("Help - Fight Club Rules:\n");
        System.out.println ("Welcome to the World's Largest Underground Fight Club, in order to leave a millionaire as promised you will have to understand concepts of INFLATION and\n");
        System.out.println ("COMPOUND INTEREST that will affect the money you make during your time here.\n");


        System.out.println ("Here are the rules of the Fight Club:\n");
        System.out.println ("Each fighter is assigned a Fight CLUB BANK ACCOUNT in addition to their PERSONAL BANK ACCOUNT. All of your upgrades and purchases will\n");
        System.out.println ("come directly out of your personal account while the money you make in matches will be handled in your Club account.\n");


        System.out.println ("In the Fight Club, there are different LEAGUES that each have different requirements, costs, and challenges.\n");
        System.out.println ("Each league will have 8 MATCHES and a certain number of WINS needed to move on to the next league. As you progress,\n");
        System.out.println ("you will have less room for error as the amount of wins needed will get closer to 8.\n");


        System.out.println ("Each league has an ENTRY FEE, and a LEAGUE WIN PERCENT of your personal account that is awarded as a fraction of this percentage after each win.\n");


        System.out.println ("For example, if the league has a percent of 20% and 4 wins are needed to win the league, 5% of the amount that was in your personal account at\n");
        System.out.println ("the start of the league (or the PRINCIPAL amount) will be deposited into your CLUB ACCOUNT after each win. This is practically SIMPLE INTEREST.\n");
        System.out.println ("However, during WIN STREAKS, this same percentage will be deposited, however the percentage will be taken from your PERSONAL account PRINCIPAL \n");
        System.out.println ("balance plus the amount you have earned in your fight CLUB ACCOUNT. Thus, creating a system of COMPOUND INTEREST, where you are earning interest\n");
        System.out.println ("on earned interest.\n");


        System.out.println ("In order to keep the World's Largest Underground Fight Club up and running, the owners have established a tax per match during your time here. I mean\n");
        System.out.println ("the bills aren't going to pay themselves...\n");
        System.out.println ("Due to this, each league has a certain INFLATION RATE that is applied to your PERSONAL account following each match, win or lose.\n");


        System.out.println ("Obviously you came here to make money so the inflation rate isn't going to be that large and you should be able to overcome it with your matches.\n");
        System.out.println ("However, after each loss in a league, the inflation rate will INCREASE by a certain percent (decided by each league) and during LOSING STREAKS, this inflation will be applied to both\n");
        System.out.println ("the balance in your PERSONAL account as well as your CLUB account.\n");


        System.out.println ("As mentioned, the money in your CLUB ACCOUNT is transferred to your PERSONAL ACCOUNT whether you win or lose the league.\n");
        System.out.println ("If you win the league, you will be promoted to the next league where you can visit the new leagues ITEM SHOP and STAFF HIRINGS\n");
        System.out.println ("prior to paying the ENTRY FEE. The amount remaining after the entry fee is paid is the PRINCIPAL amount for interest.\n");


        System.out.println ("If you lose the league, you will have to try again and enter the league as if it is a new one. You can visit the item shop and staff \n");
        System.out.println ("hirings again if there are any more remaining that haven't yet been purchased.\n");


        System.out.println ("If you end up losing more money to inflation than you gain from interest and can no longer afford the entry fee, your time at the\n");
        System.out.println ("Fight Club is over and you lose the game.\n");


        System.out.println ("Note that enemies will be getting stronger and items, staff, and entry fees are increasing as you progress through the leagues, so you\n");
        System.out.println ("should aim to leave each league with as much money as you possibly can.\n");
        System.out.println ("Good luck!\n");

    }

    public static void shop(Bank personal, double inflation, Charachter main)
    {
        Scanner scan= new Scanner(System.in);
        System.out.println("[Welcome to the Shop]\n" +
                "Upgrade your equipment to perform better in the ring!");
        System.out.println("Your current balance is $" + personal.getBalance());
        System.out.println("Please chose a category \n1) Gloves \n2) Shorts \n3) Shoes \n4) Exit");
        int itemMenu = scan.nextShort();
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



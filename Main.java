import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

  //opponenets array
        Charachter one = new Charachter("M. Tyson", 10, 0, 2,0);
        Charachter two = new Charachter("F. Mayweather", 11, 0, 2,0);
        Charachter three = new Charachter("J. Frazier", 12, 0, 2,0);
        Charachter four = new Charachter("G. Foreman", 13, 0, 2,0);
        Charachter five = new Charachter("R. Marciano", 15, 0, 3,0);
        Charachter six = new Charachter("H. Armstrong", 15, 0, 3,0);
        Charachter seven = new Charachter("SR. Robinson", 15, 0, 3,0);
        Charachter eight = new Charachter("M. Ali", 15, 0, 3,0);

        Charachter[] leagueone = {one,two,three,four,five,six,seven,eight};

      
    //tracker- matches, wins, league number
    int matchesPlayed = 0;
    int wins = 0;
    int leagueNum = 0;
    int[] tracker = { matchesPlayed, wins, leagueNum };

    //menu choices
    Print menu = new Print('m', tracker);
    Print league = new Print('l', tracker);
    Print help = new Print('h', tracker);
    Print[] option = { menu, league, help };

    //match results
    boolean matchWon, winStreak, loseStreak, leagueWon;
    matchWon = false;
    winStreak = false;
    loseStreak = false;
    leagueWon = false;

    boolean[] result = { matchWon, winStreak, loseStreak, leagueWon};
      
    //bank accounts
    Bank personal = new Bank("Personal", 'p', 550);
    Bank club = new Bank("Club", 'c', 0);
    Bank[] account = { personal, club };

    //leagues
    League starter = new League("Starter League", 50, 8, 3, 30, 5, 20);
    League amateur = new League("Amateur League", 100, 8, 4, 40, 10, 30);
    League pro = new League("Pro League", 150, 8, 5, 55, 25, 45);
    League champion = new League("Champion's League", 200, 8, 6, 70, 40, 65);
    League legend = new League("Legend's League", 250, 8, 7, 100, 60, 100);
    League[] level = { starter, amateur, pro, champion, legend };

//start of game

              titlescreen();
        System.out.println("\nIf you want to enter the Club we need your fighter name. Enter it below: ");

  //user character
        String name = input.nextLine();
        Charachter main = new Charachter(name);
      
        System.out.println("Welcome " + main.getPlayerName()+ "! Here are the rules to the fight club:");
      	System.out.println ("-------------------------------------------------------------------------------------------\n");
        boolean c = false;
      
      //initially printing out rules to user
    help.print(option, "rules");

      
    //loop for running leagues
    do {
    league.print(option, "intro", level, account, result, tracker);
        
        new Shop();

    //visit store
    //System.out.println("[Item Shop]");
    //System.out.println("Welcome to the Item Shop!"\n);
    //Shop(account);

    //league info printed after player exits shop
    league.print(option, "info", level, account, result, tracker);

    //running matches until league ends
    for (int i = 0; i < level[tracker[2]].get_numMatches(); i++) {
      tracker[0]++; //matchesPlayed + 1
      
      //run fight
      leaugeGame(main, leagueone, tracker, result);

      leagueone[tracker[0]-1].resethealth();
      leagueone[tracker[0]-1].nextleauge();
      leagueone[tracker[0]-1].resethealth();
      
      //return result[0 through 3]
      
      if (result[0] == true){
        //if matchWon == true
          tracker[1] ++; //wins + 1
      }

      //end of match text
      league.print(option, "postMatch", level, account, result, tracker);

      if (tracker[1] == level[tracker[2]].get_winsNeeded()){ //wins == winsNeeded
        //leaguewon = true
        result[3] = true;
        break;
      }
    }

    //end of league text
    league.print(option, "end", level, account, result, tracker);
      } while (tracker[2] <= 4);
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
        Charachter tut = new Charachter("Player", 15, 0, 2,3);
        Charachter tute = new Charachter("Tutorial", 15, 0, 2,3);
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
        System.out.println("Player Health: " + tut.getFighthealth() + "            Opponents Health: " + tute.getFighthealth());
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
                System.out.println("Player Health: " + tut.getFighthealth() + "            Opponents Health: " + tute.getFighthealth());
            }
            else if(pc == 1 && oc == 2)
            {
                System.out.println("Opponent dodged your attack and countered!");
                tut.getHit(tute.getPlayerDamage());
                System.out.println("Player Health: " + tut.getFighthealth() + "            Opponents Health: " + tute.getFighthealth());
            }
            else if(pc == 1 && oc == 3)
            {
                System.out.println("You Hit while opponent was resting!");
                tute.getHit(tut.getPlayerDamage());
                System.out.println("Player Health: " + tut.getFighthealth() + "            Opponents Health: " + tute.getFighthealth());
            }
            else if(pc == 2 && oc == 1)
            {
                System.out.println("You dodged your opponents attack and countered!");
                tute.getHit(tut.getPlayerDamage());
                System.out.println("Player Health: " + tut.getFighthealth() + "            Opponents Health: " + tute.getFighthealth());
            }
            else if(pc == 2 && oc == 2 )
            {
                System.out.println("Both Dodged!");
                System.out.println("Player Health: " + tut.getFighthealth() + "            Opponents Health: " + tute.getFighthealth());
            }
            else if(pc == 2 && oc == 3)
            {
                System.out.println("Opponent Rested!");
                tute.rest();
                System.out.println("Player Health: " + tut.getFighthealth() + "            Opponents Health: " + tute.getFighthealth());
            }
            else if(pc == 3 && oc == 1)
            {
                System.out.println("Opponent Hit while you were resting!");
                tut.getHit(tute.getPlayerDamage());
                System.out.println("Player Health: " + tut.getFighthealth() + "            Opponents Health: " + tute.getFighthealth());
            }
            else if(pc == 3 && oc == 2)
            {
                System.out.println("You Rested!");
                tut.rest();
                System.out.println("Player Health: " + tut.getFighthealth() + "            Opponents Health: " + tute.getFighthealth());
            }
            else if(pc == 3 && oc == 3)
            {
                System.out.println("Both Rested");
                tut.rest();
                tute.rest();
                System.out.println("Player Health: " + tut.getFighthealth() + "            Opponents Health: " + tute.getFighthealth());
            }



            if(tut.getFighthealth() <= 0)
            {
                System.out.println("You got Knocked Out");
                System.out.println("Tutorial Over");
                end = true;
                break;
            }
            if(tute.getFighthealth() <= 0)
            {
                System.out.println("You win");
                end = true;
                break;
            }

        }while(end == false);
    }










    public static void leaugeGame(Charachter a, Charachter[] arr, int[] track, boolean[] res)
    {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
      
            a.resethealth();
            System.out.println("Fight " + (track[0]));
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
                    "       |  |   |  |      -"+a.getPlayerName()+"-                                    |  |   |  |      -" + arr[track[0] - 1].getPlayerName() + "-                                                                   \n" +
                    "       |  |   |  |                                                  |  |   |  |                                                                      \n" +
                    "      /   )   (   \\                                                /   )   (   \\                                                                     \n" +
                    "     Ooooo     ooooO                                              Ooooo     ooooO                                                               \n" +
                    "\n");
            System.out.println("Player Health: " + a.getFighthealth() + "            Opponents Health: " + arr[track[0] - 1].getFighthealth());
            boolean end = false;
            do {

                System.out.println("Options: ");
                System.out.println("1)Hit \n2)Dodge\n3)Rest");
                int pc = input.nextInt();
                int oc = (int) (Math.random() * (4 - 1)) + 1;
                System.out.println(oc);

                if (pc == 1 && oc == 1) {
                    System.out.println("Both Hit!");
                    a.getHit(arr[track[0] - 1].getPlayerDamage());
                    arr[track[0] - 1].getHit(a.getPlayerDamage());
                    System.out.println("Player Health: " + a.getFighthealth() + "            Opponents Health: " + arr[track[0] - 1].getFighthealth());
                } else if (pc == 1 && oc == 2) {
                    System.out.println("Opponent dodged your attack and countered!");
                    a.getHit(arr[track[0] - 1].getPlayerDamage());
                    System.out.println("Player Health: " + a.getFighthealth() + "            Opponents Health: " + arr[track[0] - 1].getFighthealth());
                } else if (pc == 1 && oc == 3) {
                    System.out.println("You Hit while opponent was resting!");
                    arr[track[0] - 1].getHit(a.getPlayerDamage());
                    System.out.println("Player Health: " + a.getFighthealth() + "            Opponents Health: " + arr[track[0] - 1].getFighthealth());
                } else if (pc == 2 && oc == 1) {

                    if(a.getFightstamina() <= 0)
                    {
                        System.out.println("You are out of stamina. Dodge Failed");
                        a.getHit(arr[track[0] - 1].getPlayerDamage());
                        System.out.println("Player Health: " + a.getFighthealth() + "            Opponents Health: " + arr[track[0] - 1].getFighthealth());
                    }
                    else {
                        a.decFightStamina(1);
                        System.out.println("You dodged your opponents attack and countered!");
                        arr[track[0] - 1].getHit(a.getPlayerDamage());
                        System.out.println("Player Health: " + a.getFighthealth() + "            Opponents Health: " + arr[track[0] - 1].getFighthealth());
                    }

                } else if (pc == 2 && oc == 2) {
                    System.out.println("Both Dodged!");
                    System.out.println("Player Health: " + a.getFighthealth() + "            Opponents Health: " + arr[track[0] - 1].getFighthealth());
                } else if (pc == 2 && oc == 3) {
                    System.out.println("Opponent Rested!");
                    arr[track[0] - 1].rest();
                    System.out.println("Player Health: " + a.getFighthealth() + "            Opponents Health: " + arr[track[0] - 1].getFighthealth());
                } else if (pc == 3 && oc == 1) {
                    System.out.println("Opponent Hit while you were resting!");
                    a.getHit(arr[track[0] - 1].getPlayerDamage());
                    System.out.println("Player Health: " + a.getFighthealth() + "            Opponents Health: " + arr[track[0] - 1].getPlayerHealth());
                } else if (pc == 3 && oc == 2) {
                    System.out.println("You Rested!");
                    a.rest();
                    System.out.println("Player Health: " + a.getFighthealth() + "            Opponents Health: " + arr[track[0] - 1].getFighthealth());
                } else if (pc == 3 && oc == 3) {
                    System.out.println("Both Rested");
                    a.rest();
                    arr[track[0] - 1].rest();
                    System.out.println("Player Health: " + a.getFighthealth()+ "            Opponents Health: " + arr[track[0] - 1].getFighthealth());
                }


                if (a.getFighthealth() <= 0) {
                    System.out.println("You got Knocked Out");
                  a.resetStamina();
                  //checking for lose streak
                  if (track[0] > 1 && res[0] == false){
                    res[0] = false;
                    res[1] = false;
                    res[2] = true;
                  }
                  else {
                    res[0] = false;
                    res[1] = false;
                  }
                    end = true;
                    break;
                }
              
                if (arr[track[0] - 1].getFighthealth() <= 0) {
                    System.out.println("You win");
                    a.resetStamina();
                  //checking for win streak
                  if (track[0] > 1 && res[0] == true){
                    res[0] = true;
                    res[1] = true;
                    res[2] = false;
                  }
                  else{
                    res[0] = true;
                    res[2] = false;
                  }
                    end = true;
                    break;
                }
              
            } while (end == false);
      }
      
  /* public static void shop(Bank personal, double inflation, Charachter main)
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

*/

}


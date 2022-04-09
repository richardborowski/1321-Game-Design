public class Main
{
    public static void main(String[] args)
    {
        
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

    //initially printing out rules to user
    help.print(option, "rules");


    //start of the fight club game
    //bank accounts
    Bank personal = new Bank("Personal", 'p', 100);
    Bank club = new Bank("Club", 'c', 0);
    Bank[] account = { personal, club };

    //leagues
    League starter = new League("Starter League", 50, 8, 3, 30, 2, 20);
    League amateur = new League("Amateur League", 50, 8, 4, 40, 10, 30);
    League pro = new League("Pro League", 150, 8, 5, 50, 20, 45);
    League champion = new League("Champion's League", 200, 8, 6, 60, 30, 65);
    League legend = new League("Legend's League", 250, 8, 7, 70, 50, 100);
    League[] level = { starter, amateur, pro, champion, legend };

    
    //loop for running league
    do {
    league.print(option, "intro", level, account, result, tracker);
    //upgrades, store, and shop will be here. 
        shop();

    //league info printed after player exits shop
    league.print(option, "info", level, account, result, tracker);

    //running matches until league ends
    for (int i = 0; i < level[tracker[2]].get_numMatches(); i++) {
      tracker[0]++; //matchesPlayed + 1
      
      //run fight
      //return result[0 through 3]
        result[0] = true;
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
      }while (tracker[2] <= 4);
    
    }
}

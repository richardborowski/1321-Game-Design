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
    leagueWon = true;

    boolean[] result = { matchWon, winStreak, loseStreak, leagueWon};

    help.print(option, "rules");


    //start of the fight club game
    //bank accounts
    Bank personal = new Bank("Personal", 'p', 100);
    Bank club = new Bank("Club", 'c', 0);
    Bank[] account = { personal, club };

    //leagues
    League starter = new League("Starter League", 50, 8, 3, 30, 2, 20);
    League amateur = new League("Amateur League", 100, 8, 4, 40, 10, 30);
    League pro = new League("Pro League", 150, 8, 5, 50, 20, 45);
    League champion = new League("Champion's League", 200, 8, 6, 60, 30, 65);
    League legend = new League("Legend's League", 250, 8, 7, 70, 50, 100);
    League[] level = { starter, amateur, pro, champion, legend };

    //demo starter league
    
    do {
    league.print(option, "intro", level, account, result, tracker);
    //upgrades, store, and shop will be here. 

    //if bool exitedShop/takePrincipal == true;
    league.print(option, "info", level, account, result, tracker);

    //first match happens, won.
    result[0] = true;
    result[1] = false;
    result[2] = false;
    tracker[0] = 1;
    tracker[1] = 1;
    league.print(option, "postMatch", level, account, result, tracker);


    //second match happens, won.
    result[0] = true;
    result[1] = true;
    result[2] = false;
    tracker[0] = 2;
    tracker[1] = 2;
    league.print(option, "postMatch", level, account, result, tracker);

    //third match happens, lost.
    result[0] = false;
    result[1] = false;
    result[2] = false;
    tracker[0] = 3;
    tracker[1] = 2;
    league.print(option, "postMatch", level, account, result, tracker);

    //fourth match happens, lost.
    result[0] = false;
    result[1] = false;
    result[2] = true;
    tracker[0] = 4;
    tracker[1] = 2;
    league.print(option, "postMatch", level, account, result, tracker);

    //fifth match happens, won. League won.
    result[0] = true;
    result[1] = false;
    result[2] = false;
    result[3] = true;
    tracker[0] = 4;
    tracker[1] = 3;
    league.print(option, "postMatch", level, account, result, tracker);

    //if bool leagueEnd = true
    league.print(option, "end", level, account, result, tracker);
      }while (tracker[2] <= 5);
    
    }
}
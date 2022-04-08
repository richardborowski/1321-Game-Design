#include <iostream>
#include <iomanip>
#define fix(x) std::fixed <<std::setprecision(2)<<(x) 
#include <string>
#include "League.h"
#include "Bank.h"
#include "Print.h"
using namespace std;

int main()
{
    //tracker- matches, wins, league number
    int matchesPlayed = 0;
    int wins = 0;
    int leagueNum = 0;
    int tracker[3] = {  matchesPlayed, wins, leagueNum };

    //menu choices
    Print menu('m', tracker);
    Print league('l', tracker);
    Print help('h', tracker);
    Print option[3] = { menu, league, help };

    //match results
    bool matchWon, winStreak, loseStreak, leagueWon;
    matchWon = false;
    winStreak = false;
    loseStreak = false;
    leagueWon = false;

    bool result[4] = { matchWon, winStreak, loseStreak, leagueWon};

    //help.print(option, "rules");


    //start of the fight club game
    //bank accounts
    Bank personal("Personal", 'p', 100);
    Bank club("Club", 'c', 0);
    Bank account[2] = { personal, club };

    //leagues
    League starter("Starter League", 10, 8, 3, 50, 1, 10);
    League amateur("Amateur League", 35, 8, 4, 75, 5, 20);
    League pro("Pro League", 50, 8, 5, 100, 20, 45);
    League champion("Champion's League", 100, 8, 6, 150, 30, 65);
    League legend("Legend's League", 150, 8, 7, 200, 50, 100);
    League level[5] = { starter, amateur, pro, champion, legend };

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

    } while (tracker[2] != 5);
}



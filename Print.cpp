#include "Print.h"
#include "Bank.h"
#include "League.h"
#include <stdlib.h>
#include <iostream>
#include <string>
#include <iomanip>
#define fix(x) std::fixed << std::setprecision(2)<<(x)

Print::Print() {
	printType = ' ';
	subType = "";

}

Print::Print(char type) {
	printType = type;
	leagueWon = false;
}


//m = menu
//l = league
//e = exit
//h = help

//strictly for printing out text 
void Print::print(Print opt[], int m, int l, int h)
{
	//menu
	int menuOption, helpOption;
	char exitOption;
	
	do {
		if (printType = 'm')
		{
			std::cout << "[Main Menu]\n";
			std::cout << "1) Help\n";
			std::cout << "2) Exit Game\n";
			std::cout << "3) Return to Game\n\n";

			do {
				std::cout << "Choose an option: ";
				std::cin >> menuOption;
				std::cout << std::endl;
			} while (menuOption != 1 && menuOption != 2 && menuOption != 3);

			//help
			if (menuOption == 1)
			{
				std::cout << "[Help]\n";
				std::cout << "What do you need help with?\n";
				std::cout << "1) Rules\n"; //help.print(rules)
				std::cout << "2) Fighting\n"; //help.print(fighting);
				do {
					std::cout << "Choose an option: ";
					std::cin >> helpOption;
					std::cout << "-------------------------------------------------------------------------------------------\n\n";
				} while (helpOption != 1 && helpOption != 2);

				switch (helpOption) {
				case 1:
					opt[h].print(opt, "rules");
					break;
				case 2:
					//fighting help
					std::cout << "fighting help";
					break;
				}
			}

			//exit
			else if (menuOption == 2)
			{
				std::cout << "[Exit Game]\n";
				do {
					std::cout << "Are you sure you want to exit? (Y/N)\n";
					std::cin >> exitOption;
				} while (exitOption != 'Y' && menuOption != 'N');

				switch (exitOption) {
				case 'Y':
					std::cout << "Goodbye!\n";
					exit(0);
					break;
				case 'N':
					break;
				}
				std::cout << "-------------------------------------------------------------------------------------------\n\n";

			}

			//return
			else if (menuOption == 3) {
				std::cin.ignore();
			}
		}
	} while (menuOption != 3);
}


void Print::enter(Print opt[])
{
	do {
		std::cout << "\nPress enter to continue\n";
		std::cout << "Press m for the main menu\n";
		std::cout << "-------------------------------------------------------------------------------------------\n";
		press = std::cin.get();

		if (press == '\n') {
		}
		else if (press == 'm') {
			std::cout << std::endl;
			opt[0].print(opt, 0, 1, 2);
		}
	} while (press != '\n' && press != 'm');
}

void Print::print(Print opt[], std::string subType)
{
	if (printType == 'h' && subType == "rules") {
		std::cout << "Help - Fight Club Rules:\n";
		std::cout << "Welcome to the World's Largest Underground Fight Club, in order to leave a millionaire as promised you will have to understand concepts of INFLATION and\n";
		std::cout << "COMPOUND INTEREST that will affect the money you make during your time here.\n";
		std::cin.ignore();

		std::cout << "Here are the rules of the Fight Club:\n";
		std::cout << "Each fighter is assigned a Fight CLUB BANK ACCOUNT in addition to their PERSONAL BANK ACCOUNT. All of your upgrades and purchases will\n";
		std::cout << "come directly out of your personal account while the money you make in matches will be handled in your Club account.\n";
		std::cin.ignore();

		std::cout << "In the Fight Club, there are different LEAGUES that each have different requirements, costs, and challenges.\n";
		std::cout << "Each league will have 8 MATCHES and a certain number of WINS needed to move on to the next league. As you progress,\n";
		std::cout << "you will have less room for error as the amount of wins needed will get closer to 8.\n";
		std::cin.ignore();

		std::cout << "Each league has an ENTRY FEE, and a LEAGUE WIN PERCENT of your personal account that is awarded as a fraction of this percentage after each win.\n";
		std::cin.ignore();

		std::cout << "For example, if the league has a percent of 20% and 4 wins are needed to win the league, 5% of the amount that was in your personal account at\n";
		std::cout << "the start of the league (or the PRINCIPAL amount) will be deposited into your CLUB ACCOUNT after each win. This is practically SIMPLE INTEREST.\n";
		std::cout << "However, during WIN STREAKS, this same percentage will be deposited, however the percentage will be taken from your PERSONAL account PRINCIPAL \n";
		std::cout << "balance plus the amount you have earned in your fight CLUB ACCOUNT. Thus, creating a system of COMPOUND INTEREST, where you are earning interest\n";
		std::cout << "on earned interest.\n";
		std::cin.ignore();

		std::cout << "In order to keep the World's Largest Underground Fight Club up and running, the owners have established a tax per match during your time here. I mean\n";
		std::cout << "the bills aren't going to pay themselves...\n";
		std::cout << "Due to this, each league has a certain INFLATION RATE that is applied to your PERSONAL account following each match, win or lose.\n";
		std::cin.ignore();

		std::cout << "Obviously you came here to make money so the inflation rate isn't going to be that large and you should be able to overcome it with your matches.\n";
		std::cout << "However, after each loss in a league, the inflation rate will INCREASE by a certain percent (decided by each league) and during LOSING STREAKS, this inflation will be applied to both\n";
		std::cout << "the balance in your PERSONAL account as well as your CLUB account.\n";
		std::cin.ignore();

		std::cout << "As mentioned, the money in your CLUB ACCOUNT is transferred to your PERSONAL ACCOUNT whether you win or lose the league.\n";
		std::cout << "If you win the league, you will be promoted to the next league where you can visit the new leagues ITEM SHOP and STAFF HIRINGS\n";
		std::cout << "prior to paying the ENTRY FEE. The amount remaining after the entry fee is paid is the PRINCIPAL amount for interest.\n";
		std::cin.ignore();

		std::cout << "If you lose the league, you will have to try again and enter the league as if it is a new one. You can visit the item shop and staff \n";
		std::cout << "hirings again if there are any more remaining that haven't yet been purchased.\n";
		std::cin.ignore();

		std::cout << "If you end up losing more money to inflation than you gain from interest and can no longer afford the entry fee, your time at the\n";
		std::cout << "Fight Club is over and you lose the game.\n";
		std::cin.ignore();

		std::cout << "Note that enemies will be getting stronger and items, staff, and entry fees are increasing as you progress through the leagues, so you\n";
		std::cout << "should aim to leave each league with as much money as you possibly can.\n";
		std::cout << "Good luck!\n";

		opt[0].enter(opt);
	}
}


void Print::print(Print opt[], std::string subType, League lev[], int l, Bank acc[], int p, int c)
{
	//league intro
	if (printType == 'l' && subType == "intro")
	{

		std::cout << "Welcome to the " << lev[l].get_name() << "!\n";
		std::cout << "The entry fee for this league is $" << lev[l].get_entryFee() << std::endl;
		std::cout << "You currently have $" << acc[p].get_balance() << " available in your personal account\n";
		std::cout << std::endl << "Press enter to pay the entry fee\n";
		std::cout << "-------------------------------------------------------------------------------------------\n";
		std::cin.ignore();

		acc[p].set_balance('w', lev[l].get_entryFee());
		std::cout << "New Personal Balance: $" << acc[p].get_balance() << std::endl;
	}

	//league info
	if (printType == 'l' && subType == "info")
	{
		acc[p].set_principal(true);
		std::cout << "Here is the informaton for the " << lev[l].get_name() << ":\n";
		std::cout << "Matches: " << lev[l].get_numMatches() << std::endl;
		std::cout << "Wins Needed: " << lev[l].get_winsNeeded() << std::endl << std::endl;

		std::cout << "League Win Percentage Reward: " << lev[l].get_leaguePct() << "%" << std::endl;
		std::cout << "Percent Paid Per Win: " << lev[l].get_winPct() << "%" << std::endl;
		std::cout << "Your personal account's principal: $" << acc[p].get_principal() << std::endl;
		std::cout << "Percent personal balance lost after each match to inflation: " << lev[l].get_matchInflationPct() << "%" << std::endl;
		std::cout << "Percent-Increase on inflation per loss: " << lev[l].get_inflationPctAdded() << "%" << std::endl;


		opt[0].enter(opt);
	}

	//league end
	if (printType == 'l' && subType == "end") 
	{
		std::cout << "The " << lev[l].get_name() << " has concluded.\n";

		if (leagueWon == false) {
			std::cout << "You did not beat the league, therefore you will have to try the " << lev[l].get_name() << " again." << std::endl;
		}
		else if (leagueWon == true) {
			std::cout << "You beat the " << lev[l].get_name() << " and are now moving on to the next league." << std::endl << std::endl;
		}

		std::cout << "All money in your club account will now be transferred into your personal account:\n";

		acc[p].set_balance('d', acc[c].get_balance());
		std::cout << "New Personal Balance: $" << acc[p].get_balance() << std::endl;

		opt[0].enter(opt);
	}
}


void Print::print(Print opt[], std::string subType, League lev[], int l, Bank acc[], int p, int c, int wins, int matchesPlayed, bool matchWon, bool winStreak, bool loseStreak)
{

	//league post match
	if (printType == 'l' && subType == "postMatch")
	{
		//won league
		if (wins == lev[l].get_winsNeeded())
		{
			leagueWon = true;
			std::cout << "Congratulations! You have won " << lev[l].get_winsNeeded() << " matches and beat the " << lev[l].get_name() << "!" << std::endl;

			lev[l].set_winDeposit(acc, p);
			lev[l].set_streakDeposit(acc, p, c);
			lev[l].set_postMatchWithdraw(acc, p);
			lev[l].set_streakClubWithdraw(loseStreak, acc, c);

			std::cout << lev[l].get_matchInflationPct() << "% of your personal account has been withdrawn" << std::endl;
			std::cout << "$" << lev[l].get_winDeposit() << " has been deposited into your club account" << std::endl << std::endl;

			acc[p].set_balance(lev, l, matchWon, winStreak, loseStreak);
			std::cout << "New Personal Balance: $" << acc[p].get_balance() << std::endl;

			acc[c].set_balance(lev, l, matchWon, winStreak, loseStreak);
			std::cout << "New Club Balance: $" << acc[c].get_balance() << std::endl;

			opt[0].enter(opt);
		}

		//won no streak
		else if (matchWon == true && winStreak == false)
		{
			std::cout << "Congrats on the win!" << std::endl;
			std::cout << "You now have " << wins << "/" << lev[l].get_winsNeeded() << " wins needed to beat the league." << std::endl;
			std::cout << "There are " << lev[l].get_numMatches() - matchesPlayed << " matches remaining." << std::endl << std::endl;

			lev[l].set_winDeposit(acc, p);
			lev[l].set_streakDeposit(acc, p, c);
			lev[l].set_postMatchWithdraw(acc, p);
			lev[l].set_streakClubWithdraw(loseStreak, acc, c);

			std::cout << lev[l].get_matchInflationPct() << "% of your personal account has been withdrawn due to inflation." << std::endl;
			std::cout << "$" << lev[l].get_winDeposit() << " has been deposited into your club account for the win." << std::endl << std::endl;

			acc[p].set_balance(lev, l, matchWon, winStreak, loseStreak);
			std::cout << "New Personal Balance: $" << fix(acc[p].get_balance()) << std::endl;

			acc[c].set_balance(lev, l, matchWon, winStreak, loseStreak);
			std::cout << "New Club Balance: $" << fix(acc[c].get_balance()) << std::endl;

			opt[0].enter(opt);
		}

		//won with streak
		else if (matchWon == true && winStreak == true)
		{
			std::cout << "Congrats on the win!" << std::endl;
			std::cout << "You now have " << wins << "/" << lev[l].get_winsNeeded() << " wins needed to beat the league." << std::endl;
			std::cout << "There are " << lev[l].get_numMatches() - matchesPlayed << " matches remaining." << std::endl << std::endl;
			std::cout << "You're on a win streak!\n";
			std::cout << "Your club balance will be added to your personal account's principal for the " << lev[l].get_winPct() << "% win deposit\n";

			lev[l].set_winDeposit(acc, p);
			lev[l].set_streakDeposit(acc, p, c);
			lev[l].set_postMatchWithdraw(acc, p);
			lev[l].set_streakClubWithdraw(loseStreak, acc, c);

			std::cout << std::endl << lev[l].get_matchInflationPct() << "% of your personal account has been withdrawn" << std::endl;
			std::cout << "$" << lev[l].get_streakDeposit() << " has been deposited into your club account" << std::endl << std::endl;

			acc[p].set_balance(lev, l, matchWon, winStreak, loseStreak);
			std::cout << "New Personal Balance: $" << acc[p].get_balance() << std::endl;

			acc[c].set_balance(lev, l, matchWon, winStreak, loseStreak);
			std::cout << "New Club Balance: $" << acc[c].get_balance() << std::endl;

			opt[0].enter(opt);
		}

		//lose no streak
		else if (matchWon == false && loseStreak == false)
		{
			std::cout << "You lost the match! Bummer..." << std::endl;
			std::cout << "You have " << wins << "/" << lev[l].get_winsNeeded() << " wins needed to beat the league." << std::endl;
			std::cout << "There are " << lev[l].get_numMatches() - matchesPlayed << " matches remaining." << std::endl << std::endl;

			lev[l].set_inflationPctAdded();
			lev[l].set_matchInflationPct();
			std::cout << lev[l].get_inflationPctAdded() << "% has been added to the inflation on your personal account and is now " << lev[l].get_matchInflationPct() << "%";
			std::cout << std::endl << std::endl;

			std::cout << lev[l].get_matchInflationPct() << "% of your personal account has been withdrawn" << std::endl << std::endl;

			lev[l].set_winDeposit(acc, p);
			lev[l].set_streakDeposit(acc, p, c);
			lev[l].set_postMatchWithdraw(acc, p);
			lev[l].set_streakClubWithdraw(loseStreak, acc, c);

			acc[p].set_balance(lev, l, matchWon, winStreak, loseStreak);
			std::cout << "New Personal Balance: $" << acc[p].get_balance() << std::endl;

			acc[c].set_balance(lev, l, matchWon, winStreak, loseStreak);
			std::cout << "New Club Balance: $" << acc[c].get_balance() << std::endl;

			opt[0].enter(opt);
		}


		//lose with streak
		else if (matchWon == false && loseStreak == true)
		{
		std::cout << "You lost the match! Bummer..." << std::endl;
		std::cout << "You have " << wins << "/" << lev[l].get_winsNeeded() << " wins needed to beat the league." << std::endl;
		std::cout << "There are " << lev[l].get_numMatches() - matchesPlayed << " matches remaining." << std::endl << std::endl;

		lev[l].set_inflationPctAdded();
		lev[l].set_matchInflationPct();

		lev[l].set_winDeposit(acc, p);
		lev[l].set_streakDeposit(acc, p, c);
		lev[l].set_postMatchWithdraw(acc, p);
		lev[l].set_streakClubWithdraw(loseStreak, acc, c);

		std::cout << lev[l].get_inflationPctAdded() << "% has been added to the inflation on your personal account and is now " << lev[l].get_matchInflationPct() << "%" << std::endl;
		std::cout << "This inflation will also be applied to your club account due to the losing streak" << std::endl;
		std::cout << std::endl;

		std::cout << lev[l].get_matchInflationPct() << "% of your personal account has been withdrawn" << std::endl;
		std::cout << lev[l].get_matchInflationPct() << "% of your club account has been withdrawn" << std::endl;

		acc[p].set_balance(lev, l, matchWon, winStreak, loseStreak);
		std::cout << "New Personal Balance: $" << acc[p].get_balance() << std::endl;

		acc[c].set_balance(lev, l, matchWon, winStreak, loseStreak);
		std::cout << "New Club Balance: $" << acc[c].get_balance() << std::endl;

		opt[0].enter(opt);
		}
	}
}


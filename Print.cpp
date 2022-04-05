#include "Print.h"
#include "Bank.h"
#include "League.h"
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

}


//m = menu
//l = league
//e = exit
//h = help
//t = tutorial

//strictly for printing out text 
void Print::print() 
{
	//menu
	int menuOption, helpOption, tutorialOption;
	char exitOption;
	if (printType = 'm') 
	{
		std::cout << std::endl << "\n-------------------------------------------------------------------------------------------\n";
		std::cout << "[Main Menu]\n";
		std::cout << "1) Help\n";
		std::cout << "2) Tutorial\n";
		std::cout << "3) View League Information\n";
		std::cout << "4) Exit Game\n\n";
		//do while
		std::cout << "Choose an option: ";
		std::cin >> menuOption;
		std::cout << std::endl;

		//help
		if (menuOption == 1) 
		{ 
			std::cout << "[Help]\n";
			std::cout << "What do you need help with?\n";
			std::cout << "1) Rules\n"; //help.print(rules)
			std::cout << "2) Fighting\n"; //help.print(fighting)
			std::cout << "3) Help\n\n";
			//do while
			std::cout << "Choose an option: ";
			std::cin >> helpOption;
			std::cout << "\n-------------------------------------------------------------------------------------------\n";

			//help switch
		}

		//tutorial
		else if (menuOption == 2)
		{
			std::cout << "[Tutorial]\n";
			std::cout << "What tutorial would you like to see?\n";
			std::cout << "1) Fight\n"; //tutorial.print(fight)
			std::cout << "2) Bank\n"; //tutorial.print(Bank)
			std::cout << "3) League\n\n"; //tutorial.print(League)
			//do while
			std::cout << "Choose an option: ";
			std::cin >> helpOption;
			std::cout << std::endl;

			std::cout << "\n-------------------------------------------------------------------------------------------\n"; 
			
			//tutorial switch
		}

		//league info
		else if (menuOption == 3)
		{
			std::cout << "[League Info]\n";
			std::cout << "Here is the info for your current league:\n";
			std::cout << "League Information\n\n"; //league.print(info)
			std::cin.ignore();
			std::cout << "\n-------------------------------------------------------------------------------------------\n";

		}

		//exit
		else if (menuOption == 4)
		{
			std::cout << "[Exit Game]\n";
			std::cout << "Are you sure you want to exit? (Y/N)\n";
			std::cin >> exitOption;

			//exit switch
			std::cout << "\n-------------------------------------------------------------------------------------------\n";

		}
	}
}


void Print::print(std::string subType, League lev[], int l, Bank acc[], int p, int c)
{
	//league intro
	if (printType == 'l' && subType == "intro") 
	{
		std::cout << "Welcome to the " << lev[l].get_name() << "!\n";
		std::cout << "The entry fee for this league is $" << lev[l].get_entryFee() << std::endl;
		std::cout << "You currently have $" << acc[p].get_balance() << " available in your personal account\n";
		std::cout << std::endl << "Press enter to pay the entry fee\n";
		std::cin.ignore();

		acc[p].set_balance('w', lev[l].get_entryFee());
		std::cout << "-------------------------------------------------------------------------------------------\n";
		std::cout << "New Personal Balance: $" << acc[p].get_balance() << std::endl << std::endl;
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


		std::cout << std::endl << "Press enter to continue\n";
		std::cin.ignore();
		std::cout << "-------------------------------------------------------------------------------------------\n";
		
	}

	//league post match
	if (printType == 'l' && subType == "postMatch")
	{
		//won no streak
		bool matchWon = true, winStreak = false, loseStreak = false;
		int wins = 1;

		if (matchWon == true && winStreak == false)
		{
			std::cout << "Congrats on the win!" << std::endl;
			std::cout << "You now have " << wins << "/" << lev[l].get_winsNeeded() << " wins needed to beat the league." << std::endl;
			lev[l].set_winDeposit(acc, p);
			lev[l].set_streakDeposit(acc, p, c);
			lev[l].set_postMatchWithdraw(acc, p);
			lev[l].set_streakClubWithdraw(false, acc, c);

			std::cout << lev[l].get_matchInflationPct() << "% of your personal account has been withdrawn due to inflation." << std::endl;
			std::cout << "$" << lev[l].get_winDeposit() << " has been deposited into your club account for the win." << std::endl << std::endl;

			acc[p].set_balance(lev, l, true, false, false);
			std::cout << "New Personal Balance: $" << fix(acc[p].get_balance()) << std::endl;

			acc[c].set_balance(lev, l, true, false, false);
			std::cout << "New Club Balance: $" << fix(acc[c].get_balance()) << std::endl;

			std::cout << std::endl << "Press enter to continue\n";
			std::cin.ignore();
			std::cout << "-------------------------------------------------------------------------------------------\n";
		}

		//won with streak
		 matchWon = true, winStreak = true, loseStreak = false;
		wins = 2;
		
		//elseif 
		if (matchWon == true && winStreak == true)
		{
			std::cout << "Congrats on the win!" << std::endl;
			std::cout << "You now have " << wins << "/" << lev[l].get_winsNeeded() << " wins needed to beat the league." << std::endl;
			std::cout << "You're on a win streak!\n";
			std::cout << "Your club balance will be added to your personal account's principal for the " << lev[l].get_winPct() << "% win deposit\n";
			lev[l].set_winDeposit(acc, p);
			lev[l].set_streakDeposit(acc, p, c);
			lev[l].set_postMatchWithdraw(acc, p);
			lev[l].set_streakClubWithdraw(false, acc, c);

			std::cout << std::endl << lev[l].get_matchInflationPct() << "% of your personal account has been withdrawn" << std::endl;
			std::cout << "$" << lev[l].get_streakDeposit() << " has been deposited into your club account" << std::endl << std::endl;

			acc[p].set_balance(lev, l, true, true, false);
			std::cout << "New Personal Balance: $" << acc[p].get_balance() << std::endl;

			acc[c].set_balance(lev, l, true, true, false);
			std::cout << "New Club Balance: $" << acc[c].get_balance() << std::endl;

			std::cout << std::endl << "Press enter to continue\n";
			std::cin.ignore();
			std::cout << "-------------------------------------------------------------------------------------------\n";
		}
	}
}


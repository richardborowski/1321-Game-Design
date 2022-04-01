#include "League.h"
#include "Bank.h"
#include <iostream>
#include <string>

Bank personal("Personal", 'p', 0);
Bank club("Club", 'c', 0);

League::League() {
	leagueName = "";
	entryFee = 0;
	numberOfMatches = 0;
	winsNeeded = 0;

	leagueWinPct = 0.0;
	winDepositPct = 0;
	wD = 0.0;
	perWinDeposit = 0;
	perStreakDeposit = 0;

	matchInflationPct = 0.0;
	inflationPctAdded = 0.0;
	iPA = 0.0;
	postMatchWithdraw = 0;
	streakClubWithdraw = 0;
}


League::League(std::string n, int e, int m, int w, float lP, float iP) {
	leagueName = n;
	entryFee = e;
	numberOfMatches = m;
	winsNeeded = w;

	leagueWinPct = lP;
	winDepositPct = lP / w;
	wD = winDepositPct;
	perWinDeposit = (wD / 100) * personal.get_principal();
	perStreakDeposit = (wD / 100) * (personal.get_principal() + club.get_balance());

	matchInflationPct = iP;
	inflationPctAdded = 0;
	iPA;
	postMatchWithdraw = ((iP + iPA) / 100) * personal.get_balance();
	streakClubWithdraw = ((iP + iPA) / 100) * club.get_balance();

}


void League::set_name(std::string n) {
	leagueName = n;

}

std::string League::get_name() {
	return leagueName;

}


void League::set_entryFee(int e) {
	entryFee = e;

}

int League::get_entryFee() {
	return entryFee;

}


void League::set_numMatches(int m) {
	numberOfMatches = m;

}

int League::get_numMatches() {
	return numberOfMatches;

}


void League::set_winsNeeded(int w) {
	winsNeeded = w;

}

int League::get_winsNeeded() {
	return winsNeeded;

}


void League::set_leaguePct(float lP) {
	leagueWinPct = lP;

}

float League::get_leaguePct() {
	return leagueWinPct;

}


void League::set_winPct(float lP, int w) {
	winDepositPct = lP / w;

}

float League::get_winPct() {
	return winDepositPct;

}


void League::set_winDeposit(int wD) {
	perWinDeposit = (wD / 100) * personal.get_principal();

}

int League::get_winDeposit() {
	return perWinDeposit;

}


void League::set_streakDeposit(int wD) {
	perStreakDeposit = (wD / 100) * (personal.get_principal() + club.get_balance());

}

int League::get_streakDeposit() {
	return perStreakDeposit;

}


void League::set_inflationPctAdded(float iP, int losses) 
{
	//waiting for true losses variable
	losses = 0;

	//for each loss, the inflation percent on personal increases by 20%
		iPA = (iP * 0.2) * losses;
		inflationPctAdded = iPA;
}

float League::get_inflationPctAdded() {
	return inflationPctAdded;

}


void League::set_matchInflationPct(float iP, float iPA) {
	iP += iPA;
	matchInflationPct = iP;

}

float League::get_matchInflationPct() {
	return matchInflationPct;

}


void League::set_postMatchWithdraw(float iP)
{
	postMatchWithdraw = (iP / 100) * personal.get_balance();

}

int League::get_postMatchWithdraw() {
	return postMatchWithdraw;

}


void League::set_streakClubWithdraw(float iP, bool loseStreak)
{
	//waiting for true loseStreak variable
	loseStreak = false;

	if (loseStreak == true) {
		streakClubWithdraw = (iP / 100) * club.get_balance();

	}
	else {
		streakClubWithdraw = 0;
	}
	
}

int League::get_streakClubWithdraw() {
	return postMatchWithdraw;

}


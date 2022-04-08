#include "League.h"
#include "Bank.h"
#include "Print.h"
#include <iostream>
#include <string>


League::League() {
	leagueName = "";
	entryFee = 0;
	numberOfMatches = 0;
	winsNeeded = 0;

	leagueWinPct = 0.0;
	winDepositPct = 0;
	wD = 0.0;
	perWinDeposit = 0;
	perStreakDeposit = 0.0;

	matchInflationPct = 0.0;
	inflationPctAdded = 0.0;
	pA = 0.0;
	postMatchWithdraw = 0;
	streakClubWithdraw = 0;
}


//creating leagues
League::League(std::string n, int e, int m, int w, float lP, float iP, float iPA) {
	leagueName = n;
	entryFee = e;
	numberOfMatches = m;
	winsNeeded = w;

	leagueWinPct = lP;
	winDepositPct = lP / w;
	wD = winDepositPct;
	perWinDeposit; 
	perStreakDeposit;

	matchInflationPct = iP;
	startInflation = iP;
	inflationPctAdded = iPA;
	pA = iPA;
	postMatchWithdraw;
	streakClubWithdraw;

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


//percent of personal account that is paid by end of each league
void League::set_leaguePct(float lP) {
	leagueWinPct = lP;

}

float League::get_leaguePct() {
	return leagueWinPct;

}


//lP = leagueWinPct ; w = winsNeeded
//percent that is paid to club account after each win
void League::set_winPct(float lP, int w) {
	winDepositPct = lP / w;

}

float League::get_winPct() {
	return rnd(winDepositPct);

}

//dollar amount paid after each win in league
void League::set_winDeposit(Bank acc[]) 
{
	
		perWinDeposit = (wD / 100.0) * acc[0].get_principal();
	
}

float League::get_winDeposit() {
	return rnd(perWinDeposit);

}


//dollar amount paid after each win during win streak
void League::set_streakDeposit(Bank acc[]) {
	perStreakDeposit = (wD / 100.0) * (acc[0].get_principal() + acc[1].get_balance());

}

float League::get_streakDeposit() {
	return rnd(perStreakDeposit);

}


//percent of inflation that is added per loss
void League::set_inflationPctAdded() 
{
	//for each loss, the inflation percent on personal increases by league decided percent
	//league amount = pA
		inflationPctAdded = (matchInflationPct * (pA / 100.0));

}

float League::get_inflationPctAdded() {
	return rnd(inflationPctAdded);

}


//percent of personal account lost to inflation after each match
void League::set_matchInflationPct() {
	matchInflationPct += inflationPctAdded;

}

float League::get_matchInflationPct() {
	return rnd(matchInflationPct);

}


//dollar amount of money withdrawn from personal account after each match
void League::set_postMatchWithdraw(Bank acc[])
{
	postMatchWithdraw = (matchInflationPct / 100) * acc[0].get_balance();

}

float League::get_postMatchWithdraw() {
	return rnd(postMatchWithdraw);

}


//dollar amount of money withdrawn from club account during lose streaks
void League::set_streakClubWithdraw(Bank acc[], bool res[])
{
	if (res[2] == true) {
		streakClubWithdraw = (matchInflationPct / 100.0) * acc[1].get_balance();

	}
	else {
		streakClubWithdraw = 0;
	}

}

float League::get_streakClubWithdraw() {
	return rnd(streakClubWithdraw);

}


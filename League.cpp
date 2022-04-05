#include "League.h"
#include "Bank.h"
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
	return rnd(winDepositPct);

}

void League::set_winDeposit(Bank arr[], int p) 
{
	
		perWinDeposit = (wD / 100.0) * arr[p].get_principal();
	
}

float League::get_winDeposit() {
	return rnd(perWinDeposit);

}


void League::set_streakDeposit(Bank arr[], int p, int c) {
	perStreakDeposit = (wD / 100.0) * (arr[p].get_principal() + arr[c].get_balance());

}

float League::get_streakDeposit() {
	return rnd(perStreakDeposit);

}


void League::set_inflationPctAdded() 
{
	//for each loss, the inflation percent on personal increases by league decided percent
		inflationPctAdded = (matchInflationPct * (pA / 100.0));

}

float League::get_inflationPctAdded() {
	return rnd(inflationPctAdded);

}


void League::set_matchInflationPct() {
	matchInflationPct += inflationPctAdded;

}

float League::get_matchInflationPct() {
	return rnd(matchInflationPct);

}


void League::set_postMatchWithdraw(Bank arr[],int p)
{
	postMatchWithdraw = (matchInflationPct / 100) * arr[p].get_balance();

}

float League::get_postMatchWithdraw() {
	return rnd(postMatchWithdraw);

}


void League::set_streakClubWithdraw(bool loseStreak, Bank arr[], int c)
{
	if (loseStreak == true) {
		streakClubWithdraw = (matchInflationPct / 100.0) * arr[c].get_balance();

	}
	else {
		streakClubWithdraw = 0;
	}

}

float League::get_streakClubWithdraw() {
	return rnd(streakClubWithdraw);

}


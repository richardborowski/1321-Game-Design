#include "Bank.h"
#include "League.h"
#include <string>
#include <iostream>

Bank::Bank() {
	accountName = "";
	accountType = ' ';
	balance = 0.0;
	principal = 0.0;
	transType = ' ';
	transAmount = 0;

}

//for creating bank account objects
Bank::Bank(std::string n, char t, float b) {
	accountName = n;
	accountType = t;
	balance = b;
	principal = 0;

}


void Bank::set_name(std::string n) {
	accountName = n;

}

std::string Bank::get_name() {
	return accountName;

}


void Bank::set_accountType(char t) {
	accountType = t;

}

char Bank::get_accountType() {
	return accountType;

}


void Bank::set_balance(float b) {
	balance = b;

}

float Bank::get_balance() {
	
	return rnd(balance);

}


//adjusting the balance with a deposit/withdrawal
void Bank::set_balance(char dw, int a)
{
	transType = dw;
	transAmount = a;

	if (transType == 'd') {
		balance += a;

	}
	else if (transType == 'w') {
		balance -= a;
	}

}


//post-match balance adjustment
void Bank::set_balance(League lev[], int track[], bool res[])
{	
	l = track[2];

	if (accountType == 'p') 
	{
		balance -= lev[l].get_postMatchWithdraw();
	}

	if (accountType == 'c') 
	{
		if (res[0] == true && res[1] == false) {
			balance += lev[l].get_winDeposit();
		}
		if (res[0] == true && res[1] == true) {
			balance += lev[l].get_streakDeposit();
		}
		if (res[0] == false && res[2] == true) {
			balance -= lev[l].get_streakClubWithdraw();
		}
	}

}


void Bank::set_principal() 
{
		principal = balance;
	
}

float Bank::get_principal() {
	return principal;

}
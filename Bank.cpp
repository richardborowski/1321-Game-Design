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


void Bank::set_balance(int b) {
	balance = b;

}

float Bank::get_balance() {
	
	return rnd(balance);

}


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


void Bank::set_balance(League arr[], int l, bool matchWon, bool winStreak, bool loseStreak)
{	

	if (accountType == 'p') 
	{
		balance -= arr[l].get_postMatchWithdraw();
	}

	if (accountType == 'c') 
	{
		if (matchWon == true && winStreak == false) {
			balance += arr[l].get_winDeposit();
		}
		if (matchWon == true && winStreak == true) {
			balance += arr[l].get_streakDeposit();
		}
		if (matchWon == false && loseStreak == true) {
			balance -= arr[l].get_streakClubWithdraw();
		}
	}

}


void Bank::set_principal(bool exitedShop) 
{
	exitedShop = true;

	if (exitedShop == true) {
		principal = balance;
	}
	
}

float Bank::get_principal() {
	return principal;

}
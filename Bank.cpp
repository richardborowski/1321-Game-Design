#include "Bank.h"
#include "League.h"
#include <string>
#include <iostream>

Bank::Bank() {
	accountName = "";
	accountType = ' ';
	balance = 0;
	principal = 0;
	transType = ' ';
	transAmount = 0;
	//make principal and withdraw/deposit amounts as paramaters so i am able to see these values to the dot operators of the leagues.
	//probably make transaction type paramter for use in the if statement of depositing or withdrawing. inside of balance method.

}

Bank::Bank(std::string n, char t, int b) {
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

int Bank::get_balance() {
	return balance;

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


void Bank::set_balance(bool mR, bool wS, bool lS, int wD, int sD, int mW, int sW) 
{
	//waiting for true matchWon, winStreak, and loseStreak variables
	bool matchWon = true;
	bool winStreak = true;
	bool loseStreak = false;

	if (accountType == 'p') 
	{
		balance -= mW;
	}

	if (accountType == 'c') 
	{
		if (matchWon == true && winStreak == false) {
			balance += wD;
		}
		if (matchWon == true && winStreak == true) {
			balance += sD;
		}
		if (matchWon == false && loseStreak == true) {
			balance -= sW;
		}
	}

}


void Bank::set_principal(bool exitedShop) 
{
	//waiting for true exitedShop variable
	exitedShop = true;

	if (exitedShop == true) {
		principal = balance;
	}
	
}

int Bank::get_principal() {
	return principal;

}
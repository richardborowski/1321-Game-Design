#pragma once
#include <string>

class Bank
{
private:
	std::string accountName;
	char accountType;
	int balance;
	int principal;
	char transType;
	int transAmount;



public:
	Bank();

	//t = account type ; b = balance
	Bank(std::string n, char t, int b);


	void set_name(std::string n);

	std::string get_name();


	//t = account type
	//differs between personal and club account
	void set_accountType(char t);

	char get_accountType();


	//b = balance
	//completely set the balance
	void set_balance(int b);

	int get_balance();


	//dw = deposit/withdrawl ; a = transaction amount
	//adjusting the balance with a deposit/withdrawal (allows for changing the balance by an amount in another class)
	void set_balance(char dw, int a);


	//post match balance adjustment (if matchEnd == true)
	//mr = matchWon ; wS = winStreak ; lS = loseStreak ; wD = winDeposit ; sD = streakDeposit ; mW = postMatchWithdraw ; sW = streakClubWithdraw
	void set_balance(bool mR, bool wS, bool lS, int wD, int sD, int mW, int sW);


	//gets amount of personal account that win amounts will be paid on.
	void set_principal(bool exitedShop);

	int get_principal();

};




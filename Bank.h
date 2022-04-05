#pragma once
#include <string>
class League;

class Bank
{
private:
	std::string accountName;
	char accountType;
	float balance;
	float principal;
	char transType;
	int transAmount;



public:
	Bank();

	//t = account type ; b = balance
	Bank(std::string name, char type, float balance);


	void set_name(std::string n);

	std::string get_name();


	//t = account type
	//differs between personal and club account
	void set_accountType(char t);

	char get_accountType();


	//b = balance
	//completely set the balance
	void set_balance(int b);

	float get_balance();


	//dw = deposit/withdrawl ; a = transaction amount
	//adjusting the balance with a deposit/withdrawal (allows for changing the balance by an amount in another class)
	void set_balance(char dw, int a);


	//post match balance adjustment (if matchEnd == true)
	void set_balance(League arr[], int leagueNum, bool matchWon, bool winStreak, bool loseStreak);


	//gets amount of personal account that win amounts will be paid on.
	void set_principal(bool exitedShop);

	float get_principal();

};




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
	int l;


public:
	Bank();

	//for creating bank account object
	Bank(std::string name, char type, float balance);


	void set_name(std::string n);

	std::string get_name();


	//differs between personal and club account
	//t = account type
	void set_accountType(char t);

	char get_accountType();


	//completely set the balance
	//b = balance
	void set_balance(float b);

	float get_balance();


	//adjusting the balance with a deposit/withdrawal
	//dw = deposit/withdrawl ; a = transaction amount
	void set_balance(char dw, int a);


	//post-match balance adjustment
	void set_balance(League lev[], int track[], bool res[]);


	//gets amount of personal account that win amounts will be paid on.
	void set_principal();

	float get_principal();

};




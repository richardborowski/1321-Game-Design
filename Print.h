#pragma once
#include <string>
class League;
class Bank;

class Print
{
private:
	char printType;
	std::string subType;


public:
	Print();

	//for creating objects of repeated text
	Print(char type);

	//for printint out needed information to user
	void print();
	
	//for sub types of repeated info such as: help(rules), tutorial(bank), league(info), league(postMatch), etc.
	void print(std::string subType, League lev[], int l, Bank acc[], int p, int c);



};


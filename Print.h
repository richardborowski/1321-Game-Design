#pragma once
#include <string>
class League;
class Bank;

class Print
{
private:
	char printType;
	std::string subType;
	bool leagueWon;
	char press;

public:
	Print();

	//for creating objects of repeated text
	Print(char type);

	//for printing out needed information to user
	void print(Print opt[], int m, int l, int h);
	
	//menu or continue
	void enter(Print opt[]);

	//help rules
	void print(Print opt[], std::string subType);

	//for sub types of repeated info such as: help(rules), tutorial(bank), league(info), etc.
	void print(Print opt[], std::string subType, League lev[], int l, Bank acc[], int p, int c);

	//post match
	void print(Print opt[], std::string subType, League lev[], int l, Bank acc[], int p, int c, bool matchWon, bool winStreak, bool loseStreak, int matchesPlayed, int wins);



};


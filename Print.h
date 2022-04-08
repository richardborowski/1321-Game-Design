#pragma once
#include <string>
class League;
class Bank;

class Print
{
private:
	char printType;
	std::string subType;
	char press;
	int l;

public:
	Print();

	//for creating objects of repeated text
	Print(char type, int track[]);

//for printing the main menu 
//m = menu = 0
//l = league = 1
//h = help = 2
	void print(Print opt[]);
	
	//enter to continue or main menu
	void enter(Print opt[]);

	//for printing the rules
	void print(Print opt[], std::string subType);

	//for printing league information
	//opt = options, lev = level, acc = account, res = result, track = tracker
	void print(Print opt[], std::string subType, League lev[], Bank acc[], bool res[], int track[]);



};


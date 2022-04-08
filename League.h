#pragma once
#include <string>
class Bank;
class Print;

//rounding to $00.00
inline float rnd(float n) {
	float value = (int)(n * 100 + 0.5001);
	return (float)value / 100;

}

class League
{
private:
	std::string leagueName;
	int entryFee;
	int numberOfMatches;
	int winsNeeded;

	float leagueWinPct;
	float winDepositPct, wD;
	float perWinDeposit;
	float perStreakDeposit;

	float matchInflationPct;
	float inflationPctAdded, pA, startInflation;

	float postMatchWithdraw;
	float streakClubWithdraw;

public:
	League();

	
	//creating leagues
	League(std::string name, int entryFee, int numMatches, int winsNeeded, float leagueWinPct, float inflationPct, float inflationPctAdded);

	void set_name(std::string n);

	std::string get_name();


	void set_entryFee(int e);

	int get_entryFee();


	void set_numMatches(int m);

	int get_numMatches();


	void set_winsNeeded(int w);

	int get_winsNeeded();


	//percent of personal account that is paid by end of each league
	void set_leaguePct(float lP);

	float get_leaguePct();


	//lP = leagueWinPct ; w = winsNeeded
	//percent that is paid to club account after each win
	void set_winPct(float lP, int w);

	float get_winPct();


	//dollar amount paid after each win in league
	void set_winDeposit(Bank acc[]);

	float get_winDeposit();


	//dollar amount paid after each win during win streak
	void set_streakDeposit(Bank acc[]);

	float get_streakDeposit();


	//percent of inflation that is added per loss
	void set_inflationPctAdded();

	float get_inflationPctAdded();


	//percent of personal account lost to inflation after each match
	void set_matchInflationPct();

	float get_matchInflationPct();


	//dollar amount of money withdrawn from personal account after each match
	void set_postMatchWithdraw(Bank acc[]);

	float get_postMatchWithdraw();


	//dollar amount of money withdrawn from club account during lose streaks
	void set_streakClubWithdraw(Bank acc[], bool res[]);

	float get_streakClubWithdraw();

};


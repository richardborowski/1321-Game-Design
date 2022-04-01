#pragma once
#include <string>

class League
{
private:
	std::string leagueName;
	int entryFee;
	int numberOfMatches;
	int winsNeeded;

	float leagueWinPct;
	float winDepositPct, wD;
	int perWinDeposit;
	int perStreakDeposit;

	float matchInflationPct;
	float inflationPctAdded, iPA;

	int postMatchWithdraw;
	int streakClubWithdraw;

public:
	League();

	//e = entryFee ; m = numMatches ; w = winsNeeded ; lP = leagueWinPct ; iP = inflationPct
	League(std::string n, int e, int m, int w, float lP, float iP);


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
	//percent that is paid to club account after each win (fraction of league percent)
	void set_winPct(float lP, int w);

	float get_winPct();


	//actual value paid after each win in league
	void set_winDeposit(int wD);

	int get_winDeposit();


	//actual value paid after each win during win streak
	void set_streakDeposit(int wD);

	int get_streakDeposit();


	//percent of inflation that is added based on number of losses
	void set_inflationPctAdded(float iP, int losses);

	float get_inflationPctAdded();


	//percent of personal account lost after each match
	void set_matchInflationPct(float iP, float iPA);

	float get_matchInflationPct();


	//actual value of money withdrawn from personal account after each match
	void set_postMatchWithdraw(float iP);

	int get_postMatchWithdraw();


	//actual value of money withdrawn from club account during lose streaks
	void set_streakClubWithdraw(float iP, bool loseStreak);

	int get_streakClubWithdraw();

};


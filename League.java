public class League{
    
    String leagueName;
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
    
    
    public League() {
	leagueName = "";
	entryFee = 0;
	numberOfMatches = 0;
	winsNeeded = 0;

	leagueWinPct = 0.0f;
	winDepositPct = 0;
	wD = 0.0f;
	perWinDeposit = 0;
	perStreakDeposit = 0.0f;

	matchInflationPct = 0.0f;
	inflationPctAdded = 0.0f;
	pA = 0.0f;
	postMatchWithdraw = 0;
	streakClubWithdraw = 0;
}


//creating leagues
public League(String n, int e, int m, int w, float lP, float iP, float iPA) {
	leagueName = n;
	entryFee = e;
	numberOfMatches = m;
	winsNeeded = w;

	leagueWinPct = lP;
	winDepositPct = lP / w;
	wD = winDepositPct;
	//perWinDeposit;
	//perStreakDeposit;

	matchInflationPct = iP;
	startInflation = iP;
	inflationPctAdded = iPA;
	pA = iPA;
	//postMatchWithdraw;
	//streakClubWithdraw;

}

public void set_name(String n) {
	leagueName = n;

}

public String get_name() {
	return leagueName;

}


public void set_entryFee(int e) {
	entryFee = e;

}

public int get_entryFee() {
	return entryFee;

}


public void set_numMatches(int m) {
	numberOfMatches = m;

}

public int get_numMatches() {
	return numberOfMatches;

}


public void set_winsNeeded(int w) {
	winsNeeded = w;

}

public int get_winsNeeded() {
	return winsNeeded;

}


//percent of personal account that is paid by end of each league
public void set_leaguePct(float lP) {
	leagueWinPct = lP;

}

public float get_leaguePct() {
	return leagueWinPct;

}


//lP = leagueWinPct ; w = winsNeeded
//percent that is paid to club account after each win
public void set_winPct(float lP, int w) {
	winDepositPct = lP / w;

}

public float get_winPct() {
	return rnd(winDepositPct);

}

//dollar amount paid after each win in league
public void set_winDeposit(Bank[] acc) 
{
	
		perWinDeposit = (wD / 100.0f) * acc[0].get_principal();
	
}

public float get_winDeposit() {
	return rnd(perWinDeposit);

}


//dollar amount paid after each win during win streak
public void set_streakDeposit(Bank[] acc) {
	perStreakDeposit = (wD / 100.0f) * (acc[0].get_principal() + acc[1].get_balance());

}

public float get_streakDeposit() {
	return rnd(perStreakDeposit);

}


//percent of inflation that is added per loss
public void set_inflationPctAdded() 
{
	//for each loss, the inflation percent on personal increases by league decided percent
	//league amount = pA
		inflationPctAdded = (matchInflationPct * (pA / 100.0f));

}

public float get_inflationPctAdded() {
	return rnd(inflationPctAdded);

}


//percent of personal account lost to inflation after each match
public void set_matchInflationPct() {
	matchInflationPct += inflationPctAdded;

}

public float get_matchInflationPct() {
	return rnd(matchInflationPct);

}


//dollar amount of money withdrawn from personal account after each match
public void set_postMatchWithdraw(Bank[] acc)
{
	postMatchWithdraw = (matchInflationPct / 100) * acc[0].get_balance();

}

public float get_postMatchWithdraw() {
	return rnd(postMatchWithdraw);

}


//dollar amount of money withdrawn from club account during lose streaks
public void set_streakClubWithdraw(Bank[] acc, boolean[] res)
{
	if (res[2] == true) {
		streakClubWithdraw = (matchInflationPct / 100.0f) * acc[1].get_balance();

	}
	else {
		streakClubWithdraw = 0;
	}

}

public float get_streakClubWithdraw() {
	return rnd(streakClubWithdraw);

}

    
    public float rnd(float n) {
        float value = (int)(n * 100 + 0.5001);
        return (float)value / 100;
    }
      
}
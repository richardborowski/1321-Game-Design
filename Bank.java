
public class Bank
{
    String accountName;
	char accountType;
	float balance;
	float principal;
	char transType;
	int transAmount;
	int l;
    
    //for creating bank account objects
    public Bank() 
    {
        accountName = "";
        accountType = ' ';
        balance = 0.0f;
        principal = 0.0f;
        transType = ' ';
        transAmount = 0;
    }
    
    
    public Bank(String n, char t, float b) 
    {
        accountName = n;
        accountType = t;
        balance = b;
        principal = 0;
    }
    
    
    public  void set_name(String n) {
	accountName = n;

}

public String get_name() {
	return accountName;

}


public  void set_accountType(char t) {
	accountType = t;

}

public  char get_accountType() {
	return accountType;

}


public void set_balance(int b) {
	balance = b;

}

public float get_balance() {
	return rnd(balance);

}


//adjusting the balance with a deposit/withdrawal
public void set_balance(char dw, int a)
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


//post-match balance adjustment
public void set_balance(League[] lev, int[] track, boolean[] res)
{	
	l = track[2];

	if (accountType == 'p') 
	{
		balance -= lev[l].get_postMatchWithdraw();
	}

	if (accountType == 'c') 
	{
		if (res[0] == true && res[1] == false) {
			balance += lev[l].get_winDeposit();
		}
		if (res[0] == true && res[1] == true) {
			balance += lev[l].get_streakDeposit();
		}
		if (res[0] == false && res[2] == true) {
			balance -= lev[l].get_streakClubWithdraw();
		}
	}

}


public void set_principal() 
{
		principal = balance;
	
}

public float get_principal() {
	return rnd(principal);

}

	public float rnd(float n) {
		float value = (int)(n * 100 + 0.5001);
		return (float)value / 100;
	}
    
}

public class Bank {
    private String accname;
    private double balance;
    private double ir;//interest rate
    private double inflation;

    public Bank(String accname, double balance, double ir)
    {
        this.accname=accname;
        this.balance=balance;
        this.ir=ir;
        this.inflation = 1;
    }

    public double getBalance()
    {
        return this.balance;
    }

    public void setBalance(double a)
    {
        this.balance=a;
    }
    public void subBalance(double a)
    {
        this.balance -= a;
    }

    public void addBalance(double a)
    {
        this.balance += a;
    }

    public void checkBankruptcy()
    {
        if(balance < 0)
        {
            System.out.println("YOU WENT BANKRUPT");
            System.out.println("GAME OVER ");
            System.exit(0);
        }
    }

    public void setIr(double a)
    {
        this.ir=a;
    }


    public double getIr()
    {
        return this.ir;
    }

    public void addIr()
    {
        double air = this.balance * this.ir;
        this.balance+= air;
    }

    public void transfer(Bank club)
    {
        this.balance += club.getBalance();
        club.setBalance(0);
    }

    public void addinflation()
    {
        this.inflation += .5;
    }

    public double getInflation()
    {
        return this.inflation;
    }
}

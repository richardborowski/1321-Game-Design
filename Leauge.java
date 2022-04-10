public class Leauge {

    private String lname;
    private Charachter leauge[];
    private double entryfee;
    private boolean won;

    public Leauge(String lname, Charachter leauge[], double entryfee)
    {
        this.lname=lname;
        this.leauge=leauge;
        this.entryfee=entryfee;
        this.won=false;
    }

    public String getLname()
    {
        return this.lname;
    }

    public double getEntryfee()
    {
        return this.entryfee;
    }

    public boolean getWon()
    {
        return this.won;
    }

    public void setwin(boolean b)
    {
        this.won = b;
    }






}

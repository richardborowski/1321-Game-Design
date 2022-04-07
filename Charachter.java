public class Charachter {

    private String name;
    private int health;
    private int fighthealth;
    private double money;
    private int damage;
    private Manager main;

    public Charachter(String name)
    {
        this.name = name;
        this.health = 15;
        this.fighthealth = this.health;
        this.money = 0;
        this.damage = 2;
        this.main = null;
    }


    public Charachter(String name, int health, double money, int damage)
    {
        this.name = name;
        this.health = health;
        this.fighthealth = this.health;
        this.money = money;
        this.damage = damage;
    }

    public String getPlayerName()
    {
        return this.name;
    }

    public int getPlayerHealth()
    {
        return this.health;
    }

    public int getFighthealth()
    {
        return this.fighthealth;
    }

    public int getPlayerDamage()
    {
        return this.damage;
    }


    public void setPlayerDamage(int d)
    {
        this.damage = d;
    }

    public void getHit(int d)
    {
        this.fighthealth -= d;
    }

    public void rest()
    {
        this.fighthealth += 1;
    }

    public void resethealth()
    {
        this.fighthealth = this.health;

    }

    public void newManager(Manager m)
    {
        this.main = m;
    }

    public void nextleauge()
    {
        health = health + 10;
        this.damage += 2;
    }

}


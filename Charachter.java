public class Charachter {

    private String name;
    private int health;
    private double money;
    private int damage;
    private Manager main;

    public Charachter(String name)
    {
        this.name = name;
        this.health = 10;
        this.money = 0;
        this.damage = 2;
        this.main = null;
    }


    public Charachter(String name, int health, double money, int damage)
    {
        this.name = name;
        this.health = health;
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
        this.health -= d;
    }

    public void rest()
    {
        this.health += 1;
    }

    public void newManager(Manager m)
    {
        this.main = m;
    }

}


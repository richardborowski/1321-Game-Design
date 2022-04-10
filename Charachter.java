public class Charachter {

    private String name;
    private int health;
    private int fighthealth;
    private double money;
    private int damage;
    private int stamina;
    private int fightstamina;

    public Charachter(String name)
    {
        this.name = name;
        this.health = 15;
        this.fighthealth = this.health;
        this.money = 0;
        this.damage = 2;
        this.stamina = 3;
        this.fightstamina = stamina;

    }


    public Charachter(String name, int health, double money, int damage, int stamina)
    {
        this.name = name;
        this.health = health;
        this.fighthealth = this.health;
        this.money = money;
        this.damage = damage;
        this.stamina = stamina;
    }

    public String getPlayerName()
    {
        return this.name;
    }

    public int getPlayerHealth()
    {
        return this.health;
    }

    public void addHealth(int a)
    {
        this.health+=a;
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

    public void addDamage(int a)
    {
        this.damage+=a;
    }

    public int getFightstamina()
    {
        return this.fightstamina;
    }

    public void decFightStamina(int s)
    {
        this.fightstamina -= s;
    }

    public void resetStamina()
    {
        this.fightstamina = stamina;
    }


    public void getHit(int d)
    {
        this.fighthealth -= d;
    }

    public void rest()
    {
        this.fighthealth += 1;
        this.fightstamina += 1;
    }

    public void resethealth()
    {
        this.fighthealth = this.health;

    }

    public void nextleauge()
    {
        health = health + 10;
        this.damage += 2;
    }

}
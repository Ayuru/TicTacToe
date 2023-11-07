package game.extended;

public interface Monster {
    public String getName();

    public void setName(String name);

    public int getHp();

    public void defend(int damage);

    public int attack();


}

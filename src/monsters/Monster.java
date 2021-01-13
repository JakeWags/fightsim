package monsters;
import player.Player;

abstract class Monster {
    private int health;
    private String badStuff;

    public Monster(int health, String badstuff) {
        if (health > 0)
        this.health = health;

        this.badStuff = badstuff;
    }

    public int getHealth() {
        return this.health;
    }

    public String getBadStuff() {
        return this.badStuff;
    }

    public abstract void doBadStuff(Player p);
}

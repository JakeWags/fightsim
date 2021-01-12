package monsters;
import player.Player;

public class Monster {
    private int health;
    private String badStuff;

    public Monster(int h, String bs) {
        if (h > 0)
        this.health = h;

        this.badStuff = bs;
    }

    public int getHealth() {
        return this.health;
    }

    public String getBadStuff() {
        return this.badStuff;
    }

    public void doBadStuff(Player p) {
        /* BEHAVIOR FOR BADSTUFF */
        return;
    }
}

package monsters;
import player.Player;

public class Chicken extends Monster {
    public Chicken() {
        super(3, "Lose your headgear. Take 1 damage.");
    }

    @Override
    public void doBadStuff(Player p) {
        p.items.headgear = null;
        p.changeHp(-1);
    }
}

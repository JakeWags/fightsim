import items.*;
import monsters.Chicken;
import player.Player;

public class Main {
    public static void init() throws Exception {
        ItemList.generateItemList();
    }

    public static void main(String[] args) throws Exception {
        init();
        Player p = new Player("jake");
        Chicken c = new Chicken();

        p.equipItem(ItemList.getItem("Black Cleaver"));
        p.equipItem(ItemList.getItem("Cloth Armor"));
        p.equipItem(ItemList.getItem("Leather Sandals"));
        p.equipItem(ItemList.getItem("Leather Cap"));

        System.out.println(p.items);
        System.out.println(p.items.inventory);

        c.doBadStuff(p);
        System.out.println(p.getHp());
        System.out.println(p.items);
    }
}

import items.*;
import player.Player;

public class Main {
    public static void init() throws Exception {
        ItemList.generateItemList();
    }

    public static void main(String[] args) throws Exception {
        init();
        Player p = new Player("jake");

        p.equipItem(ItemList.getItem("Bronze Spear"));
        p.equipItem(ItemList.getItem("Cloth Armor"));
        p.equipItem(ItemList.getItem("Leather Sandals"));

        System.out.println(p.items);
        System.out.println(p.items.inventory);
        System.out.println(p.items.getTotalCombatMod());
    }
}

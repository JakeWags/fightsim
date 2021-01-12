package player;

import items.*;

public class Player {
    private int money;
    public final String name;
    private int level;
    private int hp;
    private int natArmor;
    public Items items;

    public Player(String name) {
        this.money = 0;
        this.name = name;
        this.level = 1;
        this.items = new Items();
        this.hp = 15;
    }

    /** GETTERS **/
    public int getMoney() {
        return this.money;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public Items getItems() {return this.items; }

    public int getHp() { return this.hp; }

    public int getNatArmor() { return this.natArmor; }

    public int getCombatMod(boolean items) {
        if (items) {
           return this.level + this.items.getTotalCombatMod();
        } else {
            return this.level;
        }
    }

    public int getArmor(boolean items) {
        if (items) {
            return this.natArmor + this.items.getTotalCombatMod();
        } else {
            return this.natArmor;
        }
    }

    /** SETTERS **/
    public int levelUp() {
        return ++this.level;
    }

    public int changeMoney(int amount) {
        this.money += amount;
        return this.money;
    }

    public void equipItem(Item i) { this.items.equipItem(i); }
    public void equipItem(Item i, String slot) {
        this.items.equipItem(i, slot);
    }

    public void removeItem(Item i) {

    }

}

package player;

import items.*;

import java.util.ArrayList;

public class Items {
    public Armor armor;
    public Footwear footwear;
    public Headgear headgear;
    public Item lefthand;
    public Item righthand;
    public boolean twohand = false;
    public ArrayList<Item> inventory = new ArrayList<>();

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Item getFromInventory(int index) {
        if (index >= 0 && index < inventory.size())
            return inventory.get(index);
        else {
            System.out.println("Index out of bounds: getFromInventory(int index)");
            return null;
        }
    }

    public Item getFromInventory(String name) {
        name = name.toLowerCase();
        for (Item a: inventory) {
            if (a.getName().toLowerCase().equals(name))
                return a;
        }

        System.out.println("Item not found in inventory.");
        return null;
    }

    public int getTotalCombatMod() {
        int mod = 0;
        if (armor != null) {
            mod += armor.getMod();
        }
        if (footwear != null) {
            mod += footwear.getMod();
        }
        if (headgear != null) {
            mod += headgear.getMod();
        }
        if (twohand) {
            if (lefthand != null)
                mod += lefthand.getMod();
        } else {
            if (lefthand != null)
                mod += lefthand.getMod();
            if (righthand != null)
                mod += righthand.getMod();
        }
        return mod;
    }

    public int getTotalArmor() {
        int mod = 0;
        if (armor != null)
            mod += armor.getArmor();
        if (footwear != null)
            mod += footwear.getArmor();
        if (headgear != null)
            mod += headgear.getArmor();
        return mod;
    }

    public void equipItem(Item i, String slot) {
        unequipItem(slot);
        switch (slot) {
            case "Armor":
                if (i instanceof Armor)
                    armor = (Armor) i;
                return;
            case "Headgear":
                if (i instanceof Headgear)
                    headgear = (Headgear) i;
                return;
            case "Footwear":
                if (i instanceof Footwear)
                    footwear = (Footwear) i;
                return;
            case "Lefthand":
                if (i instanceof OneHand || i instanceof TwoHand) {
                    if (i instanceof TwoHand && twohand == false) {
                        unequipItem("Righthand");
                        lefthand = (TwoHand) i;
                        twohand = true;
                    } else if (i instanceof OneHand) {
                        lefthand = (OneHand) i;
                    }
                    return;
                }
            case "Righthand":
                if (i instanceof OneHand || i instanceof TwoHand) {
                    if (i instanceof TwoHand && twohand == false) {
                        unequipItem("Lefthand");
                        righthand = (TwoHand) i;
                        twohand = true;
                    } else if (i instanceof OneHand) {
                        System.out.println("Where it be tho pt 2");
                        righthand = (OneHand) i;
                    }
                    return;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + slot);
        }
    }

    public void equipItem(Item i) {
        if (i instanceof Armor) {
            if (armor != null) {
                unequipItem("Armor");
            }
            this.armor = (Armor) i;
        } else if (i instanceof Footwear) {
            if (footwear != null)
                unequipItem("Footwear");
            this.footwear = (Footwear) i;
        } else if (i instanceof Headgear) {
            if (headgear != null)
                unequipItem("Headgear");
            this.headgear = (Headgear) i;
        } else if (i instanceof OneHand && twohand == false) {
            if (lefthand == null) {
                this.lefthand = (OneHand) i;
            } else {
                if (righthand == null) {
                    this.righthand = (OneHand) i;
                }
                else {
                    if (lefthand.getMod() >= righthand.getMod()) {
                        System.out.println("Unequipping right hand");
                        unequipItem("Righthand");
                        righthand = (OneHand) i;
                    }
                    else {
                        System.out.println("Unequipping left hand");
                        unequipItem("Lefthand");
                        lefthand = (OneHand) i;
                    }
                }
            }
        } else if (i instanceof TwoHand) {
            if (lefthand != null)
                unequipItem("Lefthand");
            if (righthand != null)
                unequipItem("Righthand");
            this.lefthand = (TwoHand) i;
            twohand = true;
        }
    }

    public Item unequipItem(String slot) {
        System.out.println("Unequipping " + slot);
        Item i = null;
        switch (slot) {
            case "Armor":
                if (armor != null) {
                    inventory.add(armor);
                    i = armor;
                    armor = null;
                }
                return i;
            case "Headgear":
                if (headgear != null) {
                    inventory.add(headgear);
                    i = headgear;
                    headgear = null;
                }
                return i;
            case "Footwear":
                if (footwear != null) {
                    inventory.add(footwear);
                    i = footwear;
                    footwear = null;
                }
                return i;
            case "Lefthand":
                if (lefthand != null) {
                    inventory.add(lefthand);
                    i = lefthand;
                    lefthand = null;
                }
                return i;
            case "Righthand":
                if (righthand != null) {
                    inventory.add(righthand);
                    i = righthand;
                    righthand = null;
                }
                return i;
        }
        return i;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s\n%s\n%s\n%s", lefthand, righthand, headgear, armor, footwear);
    }
}


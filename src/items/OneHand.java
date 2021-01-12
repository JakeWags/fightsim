package items;

public class OneHand implements Item {
    int armor = 0;
    int mod = 0;
    String name;

    public OneHand(int a, int m, String n) {
        setArmor(a);
        setMod(m);
        setName(n);
    }

    public int getArmor() {
        return this.armor;
    }

    public void setArmor(int a) {
        this.armor = a;
    }

    @Override
    public int getMod() {
        return this.mod;
    }

    @Override
    public void setMod(int i) {
        this.mod = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String toString() {
        return "OneHand: " + this.name + ", mod: " + this.mod + ", armor: " + this.armor;
    }
}
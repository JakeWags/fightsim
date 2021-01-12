package items;

public class TwoHand implements Item {
    int armor = 0;
    int mod = 0;
    int value = 0;
    String name;

    public TwoHand(int a, int m, String n, int v) {
        setArmor(a);
        setMod(m);
        setName(n);
        setValue(v);
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

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public void setValue(int i) {
        this.value = i;
    }

    public String toString() {
        return "TwoHand: " + this.name + ", mod: " + this.mod + ", armor: " + this.armor + ", value: " + this.value;
    }
}

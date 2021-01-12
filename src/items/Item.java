package items;

import java.util.ArrayList;

public interface Item {
    int mod = 0;
    public int getMod();
    public void setMod(int i);
    public int getArmor();
    public void setArmor(int i);
    public String getName();
    public void setName(String n);
}

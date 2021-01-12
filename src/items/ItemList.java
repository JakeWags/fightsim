package items;

import java.util.*;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class ItemList {
    public static ArrayList<Item> itemlist;
    public static ArrayList<Item> armorList;
    public static ArrayList<Item> headgearList;
    public static ArrayList<Item> footwearList;
    public static ArrayList<Item> onehandList;
    public static ArrayList<Item> twohandList;

    public static void generateItemList() throws Exception {
        Object o = new JSONParser().parse(new FileReader("itemlist.json"));

        JSONObject jo = (JSONObject) o;

        JSONArray armor = (JSONArray) jo.get("Armor");
        JSONArray headgear = (JSONArray) jo.get("Headgear");
        JSONArray footwear = (JSONArray) jo.get("Footwear");
        JSONArray onehand = (JSONArray) jo.get("OneHand");
        JSONArray twohand = (JSONArray) jo.get("TwoHand");

        armorList = iterate(armor, "Armor");
        headgearList = iterate(headgear, "Headgear");
        footwearList = iterate(footwear, "Footwear");
        onehandList = iterate(onehand, "Onehand");
        twohandList = iterate(twohand, "Twohand");
    }

    private static ArrayList<Item> iterate(JSONArray a, String type) {
        Iterator itr1;
        Iterator itr2 = a.iterator();
        ArrayList<Item> b = new ArrayList<>();
        int mod = 0, armor = 0;
        String name = "ERROR";

        while(itr2.hasNext()) {
            itr1 = ((Map) itr2.next()).entrySet().iterator();
            while(itr1.hasNext()) {
                Map.Entry pair = (Map.Entry) itr1.next();
               // System.out.println(pair.getKey() + " : " + pair.getValue() + " type: " + pair.getValue().getClass());
                if (pair.getKey().equals("name")) {
                    name = (String) pair.getValue();
                } else if (pair.getKey().equals("mod") && pair.getValue() instanceof java.lang.Long) {
                    mod = ((Long) pair.getValue()).intValue();
                } else if (pair.getKey().equals("armor") && pair.getValue() instanceof java.lang.Long) {
                    armor = ((Long) pair.getValue()).intValue();
                }
            }
            switch(type) {
                case "Armor":
                    b.add(new Armor(armor, mod, name));
                case "Headgear":
                    b.add(new Headgear(armor, mod, name));
                case "Footwear":
                    b.add(new Footwear(armor, mod, name));
                case "Onehand":
                    b.add(new OneHand(armor, mod, name));
                case "Twohand":
                    b.add(new TwoHand(armor, mod, name));
            }

        }

        return b;
    }

    private static ArrayList<Item> listunion(List<Item> a, List<Item> b) {
        Set<Item> set = new HashSet<>();
        set.addAll(a);
        set.addAll(b);

        return new ArrayList<>(set);
    }

    public static Item getItem(String n) {
        ArrayList<Item>[] a = new ArrayList[]{armorList, headgearList, footwearList, onehandList, twohandList};
        n = n.toLowerCase();
        for(ArrayList<Item> list : a) {
            for (Item i : list) {
                if (i.getName().toLowerCase().equals(n)) {
                    return i;
                }
            }
        }

        System.out.println("No Item of that name found");
        return null;
    }
}

package interfacee;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Treemapp {
    public static void main(String[] args) {
        Map<String,Integer> map=new TreeMap<>();
        map.put("sdfsdf",112);
        map.put("svsfvsf",6545);
        map.put("sddgnfn",78886);
        map.put("h,hluil",454);
        map.put("fjgjjkt",565);
        map.put("tyyth",45756);
        System.out.println(map);
        Map<String,Integer> map1=new TreeMap<>((o1,o2)->o1.length()-o2.length());
        map1.put("5t57u3",112);
        map1.put("svsfvsf",6545);
        map1.put("86yhru",454);
        map1.put("67542",565);
        map1.put("tyyth",45756);
        map1.put("sddgnfn",78886);
        map1.put("sddgnf8",4646);
        System.out.println(map1);
        Map<String,Integer> map2=new TreeMap<>((o1,o2)-> {
            int lenthcompare=o1.length()-o2.length();
            return lenthcompare!=0 ? lenthcompare: o1.compareToIgnoreCase(o2);
        });
        map2.put("5t57u3",112);
        map2.put("svsfvsf",6545);
        map2.put("86yhru",454);
        map2.put("67542",565);
        map2.put("tyyth",45756);
        map2.put("sddgnfn",78886);
        map2.put("sddgnf8",4646);
        System.out.println(map2);
    }
}

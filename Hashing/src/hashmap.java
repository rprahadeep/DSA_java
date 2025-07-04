import java.util.*;
public class hashmap {
    public static void main(String[] args){
        HashMap<String, Integer> map = new HashMap<>();

        //insertion
        map.put("Prahadeep", 2608);
        map.put("Sahanna", 1412);

        //print
        System.out.println(map);

        //Search
        if(map.containsKey("Prahadeep")){
            System.out.println(true);
        }

        //get
        System.out.println(map.get("Sahanna"));

        //iterator
        for(Map.Entry<String, Integer> e:map.entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        //remove
        map.remove("Prahadeep");
    }
}

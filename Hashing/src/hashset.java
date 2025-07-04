import java.util.*;
public class hashset {
    public static void main(String[] args){
        HashSet<Integer> set = new HashSet<>();

        //inserting
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        //searching
        if(set.contains(1)){
            System.out.println(true);
        }

        //delete
        set.remove(1);

        //size
        System.out.println(set.size());

        //print the set
        System.out.println(set);

        //Iterator
        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}

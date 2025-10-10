import java.util.*;

public class HashSet_function {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        if (!set.isEmpty()) {
            Iterator<Integer> it = set.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }
    }
}

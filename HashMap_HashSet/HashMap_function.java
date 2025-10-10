import java.util.HashMap;
import java.util.Map;

public class HashMap_function {
    public static void main(String args[]) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Samruddhi", 98);
        map.put("ABC", 10);
        map.put("DHS", 80);
        map.put("NCB", 40);

        // iterator on map dataset
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e);
        }
    }
}
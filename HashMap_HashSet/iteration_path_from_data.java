import java.util.*;

public class iteration_path_from_data {
    public void findPath() {
        HashMap<String, String> map = new HashMap<>();
        // Mumbai->Delhi->Goa->Chennai->Bengaluru
        map.put("Chennai", "Bengaluru");
        map.put("Mumbai", "Delhi");
        map.put("Goa", "Chennai");
        map.put("Delhi", "Goa");

        HashSet<String> set = new HashSet<>();
        for (String val : map.values()) {
            set.add(val);
        }
        // ***start ->not present in value section
        String end = "";
        String start = "";
        for (String key : map.keySet()) {
            if (!set.contains(key)) {
                start = key;
            }
        }
        // ***end ->not present in key section
        for (String val : set) {
            if (!map.containsKey(val)) {
                end = val;
            }
        }

        while (start != end) {
            System.out.print(" " + start + "->");
            start = map.get(start);
        }
        System.out.print(" " + start);

    }

    public static void main(String[] args) {
        iteration_path_from_data i1 = new iteration_path_from_data();
        i1.findPath();
    }
}
// start i.e loc from path present the for going that loc no start
// i.e as an key that loc play role but not as the value
// so to find start find that value which is not present in value section
// to find destination i.e point b means the point from which we can't start
// i.e point B which not present in key section

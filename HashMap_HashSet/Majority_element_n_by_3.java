import java.util.HashMap;

public class Majority_element_n_by_3 {

    public void find() {
        // array with elements
        int arr[] = { 9, 2, 3, 1, 9, 9, 8 };
        int n = arr.length;
        int k = n / 3;
        // hashmap filling with unique key & their freq count
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        // finding only that keys whose freq is >= condi^n (k)
        for (int key : map.keySet()) {
            if (map.get(key) >= k) {
                System.out.print(key);
            }
        }

    }

    public static void main(String[] args) {
        Majority_element_n_by_3 ele = new Majority_element_n_by_3();
        ele.find();
    }
}

import java.util.HashSet;

public class intersection_2_array {
    public void find() {
        int arr1[] = { 3, 2, 6, 4, 5, 6, 1, 7 };
        int arr2[] = { 3, 2, 61, 7, 4, 1 };

        HashSet<Integer> set = new HashSet<>();
        // add unique values from set1
        for (int i : arr1) {
            set.add(i);
        }

        // show only that ele's which are the common from set1 & set2
        for (int i : arr2) {
            if (set.contains(i)) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        intersection_2_array u1 = new intersection_2_array();
        u1.find();
    }
}

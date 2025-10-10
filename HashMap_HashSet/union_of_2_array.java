import java.util.HashSet;

public class union_of_2_array {
    public void find() {
        int arr1[] = { 3, 2, 6, 4, 5, 6, 1 };
        int arr2[] = { 3, 2, 61, 7, 4, 1, 7 };

        HashSet<Integer> set = new HashSet<>();
        for (int i : arr1) {
            set.add(i);
        }
        for (int i : arr2) {
            set.add(i);
        }
        System.out.println(set);
    }

    public static void main(String[] args) {
        union_of_2_array u1 = new union_of_2_array();
        u1.find();
    }
}

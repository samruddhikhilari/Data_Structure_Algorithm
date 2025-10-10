import java.util.HashMap;

public class subarray_sub_equals_k {
    public void count() {
        int arr[] = { 10, 2, -2, -20, 10 };
        int n = arr.length;
        int k = -10;
        int sum = 0;
        int ans = 0;// count of arrays sum == k
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1); // as first sum=0
        // & when 10[0] , 10[1] sum=20 & expected k=20 so =>sum-k=20-20=0 (i.e 0 is also
        // the sum)
        // finding sum of subarray & checking is that the expected one
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            // check is that a valid sum as k
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k); // valid part how many times presents.
            }

            // but to check valid part we must required the DS which stores that remains
            // valid part
            // i.e stored the valid's sum's

            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        System.out.println("count of present subarrys is :" + ans);
    }

    public static void main(String arg[]) {
        subarray_sub_equals_k s1 = new subarray_sub_equals_k();
        s1.count();
    }
}

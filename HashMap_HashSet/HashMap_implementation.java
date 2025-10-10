import java.util.ArrayList;
import java.util.LinkedList;

class HashMap_implementation {
    public static class HashMap<K, V> {
        public class Node {
            public K key;
            public V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        // linkedlist array allocation blocks for LL data types of values
        LinkedList<Node> buckets[];
        int n; // count of nodes
        int N = 5; // size of array

        HashMap() {
            buckets = new LinkedList[N];

            // making each LL array node to capable of pointing to the LL
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashing(K key) {
            return Math.abs(key.hashCode()) % N;
        }

        private int searchInLL(int bi, K key) {
            LinkedList<Node> ll = buckets[bi];
            Node node;
            for (int i = 0; i < ll.size(); i++) {
                node = ll.get(i);
                if (node.key == key) {
                    return i;
                }
            }
            return -1;
        }

        private void rehash() {
            // copy
            LinkedList<Node> oldbucket[] = buckets;
            // +ve original size
            N *= 2;
            buckets = new LinkedList[N]; // make it as double sized
            // there is ll arr but each bucket dont't have capabilites to point(store) the
            // LL so what we dids with head like that do for each bucket
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<Node>();
            }
            // transfer from copy to new size
            for (int i = 0; i < oldbucket.length; i++) {
                LinkedList<Node> ll = oldbucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        // put
        public void put(K key, V value) {
            // check if already presents ? surely it is in any of LL in any bucket
            // 1.bucket
            int bi = hashing(key);
            // 2. int that bucket LL at which node
            int di = searchInLL(bi, key);

            LinkedList<Node> ll = buckets[bi];
            if (di == -1) { // key node already not present
                Node node = new Node(key, value);
                ll.add(node);
                n++;

                // check if size is overlapping or not
                if (n / N > 2.0) {
                    // size is geting as overlapping
                    rehash();
                }

            } else { // node of that key already present into the Hashmap
                Node node = ll.get(di);
                node.value = value;
            }

        }

        // containskey
        public boolean containsKey(K key) {
            int bi = hashing(key);
            // 2. int that bucket LL at which node
            int di = searchInLL(bi, key);

            if (di == -1) {
                return false;
            } else {
                return true;
            }
        }

        // get
        public V get(K key) {
            int bi = hashing(key);
            // 2. int that bucket LL at which node
            int di = searchInLL(bi, key);

            if (di == -1) {
                return null;

            } else {
                LinkedList<Node> ll = buckets[bi];
                Node node = ll.get(di);
                return node.value;
            }
        }

        // remove
        public Node remove(K key) {
            int bi = hashing(key);
            // 2. int that bucket LL at which node
            int di = searchInLL(bi, key);

            if (di == -1) {
                return null;

            } else {
                LinkedList<Node> ll = buckets[bi];
                Node node = ll.remove(di);
                n--;
                return node;
            }
        }

        // keyset
        public ArrayList<K> keySet() {
            ArrayList<K> arr = new ArrayList<K>();
            LinkedList<Node> list;
            Node node;
            for (int i = 0; i < buckets.length; i++) {
                list = buckets[i];
                for (int j = 0; j < list.size(); j++) {
                    node = list.get(j);
                    arr.add(node.key);
                }
            }

            return arr;
        }

        // isempty
        public boolean isEmpty() {
            return n == 0;
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 100);
        map.put("England", 150);
        map.put("China", 50);

        ArrayList<String> keys = map.keySet();
        if (!map.isEmpty()) {
            for (int i = 0; i < keys.size(); i++) {
                System.out.println(keys.get(i) + " " + map.get(keys.get(i)));
            }
        }
    }
}
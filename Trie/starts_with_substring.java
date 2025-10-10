public class starts_with_substring {

    public static class Node {
        Node child[];
        boolean eow;

        Node() {
            child = new Node[26];
            for (int i = 0; i < 26; i++) {
                child[i] = null;
            }
            eow = false;
        }
    }

    Node root;

    starts_with_substring() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.child[idx] == null) {
                curr.child[idx] = new Node();
            }
            if (i == word.length() - 1) {
                curr.child[idx].eow = true;
            }
            curr = curr.child[idx];
        }
    }

    public boolean search(String word) {

        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.child[idx] == null)
                return false;

            if (i == word.length() - 1 && curr.child[idx].eow != true)
                return false;
            curr = curr.child[idx];
        }

        return true;
    }

    public static void main(String args[]) {
        starts_with_substring i1 = new starts_with_substring();

        String data[] = { "one", "two", "ninty", "onehundred", "nine" };

        for (int i = 0; i < data.length; i++) {
            i1.insert(data[i]);
        }
        String substr = "nine";

        if (i1.search(substr)) {
            System.out.println(substr + " present into dictionary");
        } else {
            System.out.println(substr + " not present into dictionary");
        }
    }
}
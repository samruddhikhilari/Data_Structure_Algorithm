public class search_word {

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

    search_word() {
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

        if (word.length() == 0)
            return true;

        Node curr = root;
        for (int i = 0; i < word.length(); i++) {

            int idx = word.charAt(i) - 'a';
            if (curr.child[idx] == null)
                return false;

            if (i == word.length() - 1) {
                if (curr.child[idx].eow != true)
                    return false;
            }
            curr = curr.child[idx];
        }

        return true;
    }

    public static void main(String args[]) {
        search_word i1 = new search_word();

        String data[] = { "one", "two", "ninty", "onehundred", "nine" };

        for (int i = 0; i < data.length; i++) {
            i1.insert(data[i]);
        }
        String word = "nine";

        if (i1.search(word)) {
            System.out.println(word + " present into dictionary");
        } else {
            System.out.println(word + " not present into dictionary");
        }
    }
}
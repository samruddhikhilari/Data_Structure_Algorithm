public class word_break_prb {

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

    word_break_prb() {
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

    public boolean breakWord(String word) {
        if (word.length() == 0)
            return true;

        // find valid cuts
        for (int i = 1; i <= word.length(); i++) {

            String first = word.substring(0, i);

            System.out.println(first);
            if (search(first) && breakWord(word.substring(i))) {
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        word_break_prb i1 = new word_break_prb();

        String data[] = { "the", "happy", "year", "one", "three" };

        for (int i = 0; i < data.length; i++) {
            i1.insert(data[i]);
        }

        System.out.println(" " + i1.breakWord("thehappyyear"));
    }
}
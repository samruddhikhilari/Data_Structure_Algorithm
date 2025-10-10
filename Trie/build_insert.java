public class build_insert {

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

    build_insert() {
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

    public void print(Node curr, StringBuilder s) {
        if (curr == null)
            return;

        if (curr.eow) {
            System.out.print(" " + s);
        }

        for (int i = 0; i < 26; i++) {
            if (curr.child[i] != null) {
                s.append((char) (i + 'a'));
                print(curr.child[i], s);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }

    public static void main(String args[]) {
        build_insert i1 = new build_insert();

        String data[] = { "a", "abc", "apple", "machine", "sam", "samsung" };

        for (int i = 0; i < data.length; i++) {
            i1.insert(data[i]);
        }

        StringBuilder s = new StringBuilder();
        i1.print(i1.root, s);
    }
}
public class count_distinct_substr_str {

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

    count_distinct_substr_str() {
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

    public int count(Node root) {
        if (root == null)
            return 0;

        Node curr = root;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (curr.child[i] != null) {
                count = count + count(curr.child[i]);
            }
        }

        return 1 + count;
    }

    public static void main(String args[]) {
        count_distinct_substr_str i1 = new count_distinct_substr_str();

        String word = "apple";

        for (int i = 0; i <= word.length(); i++) {

            String substr = word.substring(i);
            i1.insert(substr);
        }

        System.out.println(i1.count(i1.root) + " unique substrings " + word + " word have");
    }
}

// instead of find string's-> substring ->unique one ->count
// do ->suffix -> trie -> count(unique prefix nodes count) i.e all prefix of
// suffix
/*
 * 1.string
 * 2.suffix
 * 3. suffix -> trie
 * 4. trie nodes count
 */
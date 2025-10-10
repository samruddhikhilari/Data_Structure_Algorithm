public class longest_word_with_all_prefixes {

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

    longest_word_with_all_prefixes() {
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

    static String longest = "";

    public void find(String word) {

        Node curr = root;
        String temp = "";
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.child[idx] != null) {
                if (curr.child[idx].eow == true) {
                    curr = curr.child[idx];
                }
            } else {
                return;
            }

            if (i == word.length() - 1 && curr.eow == true) {
                temp = word;
                if (temp.length() > longest.length()
                        || temp.length() == longest.length() && temp.compareTo(longest) < 0) {
                    longest = temp;
                }
            }
        }

    }

    public static void main(String args[]) {
        longest_word_with_all_prefixes i1 = new longest_word_with_all_prefixes();

        String data[] = { "a", "ap", "app", "appl", "apply", "apple", "an", "sam", "samsung" };

        for (int i = 0; i < data.length; i++) {
            i1.insert(data[i]);
        }

        for (int i = 0; i < data.length; i++) {
            i1.find(data[i]);
        }

        System.out.println("longest word with all prefixes is :" + longest);
    }
}

// into the string word dict
// there are words whose all prefixes all also into dict with the word
// find the longest word with all prefixes
// 1. find the word having all prefix present into the dict
// 2. we want longest at first conside 1 then if any other found all prefect
// prefix word compare length of the both words which is longes that will ans
// 3. if both have same length & both are prefect prefix then choose
// that one which is lexicographically first
// i. apple is first & apply is second i.e e<y so.
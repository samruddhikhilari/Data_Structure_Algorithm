public class search_node_in_BST {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    public Node build(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        // if root present then
        if (val < root.data) {
            root.left = build(root.left, val);
        } else if (val > root.data) {
            root.right = build(root.right, val);
        }

        return root;
    }

    public void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(" " + root.data);
        inorder(root.right);
    }

    public boolean search(Node root, int val) {
        if (root == null) {
            return false;
        }
        if (root.data == val) {
            return true;
        }
        if (val < root.data) {
            return search(root.left, val);
        } else if (val > root.data) {
            return search(root.right, val);
        }
        return false;
    }

    public int inordersuccessor(Node root) {
        if (root == null) {
            return -1;
        }

        // find lestmost from right subtree
        // deleted notdes 1st inordersuccessors
        Node temp = root;
        while (!(temp.left == null)) {
            temp = temp.left;
        }
        return temp.data;
    }

    public Node delete(Node root, int val) {
        // tree must not be null
        if (root == null)
            return null;

        // if present in left subtree
        if (val < root.data) {
            root.left = delete(root.left, val);
        } else if (val > root.data) { // if present in right subtree
            root.right = delete(root.right, val);
        } else if (root.data == val) { // if at the pos of top

            // case1 no child
            if (root.left == null && root.right == null) {
                return null;
            }

            // case2 one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case3 two child
            int is = inordersuccessor(root.right);
            root.data = is;
            root.right = delete(root.right, is);
            return root;
        }
        return root;
    }

    public static void main(String[] args) {
        search_node_in_BST b1 = new search_node_in_BST();
        int arr[] = { 81, 12, 3, 84, 38, 16 };
        Node root = null;
        for (int i : arr) {
            root = b1.build(root, i);
        }

        b1.inorder(root);
        System.out.println();
        System.out.println("Ele present or not :" + b1.search(root, 99));

        root = b1.delete(root, 9);
        b1.inorder(root);

    }
}

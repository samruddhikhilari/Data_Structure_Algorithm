class Print_Node_in_Range {

    int idx;

    Print_Node_in_Range() {
        idx = -1;
    }

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

    public Node build(int arr[]) {
        idx++;
        if (arr[idx] == -1) {
            return null;
        }

        Node node = new Node(arr[idx]);
        node.left = build(arr);
        node.right = build(arr);

        return node;
    }

    public void print(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        print(root.left);
        print(root.right);

    }

    public void printRange(Node root, int start, int end) {
        if (root == null)
            return;

        if (start <= root.data && root.data <= end) {
            // left
            printRange(root.left, start, end);
            System.out.print(" " + root.data);
            // right
            printRange(root.right, start, end);
        } else if (root.data >= end) {// only left subtree
            printRange(root.left, start, end);
        } else if (root.data <= start) {// only right subtree
            printRange(root.right, start, end);
        }

    }

    public static void main(String[] args) {
        Print_Node_in_Range tree = new Print_Node_in_Range();
        int arr[] = { 1, 2, 4, 7, -1, -1, 8, -1, -1, 5, -1, -1, 3, -1, 6, -1, 9, -1, -1 };
        Node root = tree.build(arr);
        // tree.print(root);
        tree.printRange(root, 1, 5);
    }
}

/*
 * cases:
 * 1.values only present into leftsubtree
 * 1.values only present into rightsubtree
 * 1.values present into leftsubtree & rightsubtree including root node
 */
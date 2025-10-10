public class Height_Of_Nodes {

    int idx;

    Height_Of_Nodes() {
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

    public int height(Node root) {

        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        return (lh > rh) ? lh + 1 : rh + 1;

    }

    public static void main(String[] args) {
        Height_Of_Nodes tree = new Height_Of_Nodes();
        int arr[] = { 1, 2, 4, 7, -1, -1, 8, -1, -1, 5, -1, -1, 3, -1, 6, -1, 9, -1, -1 };
        Node root = tree.build(arr);
        System.out.println("Height of the Tree is :" + tree.height(root));
    }
}

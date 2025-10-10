public class Inorder_Traversal_Ascending_Data {
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
        System.out.println(root.data);
        inorder(root.right);
    }

    public static void main(String[] args) {
        Inorder_Traversal_Ascending_Data b1 = new Inorder_Traversal_Ascending_Data();
        int arr[] = { 81, 12, 3, 84, 38, 16 };
        Node root = null;
        for (int i : arr) {
            root = b1.build(root, i);
        }
        b1.inorder(root);
    }
}

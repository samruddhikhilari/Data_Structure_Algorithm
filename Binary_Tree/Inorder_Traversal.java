
public class Inorder_Traversal {

    int idx;

    Inorder_Traversal() {
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

    public void inorder(Node root) {

        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static void main(String[] args) {
        Inorder_Traversal tree = new Inorder_Traversal();
        int arr[] = { 1, 2, 4, 7, -1, -1, 8, -1, -1, 5, -1, -1, 3, -1, 6, -1, 9, -1, -1 };
        Node root = tree.build(arr);
        tree.inorder(root);
    }
}

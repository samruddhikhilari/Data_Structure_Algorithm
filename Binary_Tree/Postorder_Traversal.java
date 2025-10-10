
public class Postorder_Traversal {

    int idx;

    Postorder_Traversal() {
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

    public void postorder(Node root) {

        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);

    }

    public static void main(String[] args) {
        Postorder_Traversal tree = new Postorder_Traversal();
        int arr[] = { 1, 2, 4, 7, -1, -1, 8, -1, -1, 5, -1, -1, 3, -1, 6, -1, 9, -1, -1 };
        Node root = tree.build(arr);
        tree.postorder(root);
    }
}

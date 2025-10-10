public class Preorder_Traversal {

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

    public int idx = -1;

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
        System.out.println(root.data);
        inorder(root.left);
        inorder(root.right);
    }

    public static void main(String[] args) {
        Preorder_Traversal obj = new Preorder_Traversal();
        int arr[] = { 1, 2, -1, -1, 3, -1, -1 };
        Node root = obj.build(arr);
        obj.inorder(root);
    }
}

public class Sum_Of_Nodes {

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

    int sum = 0;

    public void count(Node root) {
        if (root == null) {
            return;
        }
        sum += root.data;
        count(root.left);
        count(root.right);
    }

    public static void main(String[] args) {
        Sum_Of_Nodes obj = new Sum_Of_Nodes();
        int arr[] = { 1, 2, 4, 7, -1, -1, 8, -1, -1, 5, -1, -1, 3, -1, 6, -1, 9, -1, -1 };
        Node root = obj.build(arr);
        // obj.inorder(root);
        obj.count(root);
        System.out.println(obj.sum);
    }
}

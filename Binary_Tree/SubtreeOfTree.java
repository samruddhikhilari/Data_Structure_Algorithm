public class SubtreeOfTree {

    class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    }

    public Node build(int arr[], int[] idx) {
        if (idx[0] >= arr.length || arr[idx[0]] == -1) {
            idx[0]++; // Move to next index even if null
            return null;
        }

        Node node = new Node(arr[idx[0]]);
        idx[0]++; // Move index forward
        node.left = build(arr, idx);
        node.right = build(arr, idx);
        return node;
    }

    public boolean isIdentical(Node root, Node subtree) {
        if (root == null && subtree == null)
            return true;
        if (root == null || subtree == null)
            return false;
        if (root.data != subtree.data)
            return false;
        return isIdentical(root.left, subtree.left) && isIdentical(root.right, subtree.right);
    }

    public boolean isSubTree(Node root, Node subtree) {
        if (subtree == null)
            return true;
        if (root == null)
            return false;
        if (isIdentical(root, subtree))
            return true;
        return isSubTree(root.left, subtree) || isSubTree(root.right, subtree);
    }

    public static void main(String[] args) {
        SubtreeOfTree obj = new SubtreeOfTree();

        int arr1[] = { 9, 7, 8, -1, -1, 1, 2, -1, -1, 3, -1, -1, 4, 5, -1, -1, 6, -1, -1 };
        int arr2[] = { 1, 2, -1, -1, 3, -1, -1 };

        int[] idx1 = { 0 }; // Using arrays to track indices
        int[] idx2 = { 0 };

        Node root = obj.build(arr1, idx1);
        Node subtree = obj.build(arr2, idx2);

        System.out.println("Is subtree present: " + obj.isSubTree(root, subtree));
    }
}

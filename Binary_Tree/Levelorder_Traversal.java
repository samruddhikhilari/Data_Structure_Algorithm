import java.util.LinkedList;
import java.util.Queue;

public class Levelorder_Traversal {

    int idx;

    Levelorder_Traversal() {
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

    public void levelorder(Node root) {
        // means root is not null
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        // initial val's in queue
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node curnode = queue.remove();
            // if value
            if (curnode != null) {
                System.out.print(" " + curnode.data);
                // add left & right child in queue
                if (curnode.left != null) {
                    queue.add(curnode.left);
                }
                if (curnode.right != null) {
                    queue.add(curnode.right);
                }
            } else { // else null
                System.out.println(); // for new line bcoz end of the level
                // if child presents
                if (!queue.isEmpty()) {
                    queue.add(null);
                } else { // else leaf nodes are there
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        Levelorder_Traversal tree = new Levelorder_Traversal();
        int arr[] = { 1, 2, 4, 7, -1, -1, 8, -1, -1, 5, -1, -1, 3, -1, 6, -1, 9, -1, -1 };
        Node root = tree.build(arr);
        tree.levelorder(root);
    }
}

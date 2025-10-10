import java.util.LinkedList;
import java.util.Queue;

public class Sum_of_nodes_k_level {
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

    int idx = -1;

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

    public int find(Node root, int k) {
        if (root == null || k == 0)
            return 0;

        // if sum of first level
        if (k == 1)
            return root.data;
        // stores nodes levels by levels
        Queue<Node> queue = new LinkedList<>();
        int levelcount = 1;
        int sum = 0;
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node curNode = queue.remove();
            if (curNode != null) {
                if (levelcount == k)
                    sum += curNode.data;
                if (curNode.left != null)
                    queue.add(curNode.left);
                if (curNode.right != null)
                    queue.add(curNode.right);
            } else {
                levelcount++;
                if (levelcount > k) {
                    return sum;
                }
                if (!queue.isEmpty()) {
                    queue.add(null);
                } else
                    break;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 7, -1, -1, 8, -1, -1, 5, -1, -1, 3, -1, 6, -1, 9, -1, -1 };
        Sum_of_nodes_k_level level1 = new Sum_of_nodes_k_level();
        Node root = level1.build(arr);
        level1.print(root);
        System.out.println("Sum of Nodes at K level :" + level1.find(root, 4));
    }
}

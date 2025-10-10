public class Diameter_of_Nodes {

    int idx;

    Diameter_of_Nodes() {
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

    class HeightDiameter {
        int height;
        int diameter;

        HeightDiameter(int h, int d) {
            height = h;
            diameter = d;
        }
    }
    /*
     * O(n^2)
     * public int diameter(Node root) {
     * if (root == null) {
     * return 0;
     * }
     * int ld = diameter(root.left);
     * int rd = diameter(root.right);
     * // diameter with root
     * // height lsubtree + rightsubtree + 1
     * int rootd = height(root.left) + height(root.right) + 1;
     * 
     * return Math.max(Math.max(ld, rd), rootd); // max diameter of the tree
     * 
     * }
     */

    public HeightDiameter diameter(Node root) {
        if (root == null) {
            return new HeightDiameter(0, 0);
        }
        HeightDiameter leftnode = diameter(root.left);
        HeightDiameter rightnode = diameter(root.right);

        int d1 = leftnode.diameter;
        int d2 = rightnode.diameter;
        int d3 = leftnode.height + rightnode.height + 1;

        int mydiameter = Math.max(Math.max(d1, d2), d3);
        int myheight = Math.max(leftnode.height, rightnode.height) + 1;

        HeightDiameter hd = new HeightDiameter(mydiameter, myheight);
        return hd;
    }

    public static void main(String[] args) {
        Diameter_of_Nodes tree = new Diameter_of_Nodes();
        int arr[] = { 1, 2, 4, 7, -1, -1, 8, -1, -1, 5, -1, -1, 3, -1, 6, -1, 9, -1, -1 };
        Node root = tree.build(arr);
        System.out.println("Diameter of the Tree is :" + tree.diameter(root).diameter);
    }
}

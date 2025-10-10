import java.util.*;

public class bfs_traversing {

    public class Vertex {
        int sou;
        int des;

        Vertex(int s, int d) {
            this.sou = s;
            this.des = d;
        }
    }

    ArrayList<Vertex> graph[];
    int n;

    bfs_traversing(int n) {
        this.n = n;
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void insert() {

        graph[0].add(new Vertex(0, 1));

        graph[1].add(new Vertex(1, 0));

        graph[2].add(new Vertex(2, 3));

        graph[3].add(new Vertex(3, 2));
    }

    public void searchNeighbour(int sou) {

        for (int i = 0; i < graph[sou].size(); i++) {
            Vertex v = graph[sou].get(i);
            System.out.println(v.sou + "->" + v.des);
        }
    }

    public void bfs(int start, boolean visited[]) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.remove();

            if (visited[curr] == false) {
                System.out.print("->" + curr);
                visited[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Vertex v = graph[curr].get(i);
                    queue.add(v.des);
                }
            }
        }
    }

    public static void main(String[] args) {

        int n = 4;
        bfs_traversing b1 = new bfs_traversing(n);

        b1.insert();
        boolean visited[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                System.out.println();
                b1.bfs(i, visited);
                System.out.println(" graph start by " + i);
            }
        }

    }
}

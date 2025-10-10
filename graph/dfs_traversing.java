import java.util.*;

public class dfs_traversing {

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

    dfs_traversing(int n) {
        this.n = n;
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void insert() {

        graph[0].add(new Vertex(0, 1));
        graph[0].add(new Vertex(0, 2));

        graph[1].add(new Vertex(1, 0));
        graph[1].add(new Vertex(1, 2));
        graph[1].add(new Vertex(1, 4));

        graph[2].add(new Vertex(2, 0));
        graph[2].add(new Vertex(2, 1));
        graph[2].add(new Vertex(2, 3));

        graph[3].add(new Vertex(3, 2));

        graph[4].add(new Vertex(4, 1));
    }

    public void searchNeighbour(int sou) {

        for (int i = 0; i < graph[sou].size(); i++) {
            Vertex v = graph[sou].get(i);
            System.out.println(v.sou + "->" + v.des);
        }
    }

    public void dfs(int start, boolean visited[]) {

        visited[start] = true;
        System.out.println("->" + start);

        for (int i = 0; i < graph[start].size(); i++) {

            Vertex v = graph[start].get(i);

            if (visited[v.des] == false) {
                dfs(v.des, visited);
            }

        }
    }

    public static void main(String[] args) {

        int n = 5;
        dfs_traversing b1 = new dfs_traversing(n);

        b1.insert();
        boolean visited[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                System.out.println();
                b1.dfs(i, visited);
                System.out.println(" graph start by " + i);
            }
        }
    }
}

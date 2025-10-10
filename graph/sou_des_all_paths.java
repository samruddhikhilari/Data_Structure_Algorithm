import java.util.*;

public class sou_des_all_paths {

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

    sou_des_all_paths(int n) {
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

    public void dfs(int start, boolean visited[], int stop, String path) {

        if (start == stop) {
            System.out.println(path);
        }

        for (int i = 0; i < graph[start].size(); i++) {

            Vertex v = graph[start].get(i);

            if (visited[v.des] == false) {
                visited[start] = true;
                dfs(v.des, visited, stop, path + v.des);
                visited[start] = false;
            }
        }
    }

    public static void main(String[] args) {

        int n = 5;
        sou_des_all_paths b1 = new sou_des_all_paths(n);

        b1.insert();
        boolean visited[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }

        b1.dfs(0, visited, 4, "0");
    }
}

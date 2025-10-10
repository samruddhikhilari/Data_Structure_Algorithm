import java.util.*;

public class path_sou_des {

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

    path_sou_des(int n) {
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

    public void printPath(int start, boolean visited[], String path, int stop) {

        System.out.println("one");
        if (start == stop) {
            System.out.println(path);
        }
        visited[start] = true;
        path = path + start;

        for (int i = 0; i < graph[start].size(); i++) {
            Vertex v = graph[start].get(i);
            if (visited[v.des] == false) {
                printPath(v.des, visited, path, stop);
                path = path.substring(0, path.length() - 1);
            }
        }

    }

    public static void main(String[] args) {

        int n = 5;
        path_sou_des b1 = new path_sou_des(n);

        b1.insert();
        boolean visited[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                b1.printPath(i, visited, "", 4);
                System.out.println(" graph start by " + i);
            }
        }
    }
}

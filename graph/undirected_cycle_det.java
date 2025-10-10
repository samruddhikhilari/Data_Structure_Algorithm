import java.util.*;

public class undirected_cycle_det {

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

    undirected_cycle_det(int n) {
        this.n = n;
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void insert() {

        graph[0].add(new Vertex(0, 1));

        graph[1].add(new Vertex(1, 0));
        graph[1].add(new Vertex(1, 2));

        // graph[2].add(new Vertex(2, 1));

        // graph[3].add(new Vertex(3, 4));
        // graph[3].add(new Vertex(3, 5));

        // graph[4].add(new Vertex(4, 3));
        // graph[4].add(new Vertex(4, 5));

        // graph[4].add(new Vertex(5, 4));
        // graph[4].add(new Vertex(5, 3));
    }

    public void searchNeighbour(int sou) {

        for (int i = 0; i < graph[sou].size(); i++) {
            Vertex v = graph[sou].get(i);
            System.out.println(v.sou + "->" + v.des);
        }
    }

    public boolean cycle(int start, boolean visited[], int par) {
        visited[start] = true;

        for (int i = 0; i < graph[start].size(); i++) {

            Vertex v = graph[start].get(i);
            if (visited[v.des] == false && cycle(v.des, visited, start)) {
                return true;
            } else if (visited[v.des] == true && par != v.des) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int n = 6;
        undirected_cycle_det b1 = new undirected_cycle_det(n);

        b1.insert();
        boolean visited[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                if (b1.cycle(i, visited, -1)) {
                    System.out.println("Cycle present into the given graph");
                    return;
                }
                System.out.println("ch");

            }
        }
        System.out.println("Cycle not present ");
    }
}

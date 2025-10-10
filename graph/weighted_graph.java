import java.util.*;

public class weighted_graph {

    public static class Vertex {
        int sou;
        int des;
        int wei;

        Vertex(int s, int d, int w) {
            this.sou = s;
            this.des = d;
            this.wei = w;
        }
    }

    ArrayList<Vertex> graph[];
    int n;

    weighted_graph(int n) {
        this.n = n;
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void insert() {

        graph[0].add(new Vertex(0, 1, 0));
        graph[0].add(new Vertex(0, 2, -10));

        graph[1].add(new Vertex(1, 0, 0));
        graph[1].add(new Vertex(1, 2, 89));
        graph[1].add(new Vertex(1, 4, 3));

        graph[2].add(new Vertex(2, 0, -10));
        graph[2].add(new Vertex(2, 1, 89));
        graph[2].add(new Vertex(2, 3, 3));

        graph[3].add(new Vertex(3, 2, 3));

        graph[4].add(new Vertex(4, 1, 3));
    }

    public void print(int sou) {

        for (int i = 0; i < graph[sou].size(); i++) {
            Vertex v = graph[sou].get(i);
            System.out.println(v.sou + "->" + v.des + " costs :" + v.wei);
        }
    }

    public static void main(String[] args) {

        int n = 5;
        weighted_graph b1 = new weighted_graph(n);

        b1.insert();
        for (int i = 0; i < 4; i++) {
            b1.print(i);
        }
    }
}

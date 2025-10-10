import java.util.ArrayList;

public class search_neigh_vertex {

    public class Vertex {
        int sou;
        int des;

        Vertex(int s, int d) {
            this.sou = s;
            this.des = d;
        }
    }

    ArrayList<Vertex> graph[];

    search_neigh_vertex(int n) {
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void insert() {

        graph[1].add(new Vertex(1, 2));
        graph[1].add(new Vertex(1, 3));

        graph[2].add(new Vertex(2, 3));

        graph[3].add(new Vertex(3, 1));
        graph[3].add(new Vertex(3, 2));
    }

    public void searchNeighbour(int sou) {

        for (int i = 0; i < graph[sou].size(); i++) {
            Vertex v = graph[sou].get(i);
            System.out.println(v.sou + "->" + v.des);
        }
    }

    public static void main(String[] args) {

        search_neigh_vertex b1 = new search_neigh_vertex(4);

        b1.insert();

        b1.searchNeighbour(2);
    }
}

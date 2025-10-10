import java.util.ArrayList;
import java.util.PriorityQueue;

public class minimum_spanning_tree_prim_algorithm {

    public class Vertex {
        int sou;
        int des;
        int weight;

        Vertex(int s, int d, int w) {
            this.sou = s;
            this.des = d;
            this.weight = w;
        }
    }

    ArrayList<Vertex> graph[];
    int V;

    minimum_spanning_tree_prim_algorithm(int n) {
        V = n;
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void insert() {
        graph[0].add(new Vertex(0, 1, 10));
        graph[0].add(new Vertex(0, 2, 15));
        graph[0].add(new Vertex(0, 3, 30));

        graph[1].add(new Vertex(1, 0, 10));
        graph[1].add(new Vertex(1, 3, 40));

        graph[2].add(new Vertex(2, 0, 15));
        graph[2].add(new Vertex(2, 3, 50));

        graph[3].add(new Vertex(3, 1, 40));
        graph[3].add(new Vertex(3, 2, 50));

    }

    public class Pair implements Comparable<Pair> {
        int node;
        int cost;

        Pair(int n, int c) {
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }

    }

    public void primAlgo(boolean visited[]) {
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        int cost = 0;

        queue.add(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair curr = queue.remove();

            if (!visited[curr.node]) {
                visited[curr.node] = true;
                // access childs
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Vertex vertex = graph[curr.node].get(i);

                    if (!visited[vertex.des]) {
                        queue.add(new Pair(vertex.des, vertex.weight));
                    }
                }
                cost = cost + curr.cost;
            }
        }
        System.out.println("Minimum cost required by the graph is : " + cost);
    }

    public static void main(String[] args) {
        int V = 4;
        minimum_spanning_tree_prim_algorithm b1 = new minimum_spanning_tree_prim_algorithm(V);

        b1.insert();

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        b1.primAlgo(visited);
    }
}

/*
 * it must be weighted & undirected , connected graph
 */
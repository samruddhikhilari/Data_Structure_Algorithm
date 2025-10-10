import java.util.ArrayList;
import java.util.PriorityQueue;

public class shortest_path_bellman_ford_algo {

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

    shortest_path_bellman_ford_algo(int n) {
        V = n;
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void insert() {
        graph[0].add(new Vertex(0, 1, 2));
        graph[0].add(new Vertex(0, 2, 4));

        graph[1].add(new Vertex(1, 2, -1));
        graph[1].add(new Vertex(1, 3, 7));

        graph[2].add(new Vertex(2, 4, 3));

        graph[3].add(new Vertex(3, 5, -1));

        graph[4].add(new Vertex(4, 3, 2));
        graph[4].add(new Vertex(4, 5, 5));

    }

    public void shortPath(int start) {

        int dis[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (i != start) {
                dis[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < V; i++) {
            // access childs
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Vertex vertex = graph[j].get(k);

                    int u = vertex.sou;
                    int v = vertex.des;

                    if (dis[u] != Integer.MAX_VALUE && dis[u] + vertex.weight < dis[v]) {
                        dis[v] = dis[u] + vertex.weight;
                    }
                }
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.print(" " + dis[i]);
        }
    }

    public static void main(String[] args) {
        int V = 6;
        shortest_path_bellman_ford_algo b1 = new shortest_path_bellman_ford_algo(V);

        b1.insert();

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        b1.shortPath(0);

    }
}

/*
 *** bellman ford algorithm
 * here we as dijstras's does we can do + where dijkastrajs algo properly not
 * works on -ve val i work very much perfectly there so i have more TC compare
 * to it
 * i am a Dynamic programming approach
 * where to find min cost of dest it's source instead of assiging only the min
 * out of all like as the greedy ness
 * i work v-1 times where each parent have chance to check it's cost from it to
 * the child if it's min it will be changed.
 * 
 * 
 * approach
 * do V-1 times traversing of graph's childs where each time check it
 * dis[parent]+weight < dis[child] if it's then changed the child
 * once child get min distance what the values of distance array's elements will
 * be unchangable but although
 * we loop for v-1 time on each vertex
 * so TC =(v*(V+E))
 ** 
 * task
 * 1.loop 1st for V-1 & 2nd for getting all the child with 2 loop first on array
 * & 2nd on it's individual arraylist
 * 2.each time for child check the cost
 */
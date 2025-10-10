import java.util.ArrayList;
import java.util.PriorityQueue;

public class shortest_path_dijkastras_algo {

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

    shortest_path_dijkastras_algo(int n) {
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

    public void shortPath(int start, boolean visited[]) {

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        int[] dis = new int[V];
        for (int i = 1; i < V; i++) {
            dis[i] = Integer.MAX_VALUE;
        }

        queue.add(new Pair(start, 0));

        while (!queue.isEmpty()) {

            Pair curr = queue.remove();

            if (!visited[curr.node]) {
                visited[curr.node] = true;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Vertex ver = graph[curr.node].get(i);

                    if (!visited[ver.des]) {

                        int u = ver.sou;
                        int v = ver.des;

                        if (dis[u] + ver.weight < dis[v]) { // relaxation
                            dis[v] = dis[u] + ver.weight;
                            queue.add(new Pair(v, dis[v]));
                        }
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
        shortest_path_dijkastras_algo b1 = new shortest_path_dijkastras_algo(V);

        b1.insert();

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                b1.shortPath(i, visited);
            }
        }

    }
}

/*
 ** Shortes path from source to each node
 * path with normal existing cost is there but we have to print out of multiple
 * paths what will be an shortes path to reach from source to the dest^n vertex
 * just that's it
 * means this is an greedy algorithm approach works graph (only for +ve
 * weightes).
 * 
 * to calculate cost don't go randomaly
 * go step by step as if particular node in graph having multiple reachable
 * points right
 * but which one will be the shortest one if think technically which node comes
 * (reach outs first) while traversing the weight it give always will be minimum
 * than other nodes
 * 
 * 
 * 1. go for bfs traversing go level by level [target reaches by the minimum
 * cost sources that's why]
 * but out of multiple level nodes we select for the first one but what about if
 * multiple are exists at same level then
 * there comes the greedy approach
 * where
 * 2. use priority queue exists which stores the node with each cost estimated
 * by it's parent
 * that't the work of queue
 * but what is priority does as it says out of muliple select only the minimum
 * so priority on cost for each node will be given
 ** 
 * 
 * approach
 * 1. bfs traversing
 * 2. build prioirity queue
 * add nodes , remove upto it doesn't get empty
 * if it is mean we come out at that parent where his all childs are visited by
 * selecting min cost
 * 3. build structure for the nodes of prioirity queue
 * 4. one visited array & final min dist array
 * why array why not after finding directly print
 * becau cost for 2 find by 1 i.e 1--->2(cost as 10) at first min
 * but same when 3---->2 with cost 5 now min is 5 that's why
 */
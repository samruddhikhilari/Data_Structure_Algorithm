import java.util.ArrayList;
import java.util.Stack;

public class simple_connected_components_kosarajus_algo {

    public class Vertex {
        int sou;
        int des;

        Vertex(int s, int d) {
            this.sou = s;
            this.des = d;
        }
    }

    ArrayList<Vertex> graph[];
    int V;

    simple_connected_components_kosarajus_algo(int n) {
        V = n;
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void insert() {
        graph[0].add(new Vertex(0, 1));

        graph[1].add(new Vertex(1, 2));
        graph[1].add(new Vertex(1, 3));

    }

    public void topSort(int start, boolean visited[], Stack<Integer> revStack) {
        visited[start] = true;

        for (int i = 0; i < graph[start].size(); i++) {
            Vertex vertex = graph[start].get(i);

            if (!visited[vertex.des]) {
                topSort(vertex.des, visited, revStack);
            }
        }

        revStack.push(start);
    }

    public void reverse(ArrayList<Vertex> revGraph[]) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Vertex vertex = graph[i].get(j);

                revGraph[vertex.des].add(new Vertex(vertex.des, vertex.sou));

            }
        }

    }

    public void dfs(ArrayList<Vertex> revGraph[], int start, boolean visited[]) {
        visited[start] = true;
        System.out.print(" " + start);

        for (int i = 0; i < revGraph[start].size(); i++) {
            Vertex vertex = revGraph[start].get(i);

            if (!visited[vertex.des]) {
                dfs(revGraph, vertex.des, visited);
            }
        }
    }

    public void scc() {
        boolean visited[] = new boolean[V];
        // step1: reversed order of the vertexes
        Stack<Integer> revStack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topSort(i, visited, revStack);
                System.out.println();
            }
        }

        // step2:
        ArrayList<Vertex> revGraph[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
            revGraph[i] = new ArrayList<>();
        }
        reverse(revGraph);

        // step3:
        while (!revStack.isEmpty()) {
            int ele = revStack.pop();

            if (!visited[ele]) {
                dfs(graph, ele, visited);
            }
        }
    }

    public static void main(String[] args) {
        int V = 4;
        simple_connected_components_kosarajus_algo b1 = new simple_connected_components_kosarajus_algo(V);

        b1.insert();
        b1.scc();
    }
}

/*
 * It must be directed graph bcoz in directed bidirectional traversing exists.
 * weighted or unweighted not important
 */

/*
 * kosaraju's algorithm
 * approach
 * 1.forming the graph with vertex having min cost i.e selection of vertex as
 * child will handle by the greedy approach priority queue.
 * 2. in priority queue that nodes will present which traversed by their parent
 * & their is no modification in the cost of their cost
 * what's requires find that nodes handled by the priority queue only the
 * approved nodes from it get their cost & add in global variable & show it
 */

/*
 *** Steps :
 * 1) have rev.stack
 * 2) do dfs traversing on rev.stack's nodes on the reversed graph
 * 3) build reversed graph
 */
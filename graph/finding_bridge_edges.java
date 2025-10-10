import java.util.ArrayList;
import java.util.Stack;

public class finding_bridge_edges {

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

    finding_bridge_edges(int n) {
        V = n;
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void insert() {
        graph[0].add(new Vertex(0, 1));
        graph[0].add(new Vertex(0, 2));
        graph[0].add(new Vertex(0, 3));

        graph[1].add(new Vertex(1, 0));
        graph[1].add(new Vertex(1, 2));

        graph[2].add(new Vertex(2, 0));
        graph[2].add(new Vertex(2, 1));

        graph[3].add(new Vertex(3, 0));
        graph[3].add(new Vertex(3, 4));
    }

    public void bridge(int start, boolean visited[], int parent, int time, int dis[], int low[]) {

        visited[start] = true;
        dis[start] = low[start] = ++time;

        for (int i = 0; i < graph[start].size(); i++) {
            Vertex vertex = graph[start].get(i);

            if (vertex.des == parent) { // parent as the parent i.e source of traversing
                continue;
            } else if (!visited[vertex.des]) {
                // filling dis & low val's of childs
                bridge(vertex.des, visited, start, time, dis, low);

                // now start is an part of
                low[start] = Math.min(low[vertex.des], low[start]);

                // bridge condition
                if (dis[start] < low[vertex.des]) {
                    System.out.println("Bridge :" + start + "--->" + vertex.des);
                }
            } else { // if node is visited by any other parent i.e start to vertex.des can't be only
                     // single path means (Bridge)
                low[start] = Math.min(low[start], dis[vertex.des]);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        finding_bridge_edges b1 = new finding_bridge_edges(V);

        b1.insert();
        int discovering[] = new int[V];
        int lowestTraversing[] = new int[V];

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            b1.bridge(i, visited, -1, 0, discovering, lowestTraversing);
        }
    }
}

/*
 *** if your node A --->B & if you are saying that's it's the bridge in betn graph
 * component of A & the B which means Traversing of the graph vertexes from B
 * will go only from the Vertex A
 * which means if yet A not traversed then B & it's graph components are also
 * not traversed so.
 * so for that we calculates the discovering time for each node as where if
 * A---->B & it's child then just as of that simple it's discovering time of A
 * will definetely less than the B
 * but B graph have number of componets if they connected through any other node
 * from A group so
 * A --->B will not says as the bridge
 * so to state A---->B for the bridge condition here B's only discovering time
 * is not imp here all the time required by the B's vertex that's also imp &
 * that's measure by the min or starting time taken by them nodes
 * so when dis[A] < low[B] then only it can be the bridge
 * child cond^n
 */

/*
 * 1. when node as the parent don't do anything
 * 2. when node as the non visited then
 * a. traversed for that nodes & it's childs means it discovering & lowest time
 * for neighbours & it self node
 * b. now means that b is one of the vertex into the component so as per (lowest
 * time for neighbours & it self node) this change
 * low[A]=min(low[A],low[B])
 **** it can be the bridge edge
 * c. dis[A] < low[B]
 */
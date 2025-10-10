import java.util.ArrayList;
import java.util.Stack;

public class findi_articulation_point {

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

    findi_articulation_point(int n) {
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

        graph[4].add(new Vertex(4, 3));
    }

    public void articulationPoint(int start, boolean visited[], int parent, int time, int dis[], int low[],
            boolean ap[]) {

        visited[start] = true;
        dis[start] = low[start] = ++time;
        int child = 0;

        for (int i = 0; i < graph[start].size(); i++) {
            Vertex vertex = graph[start].get(i);
            if (parent == vertex.des) {
                continue;
            } else if (!visited[vertex.des]) {
                articulationPoint(vertex.des, visited, start, time, dis, low, ap);

                low[vertex.sou] = Math.min(low[vertex.sou], low[vertex.des]);

                if (dis[vertex.sou] <= low[vertex.des]) {
                    ap[vertex.sou] = true;
                }
                child++;

            } else {
                low[start] = Math.min(low[start], low[vertex.des]);
            }
        }

        if (parent == -1 && child > 1) {
            ap[start] = true;
        }
    }

    public static void main(String[] args) {
        int V = 5;
        findi_articulation_point b1 = new findi_articulation_point(V);

        b1.insert();
        int discovering[] = new int[V];
        int lowestTraversing[] = new int[V];
        boolean articulationP[] = new boolean[V];

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            b1.articulationPoint(i, visited, -1, 0, discovering, lowestTraversing, articulationP);
        }

        System.out.println("Articulation Points :");
        for (int i = 0; i < V; i++) {
            if (articulationP[i]) {
                System.out.print(" " + i);
            }
        }
    }
}

/*
 *** articulation point:
 * the point if get removed count of graph's components will be get +ve
 * the AP can be any vertex from our graph as the middle node or the starting
 * parent node
 * like graph traversing started from the 0th node so here it can be the AP if
 * 1. 0th parent =-1;
 * 2. having child count >1
 * 3. child which are in disconnected fromat bcoz 1 as parent 1--->2 1--->3 but
 * 3--->2 also then if 1 get delete although 3--->2 will be there
 */
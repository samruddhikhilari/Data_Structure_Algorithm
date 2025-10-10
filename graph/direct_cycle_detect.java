import java.util.*;

public class direct_cycle_detect {

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

    direct_cycle_detect(int n) {
        this.n = n;
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void insert() {

        graph[0].add(new Vertex(0, 1));

        graph[1].add(new Vertex(1, 2));

        graph[3].add(new Vertex(3, 4));

        graph[4].add(new Vertex(4, 5));
        graph[4].add(new Vertex(4, 1));

    }

    public boolean cycle(int start, boolean visited[], boolean recStack[]) {
        visited[start] = true;
        recStack[start] = true;

        for (int i = 0; i < graph[start].size(); i++) {
            Vertex v = graph[start].get(i);

            if (recStack[v.des]) {
                return true;
            } else if (cycle(v.des, visited, recStack))
                return true;
        }
        recStack[start] = false;
        return false;
    }

    public static void main(String[] args) {

        int n = 6;
        direct_cycle_detect b1 = new direct_cycle_detect(n);

        b1.insert();
        boolean visited[] = new boolean[n];
        boolean recStack[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                if (b1.cycle(i, visited, recStack)) {
                    System.out.println("Cycle present into the given graph");
                    return;
                }
                System.out.println("ch");

            }
        }
        System.out.println("Cycle not present ");
    }
}

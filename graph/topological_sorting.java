import java.util.ArrayList;
import java.util.Stack;

public class topological_sorting {

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

    topological_sorting(int n) {
        V = n;
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void insert() {

        graph[2].add(new Vertex(2, 3));

        graph[3].add(new Vertex(3, 1));

        graph[4].add(new Vertex(4, 0));
        graph[4].add(new Vertex(4, 1));

        graph[5].add(new Vertex(5, 0));
        graph[5].add(new Vertex(5, 2));

    }

    public void topSort(int start, boolean visited[], Stack<Integer> revStack) {
        visited[start] = true;

        for (int i = 0; i < graph[start].size(); i++) {
            Vertex v = graph[start].get(i);
            if (!visited[v.des]) {
                topSort(v.des, visited, revStack);
            }
        }
        revStack.push(start);
    }

    public static void main(String[] args) {
        int V = 6;
        topological_sorting b1 = new topological_sorting(V);

        b1.insert();

        boolean visited[] = new boolean[V];
        Stack<Integer> revStack = new Stack<>();
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                b1.topSort(i, visited, revStack);
            }
        }

        System.out.println("Topological Order: ");
        while (!revStack.isEmpty()) {
            System.out.print(" " + revStack.pop());
        }
    }
}

/*
 *** Topological sort
 * arrangement of vertex with linear order
 * linear order?
 * which is this is like ascending or the descending yes it is just like them as
 * an specific order
 * where if u---->v then
 * while traversing or printing the vertexes of the graph u will be all well
 * before the v vertex as of that.
 * 
 * ex in real world to execute particular task we have set of steps but they are
 * in stepwise format where as
 * 2nd step will done when only 1st will be complete like wise
 * like
 * 1 ----->2 ---->4
 * 3 ----->2------>4
 * means for completion of 2 first 1 & 3 must complete & to reach out to 4 first
 * 2 must be complete like that
 * 
 * if this senario build in graph DS then it will required the directed graph or
 * the vertex by having weight(cost) doesn't matters more
 ** 
 * 
 * approach
 * 1.build the directed graph
 * 2. traversed graph by dfs way while traversing if all childs done then add
 * parent into the rev.stack
 * 3. after traversing all the disconnected or the connected graph at the end we
 * will have a rev.stack full of elements
 * 4. pop each element from the stack & then print it
 *** note 4 must be after all the vertex present into the arrlist becomes visi
 * =false
 * then only result will be the correct one
 */

import java.util.Stack;

public class queue_by_2_stacks {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    queue_by_2_stacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    void add(int val) {

        // front & rear ends shift all ele's to insert ele at rear end
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(val);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public static void main(String args[]) {
        queue_by_2_stacks q1 = new queue_by_2_stacks();
        q1.add(11);
        q1.add(12);
        q1.add(13);
        q1.add(14);
        System.out.println(q1.stack1);
    }
}

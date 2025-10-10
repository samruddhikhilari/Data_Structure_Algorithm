import java.util.Stack;

class stack_collection_frameworks {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(7);

        System.out.println("Stacks ele's are :");
        while (!stack.isEmpty()) {
            System.out.println(" " + stack.peek());
            stack.pop();
        }
    }
}
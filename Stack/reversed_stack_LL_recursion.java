import java.util.Stack;

public class reversed_stack_LL_recursion {
    Stack<Integer> stack;

    public void create() {
        stack = new Stack<Integer>();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println(stack);
    }

    public void pushBottom(Stack<Integer> mystack, int val) {
        if (mystack.isEmpty()) {
            mystack.push(val);
            return;
        }
        int topval = mystack.pop();
        pushBottom(mystack, val);
        mystack.push(topval);
    }

    public void reverse() {
        if (stack.isEmpty()) {
            return;
        }
        int topval = stack.pop();
        reverse();
        pushBottom(stack, topval);
    }

    public static void main(String aargs[]) {
        reversed_stack_LL_recursion obj = new reversed_stack_LL_recursion();
        obj.create();
        obj.reverse();
        System.out.println(obj.stack);
    }
}

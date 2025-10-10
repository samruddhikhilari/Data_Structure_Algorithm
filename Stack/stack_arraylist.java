import java.util.ArrayList;

class stack_arraylist {
    int top;
    ArrayList<Integer> stack = new ArrayList<Integer>();

    stack_arraylist() {
        top = -1;
    }

    // push
    void push(int val) {
        stack.add(val);
        top++;
    }

    // pop
    boolean isEmpty() {
        return (top == -1);
    }

    void pop() {
        if (!isEmpty()) {
            int val = stack.get(top);
            top--;
            System.out.println("Deleted element is :" + val);
        } else {
            System.out.println("Sorry Stack is underflow");
        }
    }

    // peek
    void peek() {
        if (!isEmpty()) {
            System.out.println("stack top ele : " + stack.get(top));
        } else {
            System.out.println("Sorry Stack is Empty");
        }
    }

    // print
    void print() {
        if (!isEmpty()) {
            for (int i = top; i >= 0; i--) {
                System.out.println(stack.get(i));
            }
        } else {
            System.out.println("Sorry Stack is Empty");
        }
    }

    public static void main(String args[]) {
        stack_arraylist s1 = new stack_arraylist();
        s1.push(12);
        s1.push(2);
        s1.push(38);
        s1.push(298);
        s1.push(30);
        s1.push(23);
        s1.print();
    }
}
/*
 * 1.push
 * 2.pop
 * 3.peek
 */
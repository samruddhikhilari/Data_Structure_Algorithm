import java.util.Vector;

class stack_vector {
    int top;
    Vector<Integer> stack = new Vector<Integer>();

    stack_vector() {
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
            int val = stack.remove(top--);
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
            System.out.println("Stack Elements is :");
            for (int i = top; i >= 0; i--) {
                System.out.print(" " + stack.get(i));
            }

            System.out.println();
        } else {
            System.out.println("Sorry Stack is Empty");
        }
    }

    public static void main(String args[]) {
        stack_vector s1 = new stack_vector();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.push(5);
        s1.print();
    }
}
/*
 * 1.push
 * 2.pop
 * 3.peek
 */
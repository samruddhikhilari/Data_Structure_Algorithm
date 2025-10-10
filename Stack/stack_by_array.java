class stack_by_array {
    int top;
    int n;
    int stack[];

    stack_by_array(int size) {
        top = -1;
        n = size;
        stack = new int[n];
    }

    // push
    boolean isFull() {
        return (top == n - 1);
    }

    void push(int val) {
        if (!isFull()) {
            stack[++top] = val;
        } else {
            System.out.println("sorry stack is full.");
        }
    }

    // pop
    boolean isEmpty() {
        return (top == -1);
    }

    void pop() {
        if (!isEmpty()) {
            int val = stack[top--];
            System.out.println("Deleted element is :" + val);
        } else {
            System.out.println("Sorry Stack is underflow");
        }
    }

    // peek
    void peek() {
        if (!isEmpty()) {
            System.out.println("stack top ele : " + stack[top]);
        } else {
            System.out.println("Sorry Stack is Empty");
        }
    }

    // print
    void print() {
        if (!isEmpty()) {
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        } else {
            System.out.println("Sorry Stack is Empty");
        }
    }

    public static void main(String args[]) {
        stack_by_array s1 = new stack_by_array(4);
        s1.push(12);
        s1.push(2);
        s1.push(38);
        s1.push(298);
        s1.print();
        s1.push(23);
    }
}
/*
 * 1.push
 * 2.pop
 * 3.peek
 */
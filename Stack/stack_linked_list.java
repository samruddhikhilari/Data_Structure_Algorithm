class stack_linked_list {
    class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    static Node head;

    stack_linked_list() {
        head = null;
    }

    // push
    void push(int val) {
        Node node = new Node(val);
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    // pop
    int pop() {
        Node node;

        if (head != null) {
            node = head;
            head = head.next;
            return node.data;
        }
        return -1;
    }

    // peek
    int peek() {
        if (head != null) {
            int topdata = head.data;
            return topdata;
        }
        return -1;
    }

    // print LL
    void print() {
        if (head != null) {
            Node node = head;
            System.out.print("Stack Elements are :");
            while (node != null) {
                System.out.print(" " + node.data);
                node = node.next;
            }
            System.out.println();
        } else {
            System.out.println("sorry Linked List is empty");
        }
    }

    public static void main(String[] args) {
        stack_linked_list s1 = new stack_linked_list();
        s1.push(30);
        s1.print();
        System.out.println("Top ele : " + s1.peek());
        System.out.println("Pop ele : " + s1.pop());
        System.out.println("Pop ele : " + s1.pop());

        s1.print();

    }
}
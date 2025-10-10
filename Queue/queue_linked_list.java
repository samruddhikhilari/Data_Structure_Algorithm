public class queue_linked_list {
    class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    Node front;
    Node rear;

    queue_linked_list() {
        front = null;
        rear = null;
    }

    // enqueue
    public void enqueue(int val) {
        Node node = new Node(val);
        if (rear == null) {
            rear = front = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    // dequeue
    public void dequeue() {
        if (rear == null) {
            System.out.println("Sorry there is no ele in LL");
        } else {
            // only single ele
            int top = front.data;
            System.out.println("Deleted elements is :" + top);
            if (front == rear) {
                front = rear = null;
            } else {
                front = front.next;
            }
        }
    }

    // print
    void print() {
        if (rear == null) {
            System.out.println("Sorry there is no ele in LL");
        } else {
            Node temp = front;
            System.out.println("Queue's Ele's :");
            while (temp != rear) {
                System.out.print(" " + temp.data);
                temp = temp.next;
            }
            System.out.print(" " + rear.data);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        queue_linked_list q1 = new queue_linked_list();
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q1.enqueue(4);
        q1.enqueue(5);
        q1.print();
        q1.dequeue();
        q1.print();
    }
}

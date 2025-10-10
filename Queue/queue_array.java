class queue_array {
    int queue[];
    int size;
    int front;
    int rear;

    queue_array(int n) {
        size = n;
        queue = new int[n];
        front = -1;
        rear = -1;
    }

    // add ele in queue
    boolean isFull() {
        return (rear == size - 1);
    }

    void enqueue(int val) {
        if (!isFull()) {
            if (rear == -1) {
                front++;
            }
            queue[++rear] = val;
        } else {
            System.out.println("sorry Queue is Full");
        }
    }

    // remove ele from queue
    boolean isEmpty() {
        return (rear == -1);
    }

    void dequeue() {
        if (!isEmpty()) {
            int val = queue[front];
            System.out.println("Dequeued ele is :" + val);
            if (rear == front) {
                rear = front - 1;
            } else {
                front++;
            }
        } else {
            System.out.println("sorry Queue is Empty");
        }
    }

    // display queue's elements
    public void print() {
        if (!isEmpty()) {
            System.out.println("Queue elements are :");
            for (int i = front; i <= rear; i++) {
                System.out.print(" " + queue[i]);
            }
            System.out.println();
        } else {
            System.out.println("sorry Queue is Empty");
        }
    }

    public static void main(String[] args) {
        queue_array q1 = new queue_array(5);
        q1.enqueue(23);
        q1.enqueue(11);
        q1.enqueue(99);
        q1.print();
        q1.dequeue();
        q1.print();
    }
}

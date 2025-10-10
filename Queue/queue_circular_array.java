class queue_circular_array {
    int queue[];
    int size;
    int front;
    int rear;

    queue_circular_array(int n) {
        size = n;
        queue = new int[n];
        front = -1;
        rear = -1;
    }

    // add ele in queue
    boolean isFull() {
        return ((rear + 1) % size == front);
    }

    void enqueue(int val) {
        if (!isFull()) {
            if (rear == -1) {
                front = rear = 0;
                queue[rear] = val;
            } else {
                rear = (rear + 1) % size;
                queue[rear] = val;
            }
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
            if (front == rear) { // now no ele to remove
                front = -1;
                rear = -1;
            } else { // having ele's to remove
                front = (front + 1) % size;
            }
        } else {
            System.out.println("sorry Queue is Empty");
        }
    }

    // display queue's elements
    public void print() {
        if (!isEmpty()) {
            System.out.println("Queue elements are :");
            int i = front;
            while (i != rear) {
                System.out.print(" " + queue[i]);
                i = (i + 1) % size;
            }
            System.out.print(" " + queue[rear]);
            System.out.println();
        } else {
            System.out.println("sorry Queue is Empty");
        }
    }

    public static void main(String[] args) {
        queue_circular_array q1 = new queue_circular_array(5);
        q1.enqueue(99);
        q1.enqueue(88);
        q1.enqueue(77);
        q1.enqueue(66);
        q1.enqueue(55);
        q1.print();
        q1.dequeue();
        q1.enqueue(22);
        q1.print();
    }
}

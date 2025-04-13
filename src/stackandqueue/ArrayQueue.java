package src.stackandqueue;

// 큐를 배열로 구현한 코드
public class ArrayQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    public ArrayQueue(int size) {
        queue = new int[size];
        front = 0;
        rear = -1;
        capacity = size;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
        }
        else {
            rear = (rear + 1) % capacity;
            queue[rear] = item;
            size++;
        }
    }
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        else {
            int item = queue[front];
            front = (front + 1) % capacity;
            size--;
            return item;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        else {
            return queue[front];
        }
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }else {
            System.out.print("Queue: ");
            for (int i = 0; i < size; i++) {
                int index = (front + i) % capacity;
                System.out.print(queue[index] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.printQueue(); //Queue: 1 2 3
        queue.dequeue();
        queue.printQueue(); //Queue: 2 3
        System.out.println(queue.peek()); //2
    }

}

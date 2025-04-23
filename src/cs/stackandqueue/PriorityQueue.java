package src.cs.stackandqueue;

import java.util.Arrays;

// 최소 힙 동작하는 우선순위 큐
public class PriorityQueue {
    private int[] heap;
    private int size;
    private int capacity;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2; // 부모 노드 찾기
            if (heap[parent] <= heap[index]) {
                break;
            }  // 부모가 더 작으면 break

            int temp = heap[parent];
            heap[parent] = heap[index]; // 부모랑 change
            heap[index] = temp;
            index = parent;
        }
    }

    private void heapifyDown(int index) {
        while (index < size){
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int smallest = index;
            if (left < size && heap[left] < heap[smallest]) { smallest = left; } // 왼쪽 자식이 있고, 왼쪽 자식이 현재보다 작으면
            if (right < size && heap[right] < heap[smallest]) { smallest = right; } // 오른쪽 자식도 있고, 오른쪽 자식이 현재보다 작으면
            if (smallest == index) { break;}

            int temp = heap[index];
            heap[index] = heap[smallest];
            heap[smallest] = temp;
            index = smallest;
        }
    }

    public void offer(int value){
        if(isFull()){
            return;
        }
        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    public int poll(){
        if(isEmpty()){
            return -1;
        }
        int min  = heap[0];
        heap[0] = heap[size-1];
        size--;
        heapifyDown(0);
        return min;
    }
    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return heap[0];
    }

    public void print(){
        System.out.println("Priority Queue: " + Arrays.toString(Arrays.copyOf(heap, size)));
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.offer(3);
        priorityQueue.offer(2);
        priorityQueue.print(); //Priority Queue: [2, 3]
        priorityQueue.offer(1);
        priorityQueue.print(); // Priority Queue: [1, 3, 2]
        priorityQueue.poll();
        priorityQueue.print(); //Priority Queue: [2, 3]
        System.out.println("peek: " + priorityQueue.peek()); //peek: 2
    }
}

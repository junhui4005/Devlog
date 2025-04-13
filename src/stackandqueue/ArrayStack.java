package src.stackandqueue;

// 스택을 배열로 구현한 코드
public class ArrayStack {
    private int [] stack;
    private int top;
    private int capacity;

    public ArrayStack(int size) {
        stack = new int[size];
        top = -1;
        capacity = size;
    }

    public void push(int x) {
        if (isFull()) {
        return;
    }
        stack[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return stack[top];
    }

    public int size() {
        return top + 1;
    }
    public boolean isFull(){
        return top == capacity-1;
    }

    public boolean isEmpty() {
        return top == - 1;
    }

    public void print() {
        System.out.print("stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3); // 1 2 3
        stack.print();
        stack.pop();
        stack.print(); //1 2
        System.out.println(stack.peek()); // 2
    }

}

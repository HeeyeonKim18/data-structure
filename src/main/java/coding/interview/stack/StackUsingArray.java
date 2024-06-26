package coding.interview.stack;

public class StackUsingArray {
    private final int MAX = 1000;
    int[] arr = new int[MAX]; // it has limited space
    private int pointer = -1;

    private String peek(){
        if(isEmpty()) return "nothing";
        return String.valueOf(arr[pointer]);
    }

    private void push(int value){
        if(pointer >= MAX) return;
        new StackOverflowError();
        pointer++;
        arr[pointer] = value;
    }

    private String pop(){
        if(isEmpty()) return "nothing";
        int result = arr[pointer];
        arr[pointer] = 0;
        pointer--;
        return String.valueOf(result);
    }
    
    private String list(){
        String str = "";
        if (isEmpty()) return "nothing";
        for (int i = 0; i <= pointer; i++){
            str += " " + arr[i];
        }
        return str;
    }

    private boolean isEmpty(){
        return pointer == -1;
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray();
        stack.push(2);
        stack.push(4);
        stack.push(8);
        System.out.println("stack.peek() = " + stack.peek()); // result = 8
        System.out.println("stack.pop() = " + stack.pop()); // result = 8
        stack.push(3);
        System.out.println("stack.list() = " + stack.list());
        System.out.println("stack.pop() = " + stack.pop()); // result = 3
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.peek() = " + stack.peek());
        System.out.println("stack.list() = " + stack.list());
    }
}

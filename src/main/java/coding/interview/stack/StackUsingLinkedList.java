package coding.interview.stack;

public class StackUsingLinkedList {

    private Node top;
    private Node bottom;
    private int length;

    public StackUsingLinkedList() {
        this.length = 0;
    }

    public String peek(){
        if(isEmpty()) return "nothing";
        return top.toString();
    }

    public void push(int value){
        Node newNode = new Node(value);
        if(isEmpty()){
            top = newNode;
            bottom = newNode;
        }else{
            Node holdingPointer = top;
            top = newNode;
            top.next = holdingPointer;
        }
        length++;
    }

    public String pop(){
        if(top == null) return "nothing";
        if(top == bottom) bottom = null;
        Node result = top;
        top = top.next;
        length--;
        return result.toString();
    }

    public boolean isEmpty(){
        return length == 0;
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(2);
        stack.push(4);
        stack.push(8);
        System.out.println("stack.peek() = " + stack.peek()); // result = 8
        System.out.println("stack.pop() = " + stack.pop()); // result = 8
        stack.push(3);
        System.out.println("stack.pop() = " + stack.pop()); // result = 3
    }
}

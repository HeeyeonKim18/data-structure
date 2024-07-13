package coding.interview.data.queue;

public class QueueUsingLinkedList {

    private Node first;
    private Node last;
    private int length;

    public QueueUsingLinkedList() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public String peek(){
        if(isEmpty()) return "nothing";
        return last.toString();
    }

    public void enqueue(String value){
        Node newNode = new Node(value);
        if(isEmpty()){
            first = newNode;
            last = newNode;
        }else{
            Node holdingPointer = last;
            last = newNode;
            holdingPointer.next = newNode;
        }
        length++;
    }

    public String dequeue(){
        if(isEmpty()) return "nothing";
        if(first == last) last = null;
        Node result = first;
        first = first.next;
        length--;
        return result.toString();
    }

    public boolean isEmpty(){
        return length == 0;
    }

    private class Node{
        private String value;
        private Node next;

        public Node(String value) {
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
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.enqueue("Joy");
        queue.enqueue("Matt");
        queue.enqueue("Pavel");
        System.out.println("stack.peek() = " + queue.peek()); // result = Pavel
        System.out.println("stack.dequeue() = " + queue.dequeue()); // result = Joy
        queue.enqueue("Samir");
        System.out.println("stack.dequeue() = " + queue.dequeue()); // result = Matt
    }
}

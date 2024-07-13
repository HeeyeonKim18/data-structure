package coding.interview.data.linkedlist;

/**
 * implement LinkedList
 */
public class LinkedListMethod {

    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    /*
    adding an element at first
     */
    public void addFirst(int data){
        Node node = new Node(data);

        node.next = head;
        head = node;
        size++;

        if(head.next == null) tail = head;
    }

    /*
    adding an element
     */
    public void add(int idx, int data){
        if(idx == 0) addFirst(idx);
        else{
            Node previousNode = find(idx - 1);
            Node nextNode = previousNode.next;

            Node node = new Node(data);
            previousNode.next = node;
            node.next = nextNode;
            size++;

            if(node.next == null) tail = node;
        }
    }

    public void add(int data){
        Node newNode = new Node(data); //노드 생성

        if(size == 0) //리스트의 노드가 없는 경우, 첫번째 노드로 추가하는 메소드 사용
            addFirst(data);
        else {
            tail.next = newNode; //마지막 노드의 다음 노드로 생성한 노드를 지정
            tail = newNode; //마지막 노드를 갱신
            size++;
        }
    }

    public int removeFirst(){
        Node temp = head;
        head = temp.next;

        int returnData = temp.data;
        temp = null;
        size--;
        return returnData;
    }

    /*
    removing a desired data using an index
     */
    public int remove(int idx){
        if(idx == 0) return removeFirst();
        else{
            Node previousNode = find(idx - 1);
            Node nowNode = previousNode.next;
            previousNode.next = previousNode.next.next;

            int result = nowNode.data;
            if(nowNode == tail) tail = previousNode;

            nowNode = null;
            size--;
            return result;
        }
    }

    /*
    getting a desired data using an index
     */
    public int get(int idx){
        return find(idx).data;
    }

    /*
     * printing LinkedList elements as a String
     */
    public String printList(){
        if(head == null) return "-1";

        Node temp = head;
        String str = " ";

        while(temp != null){
            str += temp.data + " ";
            temp = temp.next;

        }
        
        return str;
    }

    /*
    LinkedList size
     */
    public int size(){
        return size;
    }

    /*
    finding a desired element using an index
     */
    private Node find(int idx) {
        Node findNode = head;

        for(int i = 0; i < idx; i++){
            findNode = findNode.next;
        }

        return findNode;
    }

    public static void main(String[] args) {
        LinkedListMethod list = new LinkedListMethod();
        list.addFirst(2);
        list.add(99);
        list.add(37);
        list.add(1, 6);
        System.out.println(list.printList());
        list.removeFirst();
        list.remove(1);
        System.out.println(list.printList());
        System.out.println("list.size() = " + list.size());
        list.add(4);
        System.out.println(list.get(2));
    }
}

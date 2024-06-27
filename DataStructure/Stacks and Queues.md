# Stacks and Queues

### Stack

A stack is a linear data structure that follows the Last-In-First-Out(LIFO) principle. It behaves like a stack of plates, where the plate added is the first one to be removed.

- Push: An element onto the stack is like adding a new plate on top.
- Pop: An element removes the top plate from the stack.

### Where is used for ?

- When we want to know the last value
- Language engines
- Browser histories

### Time Complexity

Lookup: O(n)

Push: O(1)

Pop: O(1)

Peek: O(1)

---

### Queue

A queue is a linear data structure that follows the First-In-First-Out(FIFO) principle. It operates like a line where elements are added at one end(rear) and removed from the other end(front)

- Enqueue(Insert): Adds an element to the rear of the queue.
- Dequeue(Delete): Removes and returns the elements from the front of the queue.
- Peak: Returns the element at the front of the queue without removing it.

### Where is used for ?

- Printer
- Uber, Restaurant app, Concert tickets

### Time Complexity

Lookup: O(n)

Enqueue: O(1)

Dequeue: O(1)

Peek: O(1)

---

### Build  a Stack and a Queue using an Array and a Linked List

An Array and a Linked List both work to build a Stack. But we have to think about the pros and cons of the both data structures and what the priority is and where a Stack is used for.

However, when we build a Queue, a Linked List is efficient since an Array has index and we have to shift the index over when removing the first element. On the other hand, as a Linked List doesn’t have an index and it contains the next node to point to the next elements, it is faster to access the next item.

---

### Coding test

- https://leetcode.com/problems/implement-queue-using-stacks/submissions/1301420735/
    
    ```java
    class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        int front;
    
        public MyQueue() {
            stack1 = new Stack();
            stack2 = new Stack();
        }
        
        public void push(int x) {
            if(stack1.empty()) front = x;
            while(!stack1.empty()) stack2.push(stack1.pop());
            stack2.push(x);
            while(!stack2.isEmpty()) stack1.push(stack2.pop());
        }
        
        public int pop() {
          int res = stack1.pop();
          if(!stack1.empty()) front = stack1.peek();
          return res;
        }
        
        public int peek() {
            return front;
        }
        
        public boolean empty() {
            return stack1.isEmpty();
        }
    }
    
    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
    ```
    
    Using one stack as our main data structure for the queue operations, and one helper stack for the push & pop operations.
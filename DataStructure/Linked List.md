# Linked List

Two Types: Singly LinkedList, Doubly LinkedList

---

### Problems when using Arrays and HashTables

Limited space: when we need more memory in a array, there is a performance implication. It costs as O(n).

Unsorted datas: When using HashTables, it is not in order

### To solve these problems: LinkedList

- Linked lists and nodes are scattered all over memory, kind of like HashTables
- Inserting and deleting is faster then array if the desired data is in the middle of the list
- It is in order
- As the name suggests, it is the list that is linked and it contains a set of nodes.

The LinkedList stores its items in “containers”. The list has a link to the first container and each container has a link to the next container in the list. To add an element to the list, the element is placed into a new container and that container is linked to one of the other containers in the list.

LinkedList is a linear data structure where the elements are not stored in contiguous locations and every element is a separate object with a data part and address part. The elements are linked using pointer and addresses, each element is known as a node.

A node has two elements: the value of data that we want to store and a pointer to the next node in line. The First node is called “head”, the last node is called “tail”.

A LinkedList is what we call “null terminated”, which signifies that it is the end of the list.

---

### Time complexity

prepend: O(1)

append: O(1)

lookUp: O(1)

insert: O(n)

delete: O(n)

### Java LinkedList methods

add()

addAll()

addFirst()

addLast()

clear()

clone()

remove()

removeFirst()

removeLast()

contains()

get()

size()

---

### Doubly Linked lists

- It is similar to singly linked lists except that it links to the node before it
- It allows us to traverse the list backwards
- Searching through a doubly linked list can be a little bit more efficient.
- Each node needs more memory to store a previous node.

Doubly Linked List is a data structure that has reference to both the previous and next nodes in the list. It provides simplicity to traverse, insert and delete the nodes in both directions in a list.

### Each node contains three data numbers

1. data: stored in the node
2. next: the reference to the next node
3. prev: the reference to the previous node

---

### Single VS Double

**Singly Linked List**

It is fairly simple implication compared to the Doubly one. It requires less memory and operation when we insert and delete a node. However, it cannot be iterated and reversed from the back to the front. So, it is useful when memory is really expensive and the main goal is that faster insertions and deletions are needed.

**Doubly Linked List**

It can be iterated and traversed both from the front or from the back. If deleting the previous node, we don’t need to traverse from the head node and find what the previous node is. However, it is quite complex to implicate and it requires more memory and storage because of the extra property, prev. Also, we need to perform extra operations. Therefore, it is good to use when we don’t need to worry about memory and we want to a good searching performance.

---

### Pros and Cons

**Pros**

Fast insertion: no need to shift all elements

Fast deletion:no need to shift all elements

Ordered

Flexible size: it can grow and shrink dynamically

**Cons**

Slow lookup: traverse the list to reach the desired element

More memory: additional memory for the links
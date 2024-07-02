# Trees

- A hierarchical data structure, not linear data structure.
- It has zero or more child nodes.
- Single root node.

Tree data structure is a non-linear data structure in which a collection of elements known as nodes are connected to each other via edges such that there exists exactly one path between any two nodes.

It is a hierarchical structure that is used to represent and organize data in a way that is easy to navigate and search. And the topmost node of the tree is called the root and the nodes below it are called the child nodes.

Each node can have multiple child nodes, and these child nodes can also have their own child nodes can also their own child nodes, forming a recursive structure.

---

### Binary Trees

- A type of tress with a few roles are applied to it.
- Each node can have one or two nodes and each child can have one parent.
- Two types: perfect binary tree, full binary tree

A binary tree structure is a hierarchical data structure in which each node has at most two children, referred to as the left child and the right child. It is commonly used in computer science for efficient storage and retrieval of data, with various operations such as insertion, deletion, and traversal.

### Roles

1. When a level goes up, the node are actually doubled.
2. The number of nodes on the last level is equal to sum of the number of nodes on all the other levels plus 1, which means half of the values are on the bottom level

### Time Complexity

Lookup: O(log N)

Insert: O(log N)

Delete: O(log N)

---

### Binary Search Trees

- They are great for comparing things due to preserving relationships.

Searching and lookup is very easy to find what I am looking for and we don’t have to iterate a linear fashion through each node.

Lookup in a tree is faster than it in an array and insertion and deletion take more time than hash tables which have only O(1) time complexity since we have to find where a value will be placed.

### Roles

1. All child nodes in the tree to the right of the root node must be greater than the current node, which means if I keep going to the right, the number of the value of nodes constantly increases.
2. Nodes can only have up to two children because it is a binary tree.

### Problem

As unbalanced binary search tree, we need to keep adding  a value to the right position, which causes to have O(n) time complexity.

Lookup: O(n)

Insert: O(n)

Delete: O(n)

### Question

Why an unbalanced binary search tree is bad and how do we balance the tree?

→ AVL trees and Red & Black trees allow us to make sure that binary search trees are going to be balanced.

### Binary Search Tress Pros and Cons

**Pros(balanced)**

Better than O(n)

Ordered

Flexible size

**Cons**

No O(1) operations

---

### AVL Tree

- Height balance tree
- Binary Search Tree
- Height is the maximum depth from root to leaf

An AVL Tree defined as a self-balancing Binary Search Tree where the difference between heights of left and right subtrees for any node cannot be more than one.

### When do we use AVL Tree

- It is used to index huge records in a database and also to efficiently search in that.
- For all types of in-memory collections including sets and dictionaries, AVL Trees are used.
- Database applications, where insertions and deletions are less common but frequent data lookups are necessary.
- Software that needs optimized search.
- It is applied in corporate areas and storyline games.

### AVL Tree Pros and Cons

**Pros**

Self-balance

Not skewed

Faster lookups than Red-Black Trees

Better searching time complexity

**Cons**

Difficult to implement

High constant factors for some of operations

Less used compared to Red-Black Trees

Take more processing for balancing

---

### Red-Black Tree

The performance of Binary Search Tree can suffer if the tree becomes unbalanced. Red-Black Tree is a type of balanced Binary Search Trees that use a set of rules to maintain balance, ensuring logarithmic time complexity for operations like insertion, deletion and searching regardless of the initial shape of the tree.

So Red-Black Tree is a self-balancing Binary Search Tree where each node has an additional attribute; a color, which can be either red or black. The height of a Red-Black Tree is always O(log N) where n is the number of nodes in the tree.

### Red-Black Tree Pros and Cons

**Pros**

Self-balance

Searching time complexity O(log N)

Easy to implement and understand

Low constants in a wide scope of situations

**Cons**

Not suitable for large data set

Require extra steps to maintain the balance of the tree

### Comparison with AVL Tree

Both are self-balancing trees but AVL Tree can cause more rotations during insertion and deletion. So if your application involves frequent insertions and deletions then Red-Black Trees should be preferred. And if search is a more frequent operation, then AVL Tree should be preferred over the Red-Black Tree.

---

### Heap

A Heap is a complete Binary Tree data structure that satisfies the heap property: for every node, the value of its children is less than or equal to its own value. Heaps are usually used to implement priority queues, where the smallest(or largest) element is always at the root of the tree.

### Types of Heaps

Max heap: The root node contains the maximum value, and the values decrease as you move down the tree.

Min heap: The root node contains the minimum value, and the values increase as you move down the tree.

---

### Binary Heap

Every nodes on the top level has a greater value than every nodes on the next level down. Heap can be used in any algorithm where ordering is important.

### Time Complexity

Lookup: O(n) → In a binary heap, left and right can be any values so we have to search every nodes to find a specific value.

Insert: O(1) ~ O(log N)

Delete: O(log N)

### Binary Heap Pros and Cons

**Pros**

Better than O(n)

Priority

Flexible size

Fast insert

**Cons**

Slow lookup

---

### Priority Queue

A type of queue that arranges elements based on their priority values. Element with higher priority values are typically retrieved before elements with lower priority values. When I add an element to the queue, it is inserted in a position based on its priority value.
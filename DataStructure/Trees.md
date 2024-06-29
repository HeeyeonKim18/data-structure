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

---

### Roles

1. When a level goes up, the node are actually doubled.
2. The number of nodes on the last level is equal to sum of the number of nodes on all the other levels plus 1, which means half of the values are on the bottom level

---

### Time Complexity

Lookup: O(log N)

Insert: O(log N)

Delete: O(log N)

---

### Binary Search Trees

- They are great for comparing things due to preserving relationships.

Searching and lookup is very easy to find what I am looking for and we don’t have to iterate a linear fashion through each node.

Lookup in a tree is faster than it in an array and insertion and deletion take more time than hash tables which have only O(1) time complexity since we have to find where a value will be placed.

---

### Roles

1. All child nodes in the tree to the right of the root node must be greater than the current node, which means if I keep going to the right, the number of the value of nodes constantly increases.
2. Nodes can only have up to two children because it is a binary tree.

---

### Problem

As unbalanced binary search tree, we need to keep adding  a value to the right position, which causes to have O(n) time complexity.

Lookup: O(n)

Insert: O(n)

Delete: O(n)

---

### Question

Why an unbalanced binary search tree is bad and how do we balance the tree?

→ AVL trees and Red & Black trees allow us to make sure that binary search trees are going to be balanced.

---

### Binary Search Tress Pros and Cons

**Pros(balanced)**

Better than O(n)

Ordered

Flexible size

**Cons**

No O(1) operations
# BFS + DFS

### Searching and Traversal

- Linear Search
- Binary Search
- Depth First Search
- Breadth First Search

---

### Linear Search

In computer science, linear search or sequential search is a method of finding a target value within a list.

It sequentially checks each element of the list for the target value until a match is found or until all the elements have been searched.

In the best case scenario, we find what we’re looking for in one time because it is at the very beginning of the list, such as if we’re looking for six over here.

However, in worst case, we have to go through the entire list If we’re looking for and check every single node or if we’re looking for something that doesn’t exist, we still have to check through every single item.

It is O(n) which is not the fastest. We can’t use linear search to index websites like Google or search for friends like in Facebook since it is going to cost us a lot of time

---

### Binary Search

If a list is sorted,  we can do better than O(n) using binary search. Choose one item in the middle and if the number that we are looking for is bigger than the middle one, and we discard everything to the left of it, which it is repeated until a match is found.

This has time complexity of O(log n)

Sometimes we have to do something called traversal, which means going from node to node, either finding a specific thing or making sure that you touch every single node.

At this time, we have to use BFS and DFS

When traversing items why do we store everything in graphs or trees not just lists which are simpler?

The main benefit of searching is O(log n) time complexity compared to lists.When it comes to hash tables, these are not in order.

So trees and graph have better performance than something like an array, and they also maintain the order that we wouldn’t have otherwise with hash tables.

---

### Breadth First Search/Traversal

Go through trees or graph in a level-by-level manner

- The way breath first search works is that you start with the root node and move left to right across the second level. Then move left to right the third level and so on and so forth until you find the node you’re looking for or the tree ends.
- It uses additional memory because it is necessary to track the child nodes of all the nodes on a given level while searching that level, this means that we need to track every node and its children in order.

- Code
    
    ```java
    // BFS
    // It explores nodes level by level, ensuring that it finds the shortest path to each node in an unweighted graph.
    // Downside: The queue can become quite large if there are many child nodes at each level.
    public void traversal(){
      Node currentNode = root;
      ArrayList<Integer> list = new ArrayList<>();
      Queue<Node> queue = new LinkedList<>();
      queue.add(currentNode);
    
      while(queue.size() > 0){
          currentNode = queue.remove();
          list.add(currentNode.value);
    
          if(currentNode.left != null){
              queue.add(currentNode.left);
          }
          if(currentNode.right != null){
              queue.add(currentNode.right);
          }
      }
    
      System.out.print("Breadth First Search: ");
      for (Integer integer : list) {
          System.out.print(integer + " ");
      }
    }
    
    public void recursiveTraversal(){
      Node currentNode = root;
      ArrayList<Integer> list = new ArrayList<>();
      Queue<Node> queue = new LinkedList<>();
      queue.add(root);
      ArrayList<Integer> result = recursion(queue, list);
    
      System.out.print("\nBreadth First Search with Recursion: ");
      for (Integer integer : result) {
          System.out.print(integer + " ");
      }
    
    }
    
    private ArrayList<Integer> recursion(Queue<Node> queue, ArrayList<Integer> list){
      if(queue.size() == 0) return list;
      Node currentNode = queue.remove();
      list.add(currentNode.value);
      if(currentNode.left != null){
          queue.add(currentNode.left);
      }
      if(currentNode.right != null){
          queue.add(currentNode.right);
      }
      return recursion(queue, list);
    }
    ```
    

---

### Depth first search/Traversal

- The search follows one branch of the tree down as many levels as possible until the target node is found or the end is reached. When the search can’t go on any further, it continues at the nearest ancestor with an unexplored child.
- Depth for search has a Lower memory requirement than Breadth for Search because it is not necessary to store all the child pointers at each level, something that we’ll see when we actually code it.

- Code
    
    ```java
    // Depth First Search
    // Three ways: preOrder, inOrder, postOrder
    
    // preOrder(= 전위) (We start off with the parent and then grab the child nodes left to right.
    // It is really useful if you want to, for example, recreate a tree.
    // = [9, 4, 1, 6, 20, 15, 170]
    public void preOrder(){
      ArrayList<Integer> list = new ArrayList<>();
      ArrayList<Integer> result = traversalPreOrder(root, list);
    
      System.out.print("\nDFS pre-order: ");
      for (Integer integer : result) {
          System.out.print(integer + " ");
      }
    }
    
    private ArrayList<Integer> traversalPreOrder(Node root, ArrayList<Integer> list) {
      list.add(root.value);
      if(root.left != null){
          traversalPreOrder(root.left, list);
      }
      if(root.right != null){
          traversalPreOrder(root.right, list);
      }
      return list;
    }
    
    // inOrder(= 중위)
    // If you have a binary search tree like this, it is really useful
    // = [1, 4, 6, 9, 15, 20, 170]
    public void inOrder(){
      ArrayList<Integer> list = new ArrayList<>();
      ArrayList<Integer> result = traversalInOrder(root, list);
    
      System.out.print("DFS in-order: ");
      for (Integer integer : result) {
          System.out.print(integer + " ");
      }
    }
    
    private ArrayList<Integer> traversalInOrder(Node root, ArrayList<Integer> list) {
      if(root.left != null){
          traversalInOrder(root.left, list);
      }
      list.add(root.value);
      if(root.right != null){
          traversalInOrder(root.right, list);
      }
      return list;
    }
    
    // postOrder(= 후위) (Visit all the node in the left subtree then the right subtree and the root node)
    // = [1, 6, 4, 15, 170, 20, 9]
    public void postOrder(){
      ArrayList<Integer> list = new ArrayList<>();
      ArrayList<Integer> result = traversalPostOrder(root, list);
    
      System.out.print("\nDFS post-order: ");
      for (Integer integer : result) {
          System.out.print(integer + " ");
      }
    }
    
    private ArrayList<Integer> traversalPostOrder(Node root, ArrayList<Integer> list) {
      if(root.left != null){
          traversalPostOrder(root.left, list);
      }
      if(root.right != null){
          traversalPostOrder(root.right, list);
      }
      list.add(root.value);
      return list;
    }
    ```
    

---

### Question

- If you know a solution is not far from the root of the tree: BFS
    - It starts searching the closest nodes to the parent.
- If the tree is very deep and solutions are rare: BFS
    - DFS with recursive functions can take a long time because of the tree's depth. But BFS needs more memory requirements.
- If the tree is very wide: DFS
    - BFS might take up too much memory.
- If solutions are frequent but located deep in the tree: DFS
    - We’ll be able to find an answer quicker than BFS.
- Determining whether a path exists between two nodes: DFS
    - That is what Depth first search is built for.
- Finding the shortest path: BFS

---

### Coding Test

- https://leetcode.com/problems/validate-binary-search-tree/
    
    Given the `root` of a binary tree, *determine if it is a valid binary search tree (BST)*.
    
    A **valid BST** is defined as follows:
    
    - The left  of a node contains only nodes with keys **less than** the node's key.
        
        subtree
        
    - The right subtree of a node contains only nodes with keys **greater than** the node's key.
    - Both the left and right subtrees must also be binary search trees.
    
    ```java
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            if(root == null) return true;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = null;
            while(root != null || !stack.isEmpty()){
                while(root != null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if(pre != null && root.val <= pre.val) return false;
                pre = root;
                root = root.right;
            }
            return true;
        }
    
    }
    ```
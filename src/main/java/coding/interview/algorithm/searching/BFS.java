package coding.interview.algorithm.searching;

import coding.interview.data.tree.BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private Node root;

    public BFS() {
        this.root = null;
    }

    public Node insert(int value){
        Node newNode = new Node(value);
        if(root == null){
            root = newNode;
            return newNode;
        }else{
            Node currentNode = root;
            while(true){
                if(value < currentNode.value){
                    //left
                    if(currentNode.left == null){
                        currentNode.left = newNode;
                        return newNode;
                    }
                    currentNode = currentNode.left;
                }else{
                    //right
                    if(currentNode.right == null){
                        currentNode.right = newNode;
                        return newNode;
                    }
                    currentNode = currentNode.right;
                }
            }
        }
    }

    public String lookup(int value){
        String result = "false";
        if(root == null){
            return result;
        }
        Node currentNode = root;
        while(currentNode != null){
            if(value < currentNode.value){
                currentNode = currentNode.left;
            }else if(value > currentNode.value){
                currentNode = currentNode.right;
            }else if(currentNode.value == value){
                result = currentNode.toString();
                return result;
            }
        }
        return result;
    }

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

    public String remove(int value){
        // traverse it until the last right node
        // remove the node that we choose to delete
        // the last right node will be a node instead of the node deleted
        // we need to change left and right node the last node
        String result = "false";
        if(root == null){
            return result;
        }
        Node currentNode = root;
        Node parentNode = null;
        while(currentNode !=null){
            if(value < currentNode.value){
                parentNode = currentNode;
                currentNode = currentNode.left;
            }else if(value < currentNode.value){
                parentNode = currentNode;
                currentNode = currentNode.right;

            }else if(currentNode.value == value){
                // no right child
                if(currentNode.right == null) {
                    if (parentNode == null) {
                        root = currentNode.left;
                    } else {
                        if (currentNode.value < parentNode.value) {
                            parentNode.left = currentNode.left;
                        } else if (currentNode.value > parentNode.value) {
                            parentNode.right = currentNode.left;
                        }
                    }
                    // Right child which doesnt have a left child
                }else if(currentNode.right.left == null){
                    currentNode.right.left = currentNode.left;
                    if (parentNode == null) {
                        root = currentNode.right;
                    } else {
                        //if parent > current, make right child of the left the parent
                        if (currentNode.value < parentNode.value) {
                            parentNode.left = currentNode.right;

                            //if parent < current, make right child a right child of the parent
                        } else if (currentNode.value > parentNode.value) {
                            parentNode.right = currentNode.right;
                        }
                    }
                }else {
                    //find the Right child's left most child
                    Node leftmost = currentNode.right.left;
                    Node leftmostParent = currentNode.right;
                    while (leftmost.left != null) {
                        leftmostParent = leftmost;
                        leftmost = leftmost.left;
                    }

                    //Parent's left subtree is now leftmost's right subtree
                    leftmostParent.left = leftmost.right;
                    leftmost.left = currentNode.left;
                    leftmost.right = currentNode.right;

                    if (parentNode == null) {
                        root = leftmost;
                    } else {
                        if (currentNode.value < parentNode.value) {
                            parentNode.left = leftmost;
                        } else if (currentNode.value > parentNode.value) {
                            parentNode.right = leftmost;
                        }
                    }
                }
                result = "true";
            }
        }
        return result;
    }

    static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {

        //     9
        //  4     20
        //1  6  15  170

        BFS tree = new BFS();
        tree.insert(9);
        tree.insert(4);
        tree.insert(20);
        tree.insert(1);
        tree.insert(6);
        System.out.println("tree.insert(15) = " + tree.insert(15));
        System.out.println("tree.insert(170) = " + tree.insert(170));
        System.out.println("tree.lookup(22) = " + tree.lookup(22)); // false
        System.out.println("tree.lookup(9) = " + tree.lookup(9));
        tree.traversal();
        tree.recursiveTraversal();
    }
}

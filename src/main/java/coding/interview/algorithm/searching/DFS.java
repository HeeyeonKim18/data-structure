package coding.interview.algorithm.searching;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFS {
    private Node root;

    public DFS() {
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

        DFS tree = new DFS();
        tree.insert(9);
        tree.insert(4);
        tree.insert(20);
        tree.insert(1);
        tree.insert(6);
        System.out.println("tree.insert(15) = " + tree.insert(15));
        System.out.println("tree.insert(170) = " + tree.insert(170));
        System.out.println("tree.lookup(22) = " + tree.lookup(22)); // false
        System.out.println("tree.lookup(9) = " + tree.lookup(9));
        tree.inOrder();
        tree.preOrder();
        tree.postOrder();
    }
}

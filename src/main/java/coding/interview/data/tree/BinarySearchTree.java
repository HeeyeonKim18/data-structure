package coding.interview.data.tree;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
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

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9);
        tree.insert(4);
        tree.insert(20);
        tree.insert(1);
        tree.insert(6);
        System.out.println("tree.insert(15) = " + tree.insert(15));
        System.out.println("tree.insert(170) = " + tree.insert(170));
        System.out.println("tree.lookup(22) = " + tree.lookup(22)); // false
        System.out.println("tree.lookup(9) = " + tree.lookup(9));
    }
}

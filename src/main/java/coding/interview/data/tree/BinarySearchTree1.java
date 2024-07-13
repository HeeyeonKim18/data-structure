package coding.interview.data.tree;

// using recursion
public class BinarySearchTree1 {

    Node root;

    public BinarySearchTree1() {
        root = null;
    }

    private Node insert(Node node, int key){
        // if the tree is empty, return a new node
        if(node == null){
            node = new Node(key);
            return node;
        }

        // recur down the tree
        if(key < node.key){
            node.left = insert(node.left, key);
        }else if(key > node.key){
            node.right = insert(node.right, key);
        }

        return node;
    }

    private Node search(Node root, int key){
        // if root is null or key is present at
        if(root == null || root.key == key){
            return root;
        }
        // key is greater than root's key
        if(root.key < key){
            return search(root.right, key);
        }
        // key is smaller than root's key
        return search(root.left, key);
    }

    static class Node{
        int key;
        Node left, right;

        public Node(int item) {
            this.key = item;
            left = right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        BinarySearchTree1 tree = new BinarySearchTree1();

        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);
        System.out.println("tree.search = " + tree.search(tree.root, 30));

    }
}

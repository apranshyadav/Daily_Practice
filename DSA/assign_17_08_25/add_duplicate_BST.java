package assign_17_08_25;

// For each node in a binary search tree, create a new duplicate node, and insert the duplicate as the left child of the original node.


// Input Format
// Enter the number of nodes N and add N more numbers to the BST


// Constraints
// None


// Output Format
// Display the tree


// Sample Input
// 3
// 2
// 1
// 3
// Sample Output
// 2 => 2 <= 3
// 1 => 2 <= END
// 1 => 1 <= END
// END => 1 <= END
// 3 => 3 <=END
// END => 3 <=END




import java.util.*;

public class add_duplicate_BST { 
    private class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    private int size;

    public add_duplicate_BST() { 
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void add(int data) {
        this.root = this.add(this.root, data);
    }

    private Node add(Node node, int data) {
        if (node == null) {
            this.size++;
            return new Node(data, null, null);
        }

        if (data > node.data) {
            node.right = add(node.right, data);
        } else if (data < node.data) {
            node.left = add(node.left, data);
        }

        return node;
    }

    public void display() {
        this.display(this.root);
    }

    public void remove(int data) {
        this.root = this.remove(this.root, data);
    }

    private Node remove(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data < node.data) {
            node.left = this.remove(node.left, data);
            return node;
        } else if (data > node.data) {
            node.right = this.remove(node.right, data);
            return node;
        } else {
            if (node.left == null && node.right == null) {
                this.size--;
                return null;
            } else if (node.left == null) {
                this.size--;
                return node.right;
            } else if (node.right == null) {
                this.size--;
                return node.left;
            } else {
                int lmax = this.max(node.left);
                node.data = lmax;
                node.left = this.remove(node.left, lmax);
                return node;
            }
        }
    }

    private int max(Node node) {
        if (node.right == null) {
            return node.data;
        }
        return max(node.right);
    }

    private void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        if (node.left != null) {
            str += node.left.data + " => ";
        } else {
            str += "END => ";
        }
        str += node.data;
        if (node.right != null) {
            str += " <= " + node.right.data;
        } else {
            str += " <= END";
        }
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public void duplicate() {
        this.duplicate(this.root);
    }

    private void duplicate(Node node) {
        if (node == null) {
            return;
        }

        duplicate(node.left);
        duplicate(node.right);

        Node originalLeft = node.left;
        Node newNode = new Node(node.data, originalLeft, null);
        node.left = newNode;
    }

    public static void main(String[] args) {
        add_duplicate_BST bst = new add_duplicate_BST(); 
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            bst.add(s.nextInt());
        }
        bst.duplicate();
        bst.display();

        s.close();
    }
}

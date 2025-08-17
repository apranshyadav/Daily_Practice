package assign_17_08_25;


// Replace each node with the sum of all greater nodes in a given BST


// Input Format
// Enter the number of nodes N and add N more numbers to the BST


// Constraints
// None


// Output Format
// Display the resulting tree


// Sample Input
// 3
// 2
// 1
// 3
// Sample Output
// 5 => 3 <= 0
// END => 5 <= END
// END => 0 <= END


import java.util.*;

public class replace_with_sum_BST { // Renamed BST to Main
    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    private int size;

    public replace_with_sum_BST() { // Renamed constructor
        this.root = null;
        this.size = 0;
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

    public void remove(int data) {
        this.root = this.remove(this.root, data);
    }

    private Node remove(Node node, int data) {
        if (node == null) {
            return null;
        }

        if (data > node.data) {
            node.right = this.remove(node.right, data);
            return node;
        } else if (data < node.data) {
            node.left = this.remove(node.left, data);
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

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void display() {
        System.out.println(this);
    }

    public int max() {
        return this.max(this.root);
    }

    private int max(Node node) {
        int rv = node.data;
        if (node.right != null) {
            rv = this.max(node.right);
        }
        return rv;
    }

    @Override
    public String toString() {
        return this.toString(this.root);
    }

    private String toString(Node node) {
        if (node == null) {
            return "";
        }
        String retVal = "";
        if (node.left != null) {
            retVal += node.left.data + " => ";
        } else {
            retVal += "END" + " => ";
        }
        retVal += node.data;
        if (node.right != null) {
            retVal += " <= " + node.right.data;
        } else {
            retVal += " <= " + "END";
        }
        retVal += "\n";
        retVal += this.toString(node.left);
        retVal += this.toString(node.right);
        return retVal;
    }

    public void replaceWLS() {
        int[] sum = new int[1];
        this.replaceWLS(this.root, sum);
    }

    private void replaceWLS(Node node, int[] sum) {
        if (node == null) {
            return;
        }
        replaceWLS(node.right, sum);
        int originalData = node.data;
        node.data = sum[0];
        sum[0] += originalData;
        replaceWLS(node.left, sum);
    }

    public static void main(String[] args) {
        replace_with_sum_BST b1 = new replace_with_sum_BST(); // Renamed BST to Main
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        while (n != 0) {
            int m = scn.nextInt();
            b1.add(m);
            --n;
        }
        b1.replaceWLS();
        System.out.println(b1);
        scn.close();
    }
}
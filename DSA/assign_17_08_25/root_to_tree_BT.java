package assign_17_08_25;

// Given a binary tree and a number k, print out all root to leaf paths where the sum of all nodes value is same as the given number.


// Input Format
// First line contains the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL. Second line contains the number k.


// Constraints
// None


// Output Format
// Display the root to leaf path whose sum is equal to k.


// Sample Input
// 10 true 20 true 30 false false true 50 false false true 40 true 60 false false true 73 false false
// 60
// Sample Output
// 10 20 30
// Explanation
// The given tree is in pre order traversal. So convert it into binary tree and check root to leaf path sum.



import java.util.*;

public class root_to_tree_BT {
    Scanner scn = new Scanner(System.in);

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
    int size;

    public root_to_tree_BT(int rootData, root_to_tree_BT leftST, root_to_tree_BT rightST) {
        this.root = new Node(rootData, null, null);
        this.root.left = leftST != null ? leftST.root : null;
        this.root.right = rightST != null ? rightST.root : null;
        this.size += leftST != null ? leftST.size : 0;
        this.size += rightST != null ? rightST.size : 0;
        this.size += 1;
    }

    public root_to_tree_BT() {
        this.root = this.takeInput(scn, null, false);
    }

    private Node takeInput(Scanner scn, Node parent, boolean isLeft) {
        int cData = scn.nextInt();
        Node child = new Node(cData, null, null);
        this.size++;
        boolean choice = scn.nextBoolean();
        if (choice) {
            child.left = this.takeInput(scn, child, true);
        }
        choice = scn.nextBoolean();
        if (choice) {
            child.right = this.takeInput(scn, child, false);
        }
        return child;
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

    public void rootToLeaf(int k) {
        rootToLeaf(this.root, k, new ArrayList<Integer>());
    }

    private void rootToLeaf(Node node, int k, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }

        path.add(node.data);

        if (node.left == null && node.right == null) {
            int currentSum = 0;
            for (int val : path) {
                currentSum += val;
            }
            if (currentSum == k) {
                for (int i = 0; i < path.size(); i++) {
                    System.out.print(path.get(i) + " ");
                }
                System.out.println();
            }
        } else {
            rootToLeaf(node.left, k, path);
            rootToLeaf(node.right, k, path);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        root_to_tree_BT b1 = new root_to_tree_BT();
        int k = b1.scn.nextInt();
        b1.rootToLeaf(k);
    }
}

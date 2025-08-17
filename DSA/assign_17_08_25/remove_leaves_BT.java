package assign_17_08_25;


// Given a binary tree, remove all the leaves from the tree


// Input Format
// Enter the value of the nodes of the tree


// Constraints
// None


// Output Format
// Display the tree in which all the leaves have been removed in pre-order traversal in the following format :
// Left->data => Root->data <= Right->Data
// Output END if left or right node is NULL


// Sample Input
// 50 true 12 true 18 false false false false
// Sample Output
// 12 => 50 <= END
// END => 12 <= END


import java.util.*;

public class remove_leaves_BT {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        remove_leaves_BT m = new remove_leaves_BT();
        BinaryTree bt = m.new BinaryTree();
        bt.removeLeaves();
        bt.display();
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        private Node root;
        @SuppressWarnings("unused")
        private int size;

        public BinaryTree() {
            this.root = this.takeInput(null, false);
        }

        public Node takeInput(Node parent, boolean ilc) {
            int cdata = scn.nextInt();
            Node child = new Node();
            child.data = cdata;
            this.size++;

            boolean hlc = scn.nextBoolean();
            if (hlc) {
                child.left = this.takeInput(child, true);
            }

            boolean hrc = scn.nextBoolean();
            if (hrc) {
                child.right = this.takeInput(child, false);
            }

            return child;
        }

        public void display() {
            this.display(this.root);
        }

        private void display(Node node) {
            if (node == null) {
                return;
            }

            String str = "";
            if (node.left != null) {
                str += node.left.data;
            } else {
                str += "END";
            }

            str += " => " + node.data + " <= ";

            if (node.right != null) {
                str += node.right.data;
            } else {
                str += "END";
            }

            System.out.println(str);
            this.display(node.left);
            this.display(node.right);
        }

        public void removeLeaves() {
            this.removeLeaves(null, this.root, false);
        }

        private void removeLeaves(Node parent, Node child, boolean ilc) {
            if (child == null) {
                return;
            }

            if (child.left == null && child.right == null) {
                if (parent == null) {
                    this.root = null;
                } else if (ilc) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                return;
            }

            removeLeaves(child, child.left, true);
            removeLeaves(child, child.right, false);
        }
    }
}
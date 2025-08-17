package assign_17_08_25;

// Given a binary tree. Print the zig zag order i.e print level 1 from left to right, level 2 from right to left and so on. This means odd levels should get printed from left to right and even levels should be printed from right to left.


// Input Format
// Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL


// Constraints
// None


// Output Format
// Display the values in zigzag level order in which each value is separated by a space


// Sample Input
// 10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
// Sample Output
// 10 30 20 40 50 60 73 




import java.util.*;
public class level_order_zigzag_BT {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        level_order_zigzag_BT m = new level_order_zigzag_BT();
        BinaryTree bt = m.new BinaryTree();
        bt.levelOrderZZ();
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

        public void levelOrderZZ() {
            if (this.root == null) {
                return;
            }

            Stack<Node> currentLevel = new Stack<>();
            Stack<Node> nextLevel = new Stack<>();
            boolean leftToRight = true;

            currentLevel.push(this.root);

            while (!currentLevel.isEmpty()) {
                Node node = currentLevel.pop();
                System.out.print(node.data + " ");

                if (leftToRight) {
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                }

                if (currentLevel.isEmpty()) {
                    currentLevel = nextLevel;
                    nextLevel = new Stack<>();
                    leftToRight = !leftToRight;
                }
            }
        }
    }
}
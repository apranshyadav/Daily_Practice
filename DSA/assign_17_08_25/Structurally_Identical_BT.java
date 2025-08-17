package assign_17_08_25;


// Given two trees check if they are structurally identically. Structurally identical trees are trees that have same structure. They may or may not have the same data though.


// Input Format
// Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL


// Constraints
// 1 <= N <= 10^4


// Output Format
// Display the Boolean result


// Sample Input
// 10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
// 10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
// Sample Output
// true
// Explanation
// The given two trees have the exact same structure and hence we print true.


import java.util.*;
public class Structurally_Identical_BT {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Structurally_Identical_BT m = new Structurally_Identical_BT();
		BinaryTree bt1 = m.new BinaryTree();
		BinaryTree bt2 = m.new BinaryTree();
		System.out.println(bt1.structurallyIdentical(bt2));
	}

	private class BinaryTree {
		private class Node {
			@SuppressWarnings("unused")
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

			// left
			boolean hlc = scn.nextBoolean();

			if (hlc) {
				child.left = this.takeInput(child, true);
			}

			// right
			boolean hrc = scn.nextBoolean();

			if (hrc) {
				child.right = this.takeInput(child, false);
			}

			// return
			return child;
		}

		public boolean structurallyIdentical(BinaryTree other) {
			return this.structurallyIdentical(this.root, other.root);
		}

		private boolean structurallyIdentical(Node tnode, Node onode) {
			// Base Case 1: If both nodes are null, they are structurally identical.
    		if (tnode == null && onode == null) {
        		return true;
    		}

    		// Base Case 2: If one node is null and the other is not, they are not.
    		if (tnode == null || onode == null) {
        		return false;
    		}

    		// Recursive Step: For the structure to be identical,
    		// both the left subtrees AND the right subtrees must also be identical.
    		// We ignore the node data (tnode.data and onode.data).
    		boolean leftSubtreeIdentical = this.structurallyIdentical(tnode.left, onode.left);
    		boolean rightSubtreeIdentical = this.structurallyIdentical(tnode.right, onode.right);

    		return leftSubtreeIdentical && rightSubtreeIdentical;
		}

	}
}


package assign_17_08_25;

// You are given two integer arrays preorder and inorder representing the preorder and inorder traversal of a binary tree, respectively. Your task is to reconstruct the binary tree and return its level order traversal.


// Input Format
// The first line contains an integer n, the number of nodes in the tree.
// The second line contains n space-separated integers representing the preorder traversal of the tree.
// The third line contains n space-separated integers representing the inorder traversal of the tree.

// Constraints
// 1 ≤ n ≤ 105
// 1 ≤ Node.val ≤ 105

// Output Format
// Print the level order traversal of the reconstructed binary tree in a single line, with each node value separated by a space.


// Sample Input
// 7
// 1 2 4 5 3 6 7
// 4 2 5 1 6 3 7
// Sample Output
// 1 2 3 4 5 6 7
// Explanation
// Given the following traversals:

// Preorder: [1, 2, 4, 5, 3, 6, 7]
// Inorder: [4, 2, 5, 1, 6, 3, 7]
// The binary tree reconstructed from these traversals is:

//         1
//        / \
//       2   3
//      / \ / \
//     4  5 6  7
    
// The level order traversal of this tree is: 1 2 3 4 5 6 7.



import java.util.*;

public class create_tree_using_preorder_and_inorder {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        create_tree_using_preorder_and_inorder m = new create_tree_using_preorder_and_inorder();
        
        int n = scn.nextInt();
        
        int[] pre = takeInput(n);
        int[] in = takeInput(n);

        BinaryTree bt = m.new BinaryTree(pre, in);

        bt.levelOrderDisplay();
    }

    public static int[] takeInput(int n) {
        int[] rv = new int[n];
        for (int i = 0; i < rv.length; i++) {
            rv[i] = scn.nextInt();
        }
        return rv;
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        private Node root;

        public BinaryTree(int[] pre, int[] in) {
            Map<Integer, Integer> inMap = new HashMap<>();
            for (int i = 0; i < in.length; i++) {
                inMap.put(in[i], i);
            }
            this.root = this.construct(pre, 0, pre.length - 1, 0, in.length - 1, inMap);
        }

        private Node construct(int[] pre, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> inMap) {
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }

            Node rootNode = new Node();
            rootNode.data = pre[preStart];

            int inRootIndex = inMap.get(rootNode.data);
            int leftSubtreeSize = inRootIndex - inStart;

            rootNode.left = construct(pre, preStart + 1, preStart + leftSubtreeSize, inStart, inRootIndex - 1, inMap);
            rootNode.right = construct(pre, preStart + leftSubtreeSize + 1, preEnd, inRootIndex + 1, inEnd, inMap);

            return rootNode;
        }

        public void levelOrderDisplay() {
            if (this.root == null) {
                return;
            }
            
            Queue<Node> queue = new LinkedList<>();
            queue.add(this.root);
            
            while (!queue.isEmpty()) {
                Node current = queue.poll();
                System.out.print(current.data + " ");
                
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }
    }
}

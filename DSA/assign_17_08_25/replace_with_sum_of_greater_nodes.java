package assign_17_08_25;

// Given a binary search tree, replace each nodes' data with the sum of all nodes' which are greater or equal than it. Include the current node's data also.


// Input Format
// The first line contains a number n showing the length of the inorder array of BST. The next line contains n integers denoting the elements of the array.


// Constraints
// 2 ≤ N ≤ 10^3


// Output Format
// Print the preorder traversal of the new tree.


// Sample Input
// 7
// 20 
// 30 
// 40 
// 50 
// 60 
// 70 
// 80
// Sample Output
// 260 330 350 300 150 210 80
// Explanation
// The original tree looks like

//             50             
//         /        \                
//       30          70
//     /    \       /   \ 
//   20    40      60    80
// We are supposed to replace the elements by the sum of elements larger than it.
// 80 being the largest element remains unaffected .
// 70 being the second largest element gets updated to 150 (70+80)
// 60 becomes 210 (60 + 70 + 80)
// 50 becomes 260 (50 + 60 + 70 + 80)
// 40 becomes 300 (40 + 50 + 60 + 70 + 80)
// 30 becomes 330 (30 + 40 + 50 + 60 + 70 + 80)
// 20 becomes 350 (20 + 30 + 40 + 50 + 60 + 70 + 80)

// The new tree looks like

//            260             
//         /        \                
//      330         150
//     /    \       /   \ 
//   350    300   210    80
// The Pre-Order traversal (Root->Left->Right) looks like :
// 260 330 350 300 150 210 80.

import java.util.Scanner;

// Defines the structure for a tree node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class replace_with_sum_of_greater_nodes {
    // A variable to keep track of the running sum during traversal
    private static int cumulativeSum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] inorder = new int[n];
        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();
        }

        // 1. Build the BST from the sorted inorder array
        Node root = buildBSTFromInorder(inorder, 0, n - 1);

        // 2. Transform the tree using a reverse in-order traversal
        replaceWithSum(root);

        // 3. Print the final tree in pre-order
        printPreorder(root);
        
        sc.close();
    }

    /**
     * Recursively builds a balanced Binary Search Tree from a sorted array (in-order traversal).
     */
    public static Node buildBSTFromInorder(int[] arr, int start, int end) {
        // Base case: If the start index is greater than the end, the subarray is empty.
        if (start > end) {
            return null;
        }

        // The middle element becomes the root to keep the tree balanced.
        int mid = start + (end - start) / 2;
        Node node = new Node(arr[mid]);

        // Recursively build the left and right subtrees.
        node.left = buildBSTFromInorder(arr, start, mid - 1);
        node.right = buildBSTFromInorder(arr, mid + 1, end);

        return node;
    }

    /**
     * Transforms the tree by replacing each node's value with the sum of all nodes
     * greater than or equal to it. This is done using a reverse in-order traversal.
     */
    public static void replaceWithSum(Node node) {
        // Base case: Stop if the node is null.
        if (node == null) {
            return;
        }

        // First, traverse the right subtree (all larger values).
        replaceWithSum(node.right);

        // Update the sum with the current node's data and then update the node.
        cumulativeSum += node.data;
        node.data = cumulativeSum;

        // Then, traverse the left subtree (all smaller values).
        replaceWithSum(node.left);
    }

    /**
     * Prints the pre-order traversal of the tree.
     */
    public static void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }
}

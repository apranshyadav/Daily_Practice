package assign_17_08_25;


// Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”


// Input Format
// Enter the number of nodes N and add N more numbers to the BST, then add the two numbers whose LCA is to be found.


// Constraints
// The number of nodes in the tree is in the range [2, 105].
// -109 <= Node.val <= 109
// All Node.val are unique.
// p != q
// p and q will exist in the BST


// Output Format
// Display the LCA value.


// Sample Input
// 4
// 5
// 3
// 2
// 7
// 7
// 5
// Sample Output
// 5
// Explanation
// None



import java.util.Scanner;

public class lower_common_ancestor_of_BST {

    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public void insert(int data) {
        this.root = this.insert(this.root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        
        return node;
    }

    public int findLCA(int p, int q) {
        Node currentNode = this.root;

        while (currentNode != null) {
            if (p > currentNode.data && q > currentNode.data) {
                currentNode = currentNode.right;
            } 
            else if (p < currentNode.data && q < currentNode.data) {
                currentNode = currentNode.left;
            } 
            else {
                return currentNode.data;
            }
        }
        
        return -1; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lower_common_ancestor_of_BST bst = new lower_common_ancestor_of_BST();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            bst.insert(sc.nextInt());
        }

        int p = sc.nextInt();
        int q = sc.nextInt();

        System.out.println(bst.findLCA(p, q));
        
        sc.close();
    }
}

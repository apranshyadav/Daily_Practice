package assign_17_08_25;


// Given a Binary Tree Print all the leaf nodes.


// Input Format
// Level order input of the binary tree


// Constraints
// Total no of nodes <1000


// Output Format
// All leaf nodes from left to right in single line


// Sample Input
// 1
// 2 3
// 4 5
// 6 7
// -1 -1
// -1 -1
// -1 -1
// -1 -1
// Sample Output
// 4 5 6 7



import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

public class print_all_leaf_nodes {

    public static Node buildTree(Scanner sc) {
        int rootData = sc.nextInt();
        if (rootData == -1) {
            return null;
        }

        Node root = new Node(rootData);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node parent = queue.poll();

            int leftData = sc.nextInt();
            if (leftData != -1) {
                parent.left = new Node(leftData);
                queue.add(parent.left);
            }

            int rightData = sc.nextInt();
            if (rightData != -1) {
                parent.right = new Node(rightData);
                queue.add(parent.right);
            }
        }
        return root;
    }

    public static void printLeaves(Node node) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            System.out.print(node.data + " ");
        }

        printLeaves(node.left);
        printLeaves(node.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = buildTree(sc);
        printLeaves(root);
        sc.close();
    }
}
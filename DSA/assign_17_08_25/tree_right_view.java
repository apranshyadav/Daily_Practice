package assign_17_08_25;


// Given a binary tree, Print its right side view ordered from top to bottom.
// Right Side view is defined as nodes that are visible from right side of the tree ie. to a person standing to the right of the tree,only these nodes are visible.


// Input Format
// The first line contains level order traversal of the tree.In the level order traversal , a -1 represent a null child while any other value represent a node in the tree.


// Constraints
// 1<=number of nodes in the tree <=10^5


// Output Format
// Print the Right Side View as space separated integer ordered from top to bottom.


// Sample Input
// 1 2 3 -1 -1 -1 -1
// Sample Output
// 1 3
// Explanation
// To a person standing to the right,only nodes with value 1 and 3 are visible.




import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Defines the structure for a single node in the tree
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

public class tree_right_view {

    /**
     * Builds a binary tree from a level-order traversal string.
     * @param values An array of strings representing node values, with "-1" for null.
     * @return The root node of the constructed tree.
     */
    public static Node buildTree(String[] values) {
        if (values.length == 0 || values[0].equals("-1")) {
            return null;
        }

        Node root = new Node(Integer.parseInt(values[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            Node currentNode = queue.poll();

            // Process left child
            if (i < values.length && !values[i].equals("-1")) {
                currentNode.left = new Node(Integer.parseInt(values[i]));
                queue.add(currentNode.left);
            }
            i++;

            // Process right child
            if (i < values.length && !values[i].equals("-1")) {
                currentNode.right = new Node(Integer.parseInt(values[i]));
                queue.add(currentNode.right);
            }
            i++;
        }
        return root;
    }

    /**
     * Prints the right side view of the binary tree.
     * @param root The root node of the tree.
     */
    public static void printRightView(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // Get the number of nodes at the current level
            int levelSize = queue.size();

            // Iterate through all nodes of the current level
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();

                // If this is the last node of the level, print it
                if (i == levelSize - 1) {
                    System.out.print(currentNode.data + " ");
                }

                // Add children to the queue for the next level
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] values = sc.nextLine().split(" ");
        
        Node root = buildTree(values);
        printRightView(root);
        
        sc.close();
    }
}
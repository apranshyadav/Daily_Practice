package assign_17_08_25;


// Given a binary tree, return the level order traversal of its nodes' values, where each level is printed on a new line. You are provided with a class definition for the binary tree node. Complete the function levelOrderTraversal(root) to perform the task. Do not modify the code inside the main function.


// Input Format
// The input contains the nodes in Level Order format, where -1 represents a null node.

// Constraints
// 1 ≤ Number of nodes ≤ 105
// 1 ≤ Node.val ≤ 105

// Output Format
// For each level of the binary tree, output the node values separated by spaces.
// Print each level on a new line.
// Note: Do not modify or change anything inside the main function.


// Sample Input
// 1 2 3 -1 -1 4 5
// Sample Output
// 1
// 2 3
// 4 5
// Explanation
// Tree Representation:
//       1
//      / \
//     2   3
//        / \
//       4   5
// - Level 0: 1
// - Level 1: 2 3
// - Level 2: 4 5



import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class level_order_traversal {
    public static TreeNode buildTree(List<Integer> values) {
        if (values.isEmpty() || values.get(0) == -1)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(values.get(0));
        queue.add(root);
        int index = 1;

        while (!queue.isEmpty() && index < values.size()) {
            TreeNode node = queue.poll();

            if (index < values.size() && values.get(index) != -1) {
                node.left = new TreeNode(values.get(index));
                queue.add(node.left);
            }
            index++;

            if (index < values.size() && values.get(index) != -1) {
                node.right = new TreeNode(values.get(index));
                queue.add(node.right);
            }
            index++;
        }

        return root;
    }

    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> values = new ArrayList<>();

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                values.add(scanner.nextInt());
            } else if (scanner.next().equalsIgnoreCase("done")) {
                break;
            }
        }

        TreeNode root = buildTree(values);
        List<List<Integer>> levels = levelOrderTraversal(root);

        for (List<Integer> level : levels) {
            for (int n : level) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}

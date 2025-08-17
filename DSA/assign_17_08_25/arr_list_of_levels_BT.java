package assign_17_08_25;

// Given a Binary tree, write code to create a separate array list for each level. You should return an arraylist of arraylist.


// Input Format
// Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL


// Constraints
// None


// Output Format
// Display the resulting arraylist of arraylist according to given sample examples.


// Sample Input
// 50 true 12 true 18 false false true 13 false false false
// Sample Output
// [[50], [12], [18, 13]]


import java.util.*;
public class arr_list_of_levels_BT {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        arr_list_of_levels_BT m = new arr_list_of_levels_BT();
        BinaryTree bt1 = m.new BinaryTree();
        System.out.println(bt1.levelArrayList());
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

        public ArrayList<ArrayList<Integer>> levelArrayList() {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            if (this.root == null) {
                return result;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.add(this.root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                ArrayList<Integer> currentLevelList = new ArrayList<>();

                for (int i = 0; i < levelSize; i++) {
                    Node currentNode = queue.poll();
                    currentLevelList.add(currentNode.data);

                    if (currentNode.left != null) {
                        queue.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.add(currentNode.right);
                    }
                }
                result.add(currentLevelList);
            }
            return result;
        }
    }
}

package assign_17_08_25;

// Given postorder and inorder traversal of a tree. Create the original tree on given information.


// Input Format
// Enter the size of the postorder array N then add N more elements and store in the array, then enter the size of the inorder array M and add M more elements and store in the array. here M and N are same.


// Constraints
// None


// Output Format
// Display the tree using the display function


// Sample Input
// 3
// 1
// 3
// 2
// 3
// 1
// 2
// 3
// Sample Output
// 1 => 2 <= 3
// END => 1 <= END
// END => 3 <= END



import java.util.*;
public class create_tree_using_pre_in_order {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        create_tree_using_pre_in_order m = new create_tree_using_pre_in_order();
        int[] post = takeInput();
        int[] in = takeInput();
        BinaryTree bt = m.new BinaryTree(post, in);
        bt.display();
    }

    public static int[] takeInput() {
        int n = scn.nextInt();
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
        @SuppressWarnings("unused")
        private int size;

        public BinaryTree(int[] post, int[] in) {
            this.root = this.construct(post, 0, post.length - 1, in, 0, in.length - 1);
        }

        private Node construct(int[] post, int plo, int phi, int[] in, int ilo, int ihi) {
            if (plo > phi || ilo > ihi) {
                return null;
            }

            Node node = new Node();
            node.data = post[phi];
            this.size++;

            int s = -1;
            for (int i = ilo; i <= ihi; i++) {
                if (in[i] == node.data) {
                    s = i;
                    break;
                }
            }

            int c = s - ilo;

            node.left = this.construct(post, plo, plo + c - 1, in, ilo, s - 1);
            node.right = this.construct(post, plo + c, phi - 1, in, s + 1, ihi);

            return node;
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
    }
}

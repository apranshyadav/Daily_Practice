// import javax.swing.tree.TreeNode;

// public class lc_226 {
//     class Solution {
//     /**
//      * @param root
//      * @return
//      */
//     public TreeNode invertTree(TreeNode root) {
//         if(root==null){
//             return root;
//         }

//         // Inverted left aur right nikal liya using recursion(DFS)
//         TreeNode invertedLeft = invertTree(root.right);
//         TreeNode invertedRight = invertTree(root.left);

//         // Aur fir left ko right aur right ko left me swap kr diya
//         root.left = invertedLeft;
//         root.right = invertedRight;

//         return root;
//     }
// }

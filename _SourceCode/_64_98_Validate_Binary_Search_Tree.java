/**
 * 98. Validate Binary Search Tree [M]
 * https://leetcode.com/problems/validate-binary-search-tree/
 * Tags: #bst #btree #recursion
 */

 public class _64_98_Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        return checkNode(root, null, null);
    }
    
    public boolean checkNode(TreeNode curNode, TreeNode minNode, TreeNode maxNode){
        if(curNode == null){
            return true;
        }

        if(minNode != null && curNode.val <= minNode.val)
            return false;
        if(maxNode != null && curNode.val >= maxNode.val)
            return false;
        
        // Kiem tra cay con ben trai
        boolean isLeftTreeOk = checkNode(curNode.left, minNode, curNode);
        boolean isRightTreeOk = checkNode(curNode.right, curNode, maxNode);
        return (isLeftTreeOk && isRightTreeOk);
    }
 }
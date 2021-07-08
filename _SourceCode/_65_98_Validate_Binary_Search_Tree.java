/**
 * 98. Validate Binary Search Tree [M]
 * https://leetcode.com/problems/validate-binary-search-tree/
 * Tags: #bst #btree #stack
 */
import java.util.Stack;


public class _65_98_Validate_Binary_Search_Tree {

    private Stack<TreeNode> stack = new Stack<>();
    private Stack<TreeNode> minStack = new Stack<>();
    private Stack<TreeNode> maxStack = new Stack<>();

    private void addToStacks(TreeNode nextNode, TreeNode minNode, TreeNode maxNode){
        stack.push(nextNode);
        minStack.push(minNode);
        maxStack.push(maxNode);
    }

    public boolean checkNode(TreeNode curNode, TreeNode minNode, TreeNode maxNode){
        if(curNode == null){
            return true;
        }
        if(minNode != null && curNode.val <= minNode.val)
            return false;
        if(maxNode != null && curNode.val >= maxNode.val)
            return false;
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        stack.push(root);
        minStack.push(null);
        maxStack.push(null);

        while(stack.isEmpty() == false){
            TreeNode curNode = stack.pop();
            TreeNode minNode = minStack.pop();
            TreeNode maxNode = maxStack.pop();

            if(curNode == null) continue;
            if(checkNode(curNode, minNode, maxNode) == true){
                addToStacks(curNode.right, curNode, maxNode);
                addToStacks(curNode.left, minNode, curNode);
            }else{
                return false;
            }
        }

        return true;
    }
}

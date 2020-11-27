/**
 * 112. Path Sum
 * https://leetcode.com/problems/path-sum/
 */

public class _112_Path_Sum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() { }
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isLeaf(TreeNode curNode)
    {
        return curNode.left == null && curNode.right == null;
    }

    public boolean DFS(TreeNode curNode, int curSum, int targetSum) {
        if(curNode == null) return false;
        
        curSum += curNode.val;

        if(isLeaf(curNode)){
            return curSum == targetSum;
        }
        
        return DFS(curNode.left, curSum, targetSum) || DFS(curNode.right, curSum, targetSum);
    }

    public boolean hasPathSum(TreeNode curNode, int sum) {
        if(curNode == null) return false;
        return DFS(curNode, 0, sum);
    }

}

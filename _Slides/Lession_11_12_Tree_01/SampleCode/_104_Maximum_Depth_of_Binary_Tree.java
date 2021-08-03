public class _104_Maximum_Depth_of_Binary_Tree {
    public int maxDepth(TreeNode curNode) {
        if(curNode == null)
            return 0;

        int leftDepth = maxDepth(curNode.left) + 1;
        int rightDepth = maxDepth(curNode.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }
}

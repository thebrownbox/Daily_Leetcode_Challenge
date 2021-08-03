public class MyBST {
    // ========================================================================
    // 701. Insert into a Binary Search Tree
    public TreeNode insertIntoBST(TreeNode curNode, int val) {
        if (curNode == null)
            return new TreeNode(val);
        if (val > curNode.val) {
            if (curNode.right == null) {
                curNode.right = new TreeNode(val);
            } else {
                insertIntoBST(curNode.right, val);
            }
        } else {
            if (curNode.left == null) {
                curNode.left = new TreeNode(val);
            } else {
                insertIntoBST(curNode.left, val);
            }
        }
        return curNode;
    }

    // ========================================================================
    // 700. Search in a Binary Search Tree
    public TreeNode searchBST(TreeNode curNode, int val) {
        if (curNode == null)
            return null;
        if (curNode.val == val)
            return curNode;
        if (val > curNode.val)
            return searchBST(curNode.right, val);
        return searchBST(curNode.left, val);
    }

    // ========================================================================
    // 98. Validate Binary Search Tree
    static public boolean isValidBST(TreeNode root) {

        return isValidBST(root, null, null);
    }

    static public boolean isValidBST(TreeNode curNode, TreeNode minNode, TreeNode maxNode) {
        if (curNode == null)
            return true;

        if ((minNode != null && minNode.val >= curNode.val) || (maxNode != null && maxNode.val <= curNode.val))
            return false;

        return isValidBST(curNode.left, minNode, curNode) && isValidBST(curNode.right, curNode, maxNode);
    }

    // ========================================================================
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n4.left = n2;
        n4.right = n6;
        n2.left = n1;
        n2.right = n3;
        n6.left = n5;
        n6.right = n7;


        System.out.println(isValidBST(n4));
    }
}

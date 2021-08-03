
/**
 * TreeNode
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int value){
        this.val = value;
    }
    
    TreeNode(int value, TreeNode left, TreeNode right){
        this.val = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof TreeNode)
        {
            TreeNode other = (TreeNode)obj;
            return this.val == other.val;
        }
        return false;
    }
}
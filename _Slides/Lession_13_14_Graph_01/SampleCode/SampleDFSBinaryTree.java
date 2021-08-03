import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class SampleDFSBinaryTree {
    public static void DFS(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visitedSet = new HashSet<>();

        if(root == null)
            return;

        stack.add(root);
        visitedSet.add(root);

        while(stack.isEmpty() == false)
        {
            var curNode = stack.pop();
            System.out.print(curNode.val + " ");
            if(curNode.right != null && visitedSet.contains(curNode.right) == false)
            {
                stack.add(curNode.right);
                visitedSet.add(curNode.right);
            }
            if(curNode.left != null && visitedSet.contains(curNode.left) == false)
            {
                stack.add(curNode.left);
                visitedSet.add(curNode.left);
            }

        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        DFS(n1);
    }
}

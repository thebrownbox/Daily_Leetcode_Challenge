import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SampleBFSBinaryTree {
    public static void BFS(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visitedSet = new HashSet<>();

        if(root == null)
            return;

        queue.add(root);
        visitedSet.add(root);

        while(queue.isEmpty() == false)
        {
            var curNode = queue.poll();
            System.out.print(curNode.val + " ");
            if(curNode.left != null && visitedSet.contains(curNode.left) == false)
            {
                queue.add(curNode.left);
                visitedSet.add(curNode.left);
            }
            if(curNode.right != null && visitedSet.contains(curNode.right) == false)
            {
                queue.add(curNode.right);
                visitedSet.add(curNode.right);
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

        BFS(n1);
    }
}

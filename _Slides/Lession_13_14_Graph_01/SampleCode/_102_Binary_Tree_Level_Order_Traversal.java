import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class _102_Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueLevel = new LinkedList<>();
        Set<TreeNode> visitedSet = new HashSet<>();

        if(root == null)
            return result;

        queue.add(root);
        queueLevel.add(0);
        visitedSet.add(root);
        List<Integer> s = new ArrayList<>();
        s.add(root.val);
        result.add(s);

        while(queue.isEmpty() == false)
        {
            var curNode = queue.poll();
            int nextLevel = queueLevel.poll() + 1;
            List<Integer> childrent = null;
            boolean isNew = false;

            if(result.size() > nextLevel){
                childrent = result.get(nextLevel);
            }else{
                isNew = true;
                childrent = new ArrayList<>();
                
            }

            
            if(curNode.left != null && visitedSet.contains(curNode.left) == false)
            {
                queueLevel.add(nextLevel);
                queue.add(curNode.left);
                visitedSet.add(curNode.left);
                childrent.add(curNode.left.val);
            }
            if(curNode.right != null && visitedSet.contains(curNode.right) == false)
            {
                queueLevel.add(nextLevel);
                queue.add(curNode.right);
                visitedSet.add(curNode.right);
                childrent.add(curNode.right.val);
            }

            if(isNew && childrent.size() > 0){
                result.add(childrent);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        Set<TreeNode> set = new HashSet<>();
        set.add(a);
        set.add(b);
        System.out.println("set.size() : " + set.size());
        List<Integer> s = new ArrayList<>();
        var k = s.get(3);
        int x = 0;
    }
}

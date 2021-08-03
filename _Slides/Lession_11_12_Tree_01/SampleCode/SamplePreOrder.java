import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SamplePreOrder {
    public static void travelNodeLR(TreeNode curNode)
    {
        if(curNode == null)
            return;
        System.out.println(curNode.val);
        travelNodeLR(curNode.left);
        travelNodeLR(curNode.right);
    }

    public static List<Integer> travelNodeLRUsingStack(TreeNode rootNode)
    {
        List<Integer> result = new ArrayList<>();

        if(rootNode == null)
            return result;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = rootNode;
        while(stack.isEmpty() == false || curNode != null)
        {
            // 1. Lấy hết các node bên trái của node hiện tại
            while(curNode != null)
            {
                // 1.1. Duyệt luôn node hiện tại
                System.out.println(curNode.val);
                result.add(curNode.val);
                stack.push(curNode);

                // 1.2. Di chuyển về bên trái cùng
                curNode = curNode.left;
            }
            // 2. Duyệt node trái cùng | Tức là node cuối cùng được add vào stack ở bước 1
            curNode = stack.pop();
            // System.out.println(curNode.val);
            curNode = curNode.right;
        }
        return result;
    }

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

        System.out.println("========== travelNodeLR ========");
        travelNodeLR(n4);
        System.out.println("========== travelNodeLRUsingStack ========");
        travelNodeLRUsingStack(n4);
    }
}

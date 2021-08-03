import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class SampleInOrder {

    public static void travelLNodeR(TreeNode curNode)
    {
        if(curNode == null)
            return;
        travelLNodeR(curNode.left);
        System.out.println(curNode.val);
        travelLNodeR(curNode.right);
    }

    public static List<Integer> travelLNodeRUsingStack(TreeNode rootNode)
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
                stack.push(curNode);
                curNode = curNode.left;
            }
            // 2. Duyệt node trái cùng | Tức là node cuối cùng được add vào stack ở bước 1
            curNode = stack.pop();
            System.out.println(curNode.val);
            result.add(curNode.val);
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

        System.out.println("========== travelLNodeR ========");
        travelLNodeR(n4);
        System.out.println("========== travelLNodeRUsingStack ========");
        travelLNodeRUsingStack(n4);
    }
}

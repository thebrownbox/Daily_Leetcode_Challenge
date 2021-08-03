import java.util.Stack;


public class SamplePostOrder {
    
    public static void travelLRNode(TreeNode curNode)
    {
        if(curNode == null)
            return;
        travelLRNode(curNode.left);
        travelLRNode(curNode.right);
        System.out.println(curNode.val);
    }

    public static void travelLRNodeUsingStack(TreeNode rootNode)
    {
        if(rootNode == null)
            return;
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
            TreeNode temp = stack.peek();
            curNode = temp.right;
            while(curNode != null)
            {
                stack.push(curNode);
                curNode = curNode.right;
            }
            temp = stack.pop();
            System.out.println(temp.val);
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
        TreeNode n8 = new TreeNode(8);
        n4.left = n2;
        n4.right = n6;
        n2.left = n1;
        n2.right = n3;
        n6.left = n5;
        n6.right = n7;

        n3.right = n8;

        System.out.println("========== travelLRNode ========");
        travelLRNode(n4);
        System.out.println("========== travelLRNodeUsingStack ========");
        travelLRNodeUsingStack(n4);
    }
}

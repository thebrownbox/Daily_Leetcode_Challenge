import java.util.ArrayList;
import java.util.List;

public class InOrder {
    public static List<Integer> inorderTraversal(TreeNode curNode)
    {
        List<Integer> result = new ArrayList<>();
        subInOrderTravel(curNode, result);
        return result;
    }

    public static void subInOrderTravel(TreeNode curNode, List<Integer> result)
    {
        if(curNode == null){
            return ;
        }

        result.add(curNode.val);
        subInOrderTravel(curNode.left, result);
        subInOrderTravel(curNode.right, result);
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

        List<Integer> resultPreOrder = inorderTraversal(n1);
        for (Integer integer : resultPreOrder) {
            System.out.println(integer);
        }


    }
}

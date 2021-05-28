/**
 * _41_104_Maximum_Depth_of_Binary_Tree
 */
public class _41_104_Maximum_Depth_of_Binary_Tree {

    // maxDepth(root) => Di tim chieu cao cua cay root
    public int maxDepth(TreeNode root) {
        // B1: Dieu kien dung | Bai toan co so
        if(root == null)
            return 0;

        // B2: Cong thuc de quy:
        int chieuCaoCayBenTrai = maxDepth(root.left);
        int chieuCaoCayBenPhai = maxDepth(root.right);

        int result = Math.max(chieuCaoCayBenPhai, chieuCaoCayBenTrai) + 1;
        return result;
    }

    public static void main(String[] args) {
        
    }
}
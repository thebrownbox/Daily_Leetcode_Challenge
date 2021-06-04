public class _27_Remove_Element{

    public static void removeIndex(int[] a, int index){
        for (int i = index; i < a.length-1; i++) {
            a[i] = a[i+1];
        }
    }

    public static int removeElement(int[] a, int val) {
        int n = a.length;
        for (int i = 0; i < n; ) {
            if(a[i] == val){
                // Xoa phan tu thu i trong mang a
                removeIndex(a, i);
                n--;
            }else{
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] a = {3,2,2,3};
        int n = removeElement(a, 3);
        System.out.println("DONE");
    }
}
/**
 * https://leetcode.com/problems/duplicate-zeros/
 * Tags: #array
 */
public class _04_1089_Duplicate_Zeros {
    static public void duplicateZeros(int[] a) {
        int n = a.length;
        // 1. Find the last correct Index
        int lastIndex = 0;
        int newCount = 0;
        while (lastIndex < n){
            if(a[lastIndex] != 0){
                newCount++;
            }else{
                newCount += 2;
            }
            if(newCount >= n)
                break;
            lastIndex++;
        }

        boolean isSpecialCase = false;
        // handle special case
        if(newCount > n){ // a[lastIndex] = 0
            isSpecialCase = true;
        }

        while (lastIndex >= 0){
            if(isSpecialCase){
                a[n] = a[lastIndex];
                n--; lastIndex--;
                isSpecialCase = false;
            }else{
                if(a[lastIndex] == 0){
                    a[n--] = 0;
                    a[n--] = 0;
                    lastIndex--;
                }else{
                    a[n--] = a[lastIndex--];
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] a = {1,0,2,3,0,4,5,0};
        duplicateZeros(a);
    }
}

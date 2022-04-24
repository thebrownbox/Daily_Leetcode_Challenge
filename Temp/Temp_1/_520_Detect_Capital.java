public class _520_Detect_Capital {

    public boolean detectCapitalUse(String word) {
        char[] arr = word.toCharArray();
        if(arr.length == 1) return true;

        if(Character.isUpperCase(arr[0])){
            if(Character.isUpperCase(arr[1])){ //USA
                for (int i = 1; i < arr.length; i++) {
                    if(Character.isLowerCase(arr[i])){
                        return false;
                    }
                }
            }else{//Google
                for (int i = 1; i < arr.length; i++) {
                    if(Character.isUpperCase(arr[i])){
                        return false;
                    }
                }
            }
        }else{ // leetcode
            for (char c : arr) {
                if(Character.isUpperCase(c)){
                    return false;
                }
            }
        }

        return true;
    }

}

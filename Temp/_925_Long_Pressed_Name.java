import javax.swing.text.html.HTMLDocument.RunElement;

public class _925_Long_Pressed_Name {
    public static boolean check(String name, int i, String typed, int j, boolean isLastTheSame){
        //
        if(j >= typed.length()){
            return false;
        }
        char name_i = name.charAt(i);
        char type_j = typed.charAt(j);
        if(name_i == type_j){
            if(i == name.length()-1){
                if(j == typed.length()-1){
                    return true;
                }
                return check(name, i, typed, j+1, true);
            }else{
                return check(name, i+1, typed, j+1, false);
            }
        }
        if(i == 0) return false;
        if(type_j == name.charAt(i-1)){
            if(isLastTheSame){
                return false;
            }
            return check(name, i, typed, j+1, false);
        }else{
            return false;
        }
        
    }


    public static boolean isLongPressedName(String name, String typed) {
        if(typed.length() < name.length()) return false;
        return check(name, 0, typed, 0, false);
    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex", "aaleexeex"));
        System.out.println(isLongPressedName("alex", "aaleexxx"));
    }
}

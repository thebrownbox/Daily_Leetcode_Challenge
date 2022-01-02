// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.LinkedList;
// import java.util.List;

// public class Sample {

//     class TrieNode{
//         TrieNode children[26];
//         boolean isWord;
//     }


//     public boolean buddyStrings(String s, String goal) {
//         char[] a = s.toCharArray();
//         char[] b = goal.toCharArray();
//         int count = 0;
//         int check_x = 0, check_y = 0;

//         if(s.length() != goal.length())
//             return false;
//         for (int i = 0; i < a.length; i++) {
//             if(a[i] != b[i]){
//                 count++;
//                 if(count == 1){
//                     check_x = i;
//                 }else if (count == 2){
//                     check_y = i;
//                 }else if(count == 3){
//                     return false;
//                 }
//             }
//         }

//         if(a[check_x] == b[check_y] && a[check_y] == b[check_x])
//             return true;

//         return false;
//     }
// }

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapJava {
    public static void main(String[] args) {
        String[] arr = {"Cong", "Hoang", "Hoang", "AAAAAAAA", "Cong", "A"};
        Map<String, Integer> myMap = new TreeMap<>();
        // key: Gia tri cua phan tu trong mang
        // value: So lan xuat hien cua phan tu trong mang

        for (String i : arr) {
            if(myMap.containsKey(i) == false){
                // i chua xuat hien trong map
                myMap.put(i, 1);
            }else{
                // i da xua hien truoc do
                int soLanXuatHien = myMap.get(i);
                soLanXuatHien++;
                myMap.put(i, soLanXuatHien);
            }
        }

        for (Map.Entry entry : myMap.entrySet()) {
            System.out.println(entry.getKey() + " xua hien " + entry.getValue() + " lan!" );
        }

    }
}

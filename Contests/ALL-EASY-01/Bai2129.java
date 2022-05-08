public class Bai2129 {
    public String chuanHoa(String s) {
        if (s.length() < 3) {
            return s.toLowerCase();
        }
        return String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1).toLowerCase();
    }

    public String capitalizeTitle(String title) {
        String[] arr = title.split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = chuanHoa(arr[i]);
        }
        String r = "";
        for (String str : arr) {
            if (r.length() == 0) {
                r = str;
            } else {
                r = " " + str;
            }
        }
        return r;
    }
}

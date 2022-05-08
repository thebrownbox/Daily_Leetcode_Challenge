public class Bai1582 {

    public boolean isSpecial(int[][] mat, int ki, int kj) {
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][kj] == 1) {
                return false;
            }
        }

        for (int j = 0; j < mat[0].length; j++) {
            if (mat[ki][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public int numSpecial1(int[][] mat) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    if (isSpecial(mat, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int numSpecial(int[][] mat) {
        int count = 0;
        int soHang = mat.length;
        int soCot = mat[0].length;
        int[] tongHang = new int[soHang];
        int[] tongCot = new int[soCot];

        for (int i = 0; i < soHang; i++) {
            for (int j = 0; j < soCot; j++) {
                tongHang[i] += mat[i][j];
                tongCot[j] += mat[i][j];
            }
        }

        for (int i = 0; i < soHang; i++) {
            if (tongHang[i] == 1) {
                for (int j = 0; j < soCot; j++) {
                    if (mat[i][j] == 1 && tongCot[j] == 1) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}

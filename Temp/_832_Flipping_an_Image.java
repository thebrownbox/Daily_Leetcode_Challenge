/**
 * https://leetcode.com/problems/flipping-an-image/submissions/
 * 832. Flipping an Image [E]
 * Tags: #array
 */
public class _832_Flipping_an_Image {
    public int[] flipAndInvertImage(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int t = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = t;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
        return arr;
    }

    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            image[i] = flipAndInvertImage(image[i]);
        }
        return image;
    }
}

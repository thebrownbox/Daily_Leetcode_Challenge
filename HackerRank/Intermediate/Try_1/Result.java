class Result {

    /*
     * Complete the 'maxElement' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. INTEGER maxSum
     * 3. INTEGER k
     */

    public static int maxElement(int n, int maxSum, int k) {
        // Write your code here
        if (maxSum % k == 0) {
            return maxSum / k;
        }

        return maxSum / k + 1;
    }

}
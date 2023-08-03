/**
 * Given an array of positive integers of size n and a positive integer t
 * "threshold".
 * Divide the array in non-empty subarrays of length atmost equal to t.
 * Means none of the subarrays can be of length greater than t.
 * You have to find the minimum score of the array.
 * Where score is the sum of the maximum integer from each subarray.
 * 
 * Constraints:
 * 1<=n<=5000
 * 1<=t<=500
 */
public class minimize_score_of_array {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 2, 5 };
        int threshold = 7;

        System.out.println(minScore(arr, threshold));
    }

    public static int minScore(int arr[], int threshold) {
        int n = arr.length;
        int dp[] = new int[n];
        // dp[i] = what is the minimum score till i-th index

        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            int go_till = i - threshold;
            int currMax = arr[i];
            int maxScore = currMax + dp[i - 1];
            // .... dp[i-1] , dp[i] = min score till i-1 + currMax , ...

            for (int j = i - 1; j >= 0 && j > go_till; j--) {
                currMax = (currMax < arr[j]) ? arr[j] : currMax;
                int before_J_th = (j - 1 >= 0) ? dp[j - 1] : 0;

                maxScore = Math.min(before_J_th + currMax, maxScore);
            }
            // minScore in the subarray till the i- threshold + currMax
            dp[i] = maxScore;
        }

        return dp[n - 1];

    }
}
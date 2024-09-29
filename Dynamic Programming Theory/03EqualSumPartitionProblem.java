class Solution {
    static boolean isSubsetSum(int[] arr, int n, int sum) {
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;

        // If last element is greater than sum, then ignore it
        if (arr[n - 1] > sum)
            return isSubsetSum(arr, n - 1, sum);

        // Check if sum can be obtained by any of the following
        // (a) including the last element
        // (b) excluding the last element
        return isSubsetSum(arr, n - 1, sum) ||
                isSubsetSum(arr, n - 1, sum - arr[n - 1]);
    }

    static boolean findPartition(int[] arr) {

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        if (sum % 2 != 0)
            return false;
        return isSubsetSum(arr, arr.length, sum / 2);
    }

    static boolean isSubsetSumDP(int arr[], int n) {
        int sum = 0;
        int i, j;

        for (i = 0; i < n; i++)
            sum += arr[i];

        if (sum % 2 != 0)
            return false;

        boolean dp[][] = new boolean[n + 1][sum / 2 + 1];

        for (i = 0; i <= n; i++)
            dp[i][0] = true;
        for (i = 1; i <= sum / 2; i++)
            dp[0][i] = false;

        for (i = 1; i <= n; i++) {
            for (j = 1; j <= sum / 2; j++) {
                if (j >= arr[i - 1])
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][sum / 2];
    }
}
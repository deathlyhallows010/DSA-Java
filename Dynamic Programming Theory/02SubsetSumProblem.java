class Solution {
    static boolean Recursive(int wt[], int sum, int n) {
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (sum > wt[n - 1]) {
            return Recursive(wt, sum - wt[n - 1], n - 1) || Recursive(wt, sum, n - 1);
        }
        return Recursive(wt, sum, n - 1);
    }

    static boolean DPApproach(int wt[], int sum, int n) {
        boolean dp[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= wt[i - 1])
                    dp[i][j] = dp[i - 1][j] || dp[i-1][j - wt[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][sum];
    }
}
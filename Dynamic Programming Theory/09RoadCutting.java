class Solution {
    public static int unboundedKnapsack(int W, int[] wt, int[] val, int n) {

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W + 1; j++) {
                if (wt[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i] + dp[i][j - wt[i]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    static int SpaceOptunboundedKnapsack(int W, int n, int[] val, int[] wt) {
        int[] dp = new int[W + 1];

        // Initialize dp array with 0
        for (int i = 0; i <= W; i++) {
            dp[i] = 0;
        }

        // Fill the dp array using the given weights and values
        for (int i = 0; i < n; i++) {
            for (int j = wt[i]; j <= W; j++) {
                dp[j] = Math.max(dp[j], dp[j - wt[i]] + val[i]);
            }
        }

        return dp[W];
    }
}
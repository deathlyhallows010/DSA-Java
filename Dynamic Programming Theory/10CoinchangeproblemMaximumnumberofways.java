class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length + 1][amount + 1];
        int i, j = 0;

        for (i = 0; i < coins.length + 1; i++) {
            dp[i][0] = 1;
        }

        for (i = 0; i < amount + 1; i++) {
            dp[0][i] = 0;
        }

        for (i = 1; i < coins.length + 1; i++) {
            for (j = 1; j < amount + 1; j++) {
                if (j >= coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        // return dp[i-1][j-1];
        return dp[coins.length][amount];
    }

    public int SpaceOptimized(int amount, int[] coins) {
        int dp[] = new int[amount + 1];
        int i = 0;

        dp[i] = 1;
        for (i = 1; i < amount + 1; i++) {
            dp[i] = 0;
        }

        for (i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < amount + 1; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
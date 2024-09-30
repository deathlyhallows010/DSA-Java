class Solution {
    static int coinChange(int coins[], int amount) {
        int dp[][] = new int[coins.length + 1][amount + 1];
        int i, j = 0;
        for (i = 0; i < coins.length + 1; i++) {
            dp[i][0] = 0;
        }

        for (i = 1; i < amount + 1; i++) {
            dp[0][i] = Integer.MAX_VALUE - 1;
            if (i == 0) {
                continue;
            }

            if (i % coins[0] == 0) {
                dp[1][i] = i / coins[0];
            } else {
                dp[1][i] = Integer.MAX_VALUE - 1;
            }

        }

        for (i = 2; i < coins.length + 1; i++) {
            for (j = 1; j < amount + 1; j++) {
                if (j >= coins[i - 1]) {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[coins.length][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[coins.length][amount];
    }
}
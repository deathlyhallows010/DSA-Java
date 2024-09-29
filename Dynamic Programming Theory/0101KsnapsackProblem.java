class Solution {
    static int Recursive(int W, int wt[], int val[], int n) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (W < wt[n - 1]) {
            return Math.max(val[n - 1] + Recursive(W - wt[n - 1], wt, val, n - 1), Recursive(W, wt, val, n - 1));
        } else {
            return Recursive(W, wt, val, n - 1);
        }
    }

    static int KnapsackMemoization(int W, int wt[], int val[], int n) {
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                dp[i][j] = -1;
            }
        }

        return Memoization(W, wt, val, n, dp);
    }

    static int Memoization(int W, int wt[], int val[], int n, int[][] dp) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (W < wt[n - 1]) {
            return dp[n][W] = Math.max(val[n - 1] + Recursive(W - wt[n - 1], wt, val, n - 1),
                    Recursive(W, wt, val, n - 1));
        } else {
            return dp[n][W] = Recursive(W, wt, val, n - 1);
        }
    }

    static int BottomUp(int W, int wt[], int val[], int n) {
        int i, w = 0;
        int dp[][] = new int[n + 1][W + 1];
        for (i = 0; i < n + 1; i++) {
            for (w = 0; w < W + 1; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (wt[i - 1] < W) {
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[i][w];
    }

    static int SpaceOptimizedBottomup(int W, int wt[], int val[], int n) {
        {
            int[] dp = new int[W + 1];
            for (int i = 1; i < n + 1; i++) {
                for (int w = W; w >= 0; w--) {
                    if (wt[i - 1] <= w)
                        dp[w] = Math.max(val[i - 1] + dp[w - wt[i - 1]], dp[w]);
                }
            }
            return dp[W];
        }
    }
}
class Solution {
    static int Recusive(String X, String Y, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return 1 + Recusive(X, Y, m - 1, n - 1);
        } else {
            return Math.max(Recusive(X, Y, m - 1, n), Recusive(X, Y, m, n - 1));
        }
    }

    static int Memoization(String X, String Y, int m, int n, int[][] memo) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (memo[m][n] != -1) {
            return memo[m][n];
        }

        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return memo[m][n] = 1 + Memoization(X, Y, m - 1, n - 1, memo);
        } else {
            return memo[m][n] = Math.max(Memoization(X, Y, m - 1, n, memo), Memoization(X, Y, m, n - 1, memo));
        }
    }

    static int DynamicProgramming(String X, String Y, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            dp[m][0] = 0;
        }

        for (int i = 0; i < n + 1; i++) {
            dp[0][n] = 0;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[X.length()][Y.length()];
    }
}
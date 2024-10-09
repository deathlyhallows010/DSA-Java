class Solution{
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

    static boolean SequencePaternMatching(String a, String b){
        return DynamicProgramming(a, b, a.length(), b.length()) == a.length();
    }
}
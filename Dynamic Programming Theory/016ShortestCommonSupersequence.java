class Solution {
    static int shortestSuperSequence(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        int l = lcs(X, Y, m, n);

        return (m + n - l);
    }

    // Returns length of LCS
    // for X[0..m - 1], Y[0..n - 1]
    static int lcs(String X, String Y, int m, int n) {
        int[][] L = new int[m + 1][n + 1];
        int i, j;

        for (i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {

                if (X.charAt(i - 1) == Y.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;

                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }
}
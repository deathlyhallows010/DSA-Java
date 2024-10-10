class Solution {

    static int MatrixChainOrder(int arr[], int i, int j) {
        if (i == j)
            return 0;

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int count = MatrixChainOrder(arr, i, k)
                    + MatrixChainOrder(arr, k + 1, j)
                    + arr[i - 1] * arr[k] * arr[j];

            if (count < min)
                min = count;
        }
        return min;
    }

    static int[][] dp = new int[1001][1001];

    static int matrixChainMemoised(int[] p, int i, int j) {
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            dp[i][j] = Math.min(
                    dp[i][j], matrixChainMemoised(p, i, k)
                            + matrixChainMemoised(p, k + 1, j)
                            + p[i - 1] * p[k] * p[j]);
        }
        return dp[i][j];
    }

    static int MatrixChainOrder(int[] p, int n) {
        int i = 1, j = n - 1;
        return matrixChainMemoised(p, i, j);
    }
}
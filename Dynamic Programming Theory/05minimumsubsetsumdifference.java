class Solution {
    static int Recursive(int[] vec, int i, int sumCalculated, int sumTotal) {
        if (i == 0) {
            return Math.abs(sumTotal - 2 * sumCalculated);
        }

        return Math.min(Recursive(vec, i - 1, sumCalculated, sumTotal),
                Recursive(vec, i - 1, sumCalculated + vec[i - 1], sumTotal));
    }

    static int DPApproach(int[] vec) {
        int n = vec.length;
        int sum = 0;
        for (int num : vec) {
            sum += num;
        }

        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (vec[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - vec[i - 1]];
                }
            }
        }

        // main code

        int diff = Integer.MAX_VALUE;
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                diff = sum - 2 * j;
                break;
            }
        }
        return diff;
    }

}
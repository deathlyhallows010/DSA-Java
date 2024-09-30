class Solution{
    // sun is difference - problem is exactly the same as target sum
    static int DPApproach(int wt[], int diff) {
        int n = wt.length;
        int arraySum = 0;
        for(int num: wt){
            arraySum+=num;
        }

        int sum = (diff + arraySum)/2;

        int dp[][] = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;
        for (int i = 1; i <= sum; i++)
            dp[0][i] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= wt[i - 1])
                    dp[i][j] = dp[i - 1][j] + dp[i-1][j - wt[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][sum];
    }
}
class Solution{
    public static int maxCommStrDP(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];
        int result = 0; 

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return result;
    }

    public static int longestCommonSubstr(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[] prev = new int[n + 1];
        
        int res = 0;
        for (int i = 1; i <= m; i++) {
          
            int[] curr = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                    res = Math.max(res, curr[j]);
                } else {
                    curr[j] = 0;
                }
            }
            prev = curr;
        }
        return res;
    }
}
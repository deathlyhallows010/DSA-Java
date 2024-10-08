class Solution{
    public static int dp[][]=new int[1001][1001];
   
    static int lcs(String str1, String str2, int i, int j)
    {
         if (i == 0 || j == 0) {
                return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            return dp[i][j] = 1 + lcs(str1, str2, i - 1, j - 1);
            }
            else {
            return dp[i][j] = Math.max(lcs(str1, str2, i, j - 1), lcs(str1, str2, i - 1, j));
        }
         
    }
 
    // function to find minimum number
    // of deletions and insertions
    static void printMinDelAndInsert(String str1,
                                    String str2)
    {
        int m = str1.length();
        int n = str2.length();
 
        int len = lcs(str1, str2, m, n);
 
        System.out.println("Minimum number of deletions = "+(m - len));
         
 
        System.out.println("Minimum number of insertions = "+(n - len));
     
    }
}
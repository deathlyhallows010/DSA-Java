class Solution {
    static String printLCS(String a, String b) {
        int m = a.length();
        int n = b.length();

        int dp[][] = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        int i = m;
        int j = n;

        int len = dp[m][n];
        int index = len - 1;

        StringBuilder str = new StringBuilder();

        // Fill the string with '$'
        for (int k = 0; k < len; k++) {
            str.append('$');
        }

        // Logic for comparing characters and modifying the string 
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                str.setCharAt(index, a.charAt(i - 1));
                index--;
                i--;
                j--;
            } else if (dp[i][j-1] > dp[i-1][j]) {
                j--;
            } else {
                i--;
            }
        }

        return str.toString();
    }

}
class Solution {
    static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    static int minPalPartitionRec(String str, int i, int j) {
        if (i >= j)
            return 0;

        if (isPalindrome(str, i, j))
            return 0;

        int mn = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int cuts = minPalPartitionRec(str, i, k) + minPalPartitionRec(str, k + 1, j) + 1;
            mn = Math.min(mn, cuts);
        }

        return mn;
    }

    static int[][] dp = new int[1001][1001];

    static int minPalPartitionDP(String str, int i, int j) {
        if (i >= j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (isPalindrome(str, i, j)) {
            return 0;
        }
        int mn = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int cuts = minPalPartitionRec(str, i, k) + minPalPartitionRec(str, k + 1, j) + 1;
            mn = Math.min(mn, cuts);
        }

        return dp[i][j] = mn;
    }

    static int minPalPartitionDPaBitOptimized(String str, int i, int j) {
        if (i >= j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (isPalindrome(str, i, j)) {
            return 0;
        }
        int mn = Integer.MAX_VALUE;

        int left, right;

        for (int k = i; k < j; k++) {
            if (dp[i][k] != -1) {
                left = dp[i][k];
            } else {
                left = minPalPartitionRec(str, i, k);
                dp[i][k] = left;
            }
            if (dp[k + 1][j] != -1) {
                right = dp[k + 1][j];
            } else {
                right = minPalPartitionRec(str, i, k);
                dp[k + 1][j] = right;
            }

            int cuts = left + right + 1;
            mn = Math.min(mn, cuts);
        }

        return dp[i][j] = mn;
    }

}
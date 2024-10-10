import java.util.HashMap;
import java.util.Map;

class Solution {

    public static int countWays(String symbols, String operators, int i, int j, boolean isTrue) {
        if (i == j) {
            if (isTrue) {
                return symbols.charAt(i) == 'T' ? 1 : 0;
            } else {
                return symbols.charAt(i) == 'F' ? 1 : 0;
            }
        }

        int ways = 0;

        for (int k = i + 1; k < j; k = k + 2) {
            char operator = operators.charAt(k);

            int lt = countWays(symbols, operators, i, k, true);
            int lf = countWays(symbols, operators, i, k, false);
            int rt = countWays(symbols, operators, k + 1, j, true);
            int rf = countWays(symbols, operators, k + 1, j, false);

            // Calculate number of ways to get true/false based on the current operator
            if (operator == '&') {
                if (isTrue) {
                    ways += lt * rt; // T & T = T
                } else {
                    ways += lt * rf + lf * rt + lf * rf; // F & T, T & F, F & F = F
                }
            } else if (operator == '|') {
                if (isTrue) {
                    ways += lt * rt + lt * rf + lf * rt; // T | T, T | F, F | T = T
                } else {
                    ways += lf * rf; // F | F = F
                }
            } else if (operator == '^') { // XOR operator
                if (isTrue) {
                    ways += lt * rf + lf * rt; // T ^ F, F ^ T = T
                } else {
                    ways += lt * rt + lf * rf; // T ^ T, F ^ F = F
                }
            }
        }

        return ways;
    }

    public class BooleanParenthesizationDP {

        static int[][][] dp;

        public static int countWays(String symbols, String operators, int i, int j, boolean isTrue) {
            int isTrueFlag = isTrue ? 1 : 0;

            if (dp[i][j][isTrueFlag] != -1) {
                return dp[i][j][isTrueFlag];
            }

            if (i == j) {
                if (isTrue) {
                    return dp[i][j][isTrueFlag] = symbols.charAt(i) == 'T' ? 1 : 0;
                } else {
                    return dp[i][j][isTrueFlag] = symbols.charAt(i) == 'F' ? 1 : 0;
                }
            }

            int ways = 0;

            for (int k = i + 1; k < j; k += 2) {
                char operator = operators.charAt(k);

                int lt = countWays(symbols, operators, i, k - 1, true);
                int lf = countWays(symbols, operators, i, k - 1, false);
                int rt = countWays(symbols, operators, k + 1, j, true);
                int rf = countWays(symbols, operators, k + 1, j, false);

                if (operator == '&') {
                    if (isTrue) {
                        ways += lt * rt; // T & T = T
                    } else {
                        ways += lt * rf + lf * rt + lf * rf; // F & T, T & F, F & F = F
                    }
                } else if (operator == '|') {
                    if (isTrue) {
                        ways += lt * rt + lt * rf + lf * rt; // T | T, T | F, F | T = T
                    } else {
                        ways += lf * rf; // F | F = F
                    }
                } else if (operator == '^') { // XOR operator
                    if (isTrue) {
                        ways += lt * rf + lf * rt; // T ^ F, F ^ T = T
                    } else {
                        ways += lt * rt + lf * rf; // T ^ T, F ^ F = F
                    }
                }
            }

            return dp[i][j][isTrueFlag] = ways;
        }
    }

    public class BooleanParenthesizationMap {

        static Map<String, Integer> memo;

        public static int countWays(String symbols, String operators, int i, int j, boolean isTrue) {
            String key = i + " " + j + " " + isTrue;

            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            if (i == j) {
                if (isTrue) {
                    return symbols.charAt(i) == 'T' ? 1 : 0;
                } else {
                    return symbols.charAt(i) == 'F' ? 1 : 0;
                }
            }

            int ways = 0;

            for (int k = i + 1; k < j; k += 2) {

                char operator = operators.charAt((k - 1) / 2);

                int lt = countWays(symbols, operators, i, k - 1, true);
                int lf = countWays(symbols, operators, i, k - 1, false);
                int rt = countWays(symbols, operators, k + 1, j, true);
                int rf = countWays(symbols, operators, k + 1, j, false);

                if (operator == '&') {
                    if (isTrue) {
                        ways += lt * rt; // T & T = T
                    } else {
                        ways += lt * rf + lf * rt + lf * rf; // F & T, T & F, F & F = F
                    }
                } else if (operator == '|') {
                    if (isTrue) {
                        ways += lt * rt + lt * rf + lf * rt; // T | T, T | F, F | T = T
                    } else {
                        ways += lf * rf; // F | F = F
                    }
                } else if (operator == '^') { // XOR operator
                    if (isTrue) {
                        ways += lt * rf + lf * rt; // T ^ F, F ^ T = T
                    } else {
                        ways += lt * rt + lf * rf; // T ^ T, F ^ F = F
                    }
                }
            }

            memo.put(key, ways);
            return ways;
        }

        public static int booleanParenthesization(String symbols, String operators) {
            memo = new HashMap<>();
            return countWays(symbols, operators, 0, symbols.length() - 1, true);
        }

        public static void main(String[] args) {
            String symbols = "TFT";
            String operators = "^&";

            int result = booleanParenthesization(symbols, operators);

            System.out.println("Number of ways to parenthesize the expression to true: " + result);
        }
    }
}
import java.util.Scanner;

import static java.lang.Integer.max;

public class LongestCommonSubsequence {
    public int lcs(char[] x, char[] y, int m, int n, int[][] dp) {
        if(m == 0 || n == 0)
            return 0;
        if(dp[m - 1][n - 1] != -1)
            return dp[m - 1][n - 1];
        if(x[m-1] == y[n-1])
            return 1 + lcs(x, y, m - 1, n - 1, dp);
        return max(lcs(x, y, m - 1, n, dp), lcs(x, y, m, n - 1, dp));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LongestCommonSubsequence solveLCS = new LongestCommonSubsequence();
        String s1 = "AGGTABAA";
        String s2 = "GATFGABSAAA";
        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        int m = x.length;
        int n = y.length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("Length of LCS is : " + solveLCS.lcs(x, y, m, n, dp));
    }

}

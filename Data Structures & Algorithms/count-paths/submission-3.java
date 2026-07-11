class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int col = n - 1; col >= 0; col--){
            dp[m - 1][col] = 1;
        }

        for(int row = m - 2; row >= 0; row--){
            dp[row][n - 1] = 1;
        }

        for(int row = m - 2; row >= 0; row--){
            for(int col = n - 2; col >= 0; col--){
                dp[row][col] = dp[row + 1][col] + dp[row][col + 1];
            }
        }

        return dp[0][0];
    }
}

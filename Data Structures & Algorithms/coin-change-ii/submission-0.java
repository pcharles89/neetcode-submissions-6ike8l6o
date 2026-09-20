class Solution {
    public int change(int amount, int[] coins) {

        int n = coins.length;

        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {

            int coin = coins[i - 1];

            for (int currentAmount = 1;
                 currentAmount <= amount;
                 currentAmount++) {

                dp[i][currentAmount] =
                        dp[i - 1][currentAmount];

                if (coin <= currentAmount) {
                    dp[i][currentAmount] +=
                            dp[i][currentAmount - coin];
                }
            }
        }

        return dp[n][amount];
    }
}

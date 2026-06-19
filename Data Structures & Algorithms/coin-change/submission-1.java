class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);

        dp[0] = 0;

        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
            for (int coin : coins) {
                if (currentAmount - coin >= 0) {
                    dp[currentAmount] = Math.min(
                        dp[currentAmount],
                        dp[currentAmount - coin] + 1
                    );
                }
            }
        }

        return dp[amount] == max ? -1 : dp[amount];
    }
}

class Solution {
    public int tallestBillboard(int[] rods) {
        int sum = 0;
        for (int rod : rods) {
            sum += rod;
        }
        int[][] dp = new int[rods.length + 1][sum + 1];
        for (int i = 1; i <= rods.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (dp[i - 1][j] < j) {
                    continue;
                }
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                int k = j + rods[i - 1];
                dp[i][k] = Math.max(dp[i][k], dp[i - 1][j] + rods[i - 1]);
                k = Math.abs(j - rods[i - 1]);
                dp[i][k] = Math.max(dp[i][k], dp[i - 1][j] + rods[i - 1]);
            }
        }
        return dp[rods.length][0] / 2;
    }
}

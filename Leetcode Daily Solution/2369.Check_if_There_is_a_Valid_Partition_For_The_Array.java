class Solution {
    public boolean validPartition(int[] n) {
        boolean[] dp = {true, false, n[0] == n[1], false};
        for (int i = 2; i < n.length; ++i) {
            boolean two = n[i] == n[i - 1];
            boolean three = (two && n[i] == n[i - 2]) || (n[i] - 1 == n[i - 1] && n[i] - 2 == n[i - 2]);
            dp[(i + 1) % 4] = (two && dp[(i - 1) % 4]) || (three && dp[(i - 2) % 4]);
        }
        return dp[n.length % 4];
    }
}

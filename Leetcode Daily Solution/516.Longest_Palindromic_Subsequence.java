class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] c = s.toCharArray();
        int[] dp = new int[c.length];
        for(int j = 0; j < dp.length; j++) {
            dp[j] = 1;
            int topRight = 0;
            for(int i = j-1; i >= 0; i--) {
                int temp = dp[i];
                dp[i] = c[i] == c[j] ? 2 + topRight : Math.max(dp[i], dp[i+1]);
                topRight = temp;
            }
        }
        return dp[0];
    }
}

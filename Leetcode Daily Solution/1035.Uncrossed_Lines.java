class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if (n < m) return maxUncrossedLines(nums2, nums1);

        int[] dp = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            int prev = 0;
            for (int j = 1; j <= m; j++) {
                int curr = dp[j];
                if (nums1[i-1] == nums2[j-1]) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j-1], curr);
                }
                prev = curr;
            }
        }
        return dp[m];
    }
}

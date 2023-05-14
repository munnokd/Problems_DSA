class Solution {
    public int func(int[] nums, int op, int mask, int[] dp, int[][] gcd) {
        int m = nums.length, n = nums.length/2;

        if(op > n) return 0;
        if(dp[mask] != -1) return dp[mask];

        for(int i=0; i<m; i++) {
            if( (mask & (1<<i)) != 0 ) continue;
            for(int j=i+1; j<m; j++) {
                if( (mask & (1<<j)) != 0 ) continue;

                int newMask = (1<<i) | (1<<j) | mask;
                int score = op * gcd[i][j] + func(nums, op+1, newMask, dp, gcd);
                dp[mask] = Math.max(dp[mask], score);
            }
        }

        return dp[mask];
    }

    public int maxScore(int[] nums) {
        int[] dp = new int[1<<14];
        Arrays.fill(dp, -1);

        int m = nums.length, n = nums.length/2;
        int[][] gcd = new int[m][m];
        for(int i=0; i<m; i++) {
            for(int j=0; j<m; j++) {
                gcd[i][j] = gcd(nums[i], nums[j]);
            }
        }

        return func(nums, 1, 0, dp, gcd);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}

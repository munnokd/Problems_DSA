class Solution {
    public int func(int i, int k, List<List<Integer>> piles, int[][] dp) {
        if (dp[i][k] > 0) return dp[i][k];
        if (i == piles.size() || k == 0) return 0;
        int res = func(i + 1, k, piles, dp), cur = 0;
        for (int j = 0; j < piles.get(i).size() && j < k; ++j) {
            cur += piles.get(i).get(j);
            res = Math.max(res, func(i + 1, k - j - 1, piles, dp) + cur);
        }
        dp[i][k] = res;
        return res;
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int K) {
        int n = piles.size();
        int[][] dp = new int[n + 1][K + 1];
        return func(0, K, piles, dp);
    }
}

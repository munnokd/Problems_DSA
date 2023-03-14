import java.util.ArrayList;

class Solution {

    int maxCoins(int N, ArrayList<Integer> arr) {
        arr.add(0, 1);
        arr.add(1);

        int[][] dp = new int[N + 2][N + 2];

        for (int len = 1; len <= N; len++) {
            for (int i = 1; i <= N - len + 1; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k - 1] + dp[k + 1][j] + arr.get(i - 1) * arr.get(k) * arr.get(j + 1));
                }
            }
        }
        return dp[1][N];
    }

}
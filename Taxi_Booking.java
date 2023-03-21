//Problem of the day 21-03-2023

class Solution {
    public static int minimumTime(int N, int cur, int[] pos, int[] time) {
        // code here
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int dif = Math.abs(pos[i] - cur);
            ans = Math.min(ans, dif * time[i]);
        }
        return ans;
    }
}
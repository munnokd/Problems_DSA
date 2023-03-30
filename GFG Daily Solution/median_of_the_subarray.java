//Problem of the day 13-03-2023
class Solution {
    public long solve(int n, int[] A, int m) {
        int[] mp = new int[2 * n + 1];
        Arrays.fill(mp, 0);
        long cur = n, tot = 0, ans = 0;
        mp[(int) cur]++;
        for (int i = 0; i < n; i++) {
            int x = -1;
            if (A[i] >= m) {
                x = 1;
            }
            if (x == -1) {
                tot -= mp[(int) (cur + x)];
            } else {
                tot += mp[(int) cur];
            }
            cur += x;
            ans += tot;
            mp[(int) cur]++;
        }
        return ans;
    }

    long countSubarray(int N, int[] A, int M) {
        // code here
        return solve(N, A, M) - solve(N, A, M + 1);
    }
}
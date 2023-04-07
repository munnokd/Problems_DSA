class Solution {
    int equalSum(int[] A, int N) {
        // Write your code here
        int ps = 0, ss = 0;
        if (N == 1)
            return 1;

        for (int j = 1; j < N; j++)
            ss = ss + A[j];
        for (int i = 1; i < N - 1; i++) {
            ps = ps + A[i - 1];
            ss = ss - A[i];

            if (ss == ps)
                return i + 1;
        }
        return -1;
    }
}
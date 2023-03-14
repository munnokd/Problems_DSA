//Problem of the day 13-03-2023
class Solution {
    long maxPossibleValue(int N, int A[], int B[]) {
        int count = 0;
        int mini = Integer.MAX_VALUE;
        long sum = 0;
        for (int i = 0; i < N; i++) {
            int n = B[i] / 2;
            if (n > 0) {
                mini = Math.min(mini, A[i]);
                sum += A[i] * n * 2;
                count += n;
            }
        }
        if (count % 2 != 0)
            sum -= mini * 2;
        return sum;
    }
}

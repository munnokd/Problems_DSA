//GFGF daily problem 30-03-23 

class Solution {
    public static int minimumInteger(int n, int[] a) {

        long sum = 0;
        for (int val : a) {
            sum += (long) val;
        }

        long b = sum / n;
        long temp = 0;
        if (sum == n * b)
            temp = b;
        else
            temp = b + 1;
        long ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (a[i] >= temp)
                ans = Math.min(ans, a[i]);
        }
        return (int) ans;
    }
}

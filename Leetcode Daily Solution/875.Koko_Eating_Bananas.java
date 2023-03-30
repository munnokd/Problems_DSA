class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 1000000000, k = 0;
        while (low <= high) {
            k = (low + high) / 2;
            int hi = 0;
            for (int i = 0; i < piles.length; i ++) 
                hi += Math.ceil(1.0 * piles[i] / k);
            if (hi > h)
                low = k + 1;
            else
                high = k - 1;
        }
        return low;

    }
}
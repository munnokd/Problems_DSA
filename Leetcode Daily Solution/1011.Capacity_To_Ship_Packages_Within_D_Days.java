class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = -1, totalWeight = 0;
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }
        int left = maxWeight, right = totalWeight;
        while (left < right) {
            int mid = (left + right) / 2;
            int daysNeeded = 1, currWeight = 0;
            for (int weight : weights) {
                if (currWeight + weight > mid) {
                    daysNeeded++;
                    currWeight = 0;
                }
                currWeight += weight;
            }
            if (daysNeeded > days) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
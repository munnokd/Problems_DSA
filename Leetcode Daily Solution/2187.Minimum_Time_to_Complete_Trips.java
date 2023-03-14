class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long lo = 1;
        long hi = Long.MAX_VALUE;

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long completedTrips=0;
            for (int t : time) {
                completedTrips += mid / t;
                if (completedTrips >= totalTrips) break;
            }
            if (completedTrips>=totalTrips) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}

class Solution {
    static Shop shop;

    Solution(Shop shop) {
        this.shop = shop;
    }

    static int getFloor(int nums[], int n, long x) {
        int low = 0, high = n - 1, mid;
        int floor = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == -1)
                nums[mid] = shop.get(mid);
            if (nums[mid] == x) {
                return nums[mid];
            } else if (x < nums[mid]) {
                high = mid - 1;
            } else {
                floor = nums[mid];
                low = mid + 1;
            }
        }

        return floor;
    }

    static long find(int n, long k) {
        int ans[] = new int[n];
        Arrays.fill(ans, -1);
        long count = 0L;
        while (k > 0) {
            int x = getFloor(ans, n, k);
            if (x == -1)
                break;
            count += k / x;
            k %= x;
        }
        return count;
        // Return the number of chocolates Geek had
        // enjoyed out of 'n' chocolates availabe in the
        // 'shop'.
    }

}
class Solution {
    public int numSubseq(int[] nums, int target) {
        int res = 0, mod = 1000000007, l = 0, r = nums.length - 1;
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        for (int i = 1; i <= nums.length; ++i) {
            pre.add((pre.get(i - 1) << 1) % mod);
        }

        Arrays.sort(nums);

        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                res = (res + pre.get(r - l++)) % mod;
            }
        }

        return res;
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(low < high){
            int mid = low + (high - low) / 2;
            if(nums[mid] >= target) high = mid;
            else low = mid+1;
        }

        if(nums[low] != target) return -1;
        return low;
    }
}

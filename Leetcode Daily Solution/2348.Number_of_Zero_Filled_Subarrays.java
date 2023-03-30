class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans=0;
        for(int i=0,j=0;i<nums.length;i++){
            if(nums[i]!=0) j=i+1;
            ans+=i-j+1;
        }
        return ans;
    }
}

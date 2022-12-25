class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int m=queries.length;
        int []ans=new int[m];
        for(int i=1;i<nums.length;i++) nums[i]+=nums[i-1];
        
        for(int i=0;i<m;i++){
            int res=Arrays.binarySearch(nums,queries[i]);
            ans[i]=Math.abs(res+1);
        }
        return ans;
    }
}
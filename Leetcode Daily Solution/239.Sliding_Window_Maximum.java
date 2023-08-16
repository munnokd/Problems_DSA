class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] ans=new int[n-k+1];
        int r=0;
        Deque<Integer> de=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!de.isEmpty() && de.peek()==i-k){
                de.poll();
            }
            while(!de.isEmpty() && nums[de.peekLast()]<=nums[i]){
                de.pollLast();
            }
            de.offer(i);
            if(i>=k-1){
                ans[r++]=nums[de.peek()];
            }
        }
        return ans;
    }
}

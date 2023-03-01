class Solution {
    public int[] sortArray(int[] nums) {
        int i=0;
        int[] ans = new int[nums.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums) pq.offer(num);
        while(!pq.isEmpty()) ans[i++] = pq.poll();
        return ans;
    }
}
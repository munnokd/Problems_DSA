class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i=0;i<piles.length;i++) pq.add(piles[i]);

        for(int i=0;i<k;i++){
            int t=pq.poll();
            int sum=t-(t/2);
            pq.add(sum);
        }

        int ans=0;
        for(int i=0;i<piles.length;i++) ans+=pq.poll();

        return ans;
    }
}
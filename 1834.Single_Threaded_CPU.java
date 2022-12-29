class Solution {
    public int[] getOrder(int[][] jobs) {
        int len = jobs.length;
        int[] result = new int[len];
        int[][] tasks = new int[len][3];
        for(int i=0;i<len; i++) tasks[i] = new int[] {jobs[i][0], jobs[i][1], i};
        Arrays.sort(tasks, (a,b) -> a[0]-b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]==b[1] ? a[2]-b[2] : a[1]-b[1]);
        
        int i=0, k=0, time = 0;
        while(!pq.isEmpty() || i<len){
            if(pq.isEmpty()) time = Math.max(time, tasks[i][0]);
            while(i<len && time >= tasks[i][0]) pq.offer(tasks[i++]);

            int[] cur = pq.poll();
            time += cur[1];
            result[k++] = cur[2];
        }
        return result;
    }
}
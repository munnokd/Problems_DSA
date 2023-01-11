class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] canVisit = new ArrayList[n];
        for(int i = 0; i<n; i++){
            canVisit[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            canVisit[edge[0]].add(edge[1]);            
            canVisit[edge[1]].add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        return helper(0,hasApple,canVisit,visited);
    }
    int helper(int i, List<Boolean> hasApple, List<Integer>[] canVisit, boolean[] visited){
        if(visited[i]) return 0;
        visited[i] = true;
        
        int sum = 0;
        for(int edge : canVisit[i]){
            sum += helper(edge, hasApple, canVisit, visited);
        }
        
        if(i==0) return  sum; 
        
        if(hasApple.get(i) || sum>0 ) return (2 + sum); 
        
        else return 0;        
    }
}
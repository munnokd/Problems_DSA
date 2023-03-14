class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        boolean[] visited = new boolean[n];
        Queue<Integer> bfsQueue = new LinkedList<Integer>();
        bfsQueue.add(start);
        visited[start] = true;
        while(!bfsQueue.isEmpty()) {
            int currentVertex = bfsQueue.poll();
            if(currentVertex == end) {
                return true;
            }
            Set<Integer> neighbors = findNeighbors(edges, n, currentVertex);
            for(int neighbor : neighbors) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    bfsQueue.add(neighbor);
                }
            }
        }
        return false;
    }
    
    private static Set<Integer> findNeighbors(int[][] edges, int n, int v) {
        Set<Integer> neighbors = new HashSet<Integer>();
        for(int[] edge : edges) {
            if(edge[0] == v) {
                neighbors.add(edge[1]);
            } else if(edge[1] == v) {
                neighbors.add(edge[0]);
            }
        }
        return neighbors;
    }
}
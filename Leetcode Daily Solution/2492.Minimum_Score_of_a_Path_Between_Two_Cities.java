class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new List[n + 1];
        for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();
        for(int[] road: roads){
            graph[road[0]].add(new int[]{road[1], road[2]});
            graph[road[1]].add(new int[]{road[0], road[2]});
        }
        Set<Integer> seen = new HashSet<>();
        seen.add(1);
        return helper_dfs(graph, 1, seen);
    }

    private int helper_dfs(List<int[]>[] graph, int node, Set<Integer> seen) {
        int res = Integer.MAX_VALUE;
        for(int[] neighbour : graph[node]) {
            res = Math.min(res, neighbour[1]);
            if (seen.add(neighbour[0]))
                res = Math.min(res, helper_dfs(graph, neighbour[0], seen));
        }
        return res;
    }
}

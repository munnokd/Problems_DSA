class Solution {
    long ans = 0; int s;
    
    private int dfs(int i, int prev, List<List<Integer>> graph) {
        int people = 1;
        for (int x: graph.get(i)) {
            if (x == prev) continue;
            people += dfs(x, i, graph);
        }
        if (i != 0) ans += (people + s - 1) / s;
        return people;
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> graph = new ArrayList(); s = seats;
        for (int i = 0; i < roads.length + 1; i++) graph.add(new ArrayList());
        for (int[] r: roads) {
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }
        dfs(0, 0, graph);
        return ans;
    }
}
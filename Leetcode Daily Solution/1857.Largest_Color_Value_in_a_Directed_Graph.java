class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int k = 26;
        int[] indegrees = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            indegrees[v]++;
        }
        Set<Integer> zero_indegree = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                zero_indegree.add(i);
            }
        }
        int[][] counts = new int[n][k];
        for (int i = 0; i < n; i++) {
            counts[i][colors.charAt(i) - 'a']++;
        }
        int max_count = 0;
        int visited = 0;
        while (!zero_indegree.isEmpty()) {
            int u = zero_indegree.iterator().next();
            zero_indegree.remove(u);
            visited++;
            for (int v : graph.get(u)) {
                for (int i = 0; i < k; i++) {
                    counts[v][i] = Math.max(counts[v][i], counts[u][i] + (colors.charAt(v) - 'a' == i ? 1 : 0));
                }
                indegrees[v]--;
                if (indegrees[v] == 0) {
                    zero_indegree.add(v);
                }
            }
            max_count = Math.max(max_count, Arrays.stream(counts[u]).max().getAsInt());
        }
        return visited == n ? max_count : -1;
    }
}

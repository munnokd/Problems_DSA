class Solution {
    public void dfs(int node, int[] edges, int[] distance, boolean[] visited) {
        visited[node] = true;
        int neighbor = edges[node];
        if (neighbor != -1 && !visited[neighbor]) {
            distance[neighbor] = distance[node] + 1;
            dfs(neighbor, edges, distance, visited);
        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int ans = -1;
        int minDist = Integer.MAX_VALUE;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        boolean[] visited1 = new boolean[n];
        boolean[] visited2 = new boolean[n];
        dfs(node1, edges, dist1, visited1);
        dfs(node2, edges, dist2, visited2);

        for (int currNode = 0; currNode < n; currNode++) {
            if (visited1[currNode] && visited2[currNode] && minDist > Math.max(dist1[currNode], dist2[currNode])) {
                minDist = Math.max(dist1[currNode], dist2[currNode]);
                ans = currNode;
            }
        }
        return ans;
    }
}
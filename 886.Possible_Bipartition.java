class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> mp = new HashMap<>();

        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        for (int i = 1; i <= n; i++) {
            mp.put(i, new ArrayList<>());

        }
        for (int i = 0; i < dislikes.length; i++) {
            mp.get(dislikes[i][0]).add(dislikes[i][1]);
            mp.get(dislikes[i][1]).add(dislikes[i][0]);
        }

        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                if (!bfs(mp, n, i, color)) {
                    return false;
                }
            }
        }
        return true;

    }

    public boolean bfs(Map<Integer, List<Integer>> adj, int n, int i, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i] = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int j : adj.get(curr)) {
                if (color[j] == color[curr])
                    return false;
                if (color[j] == -1) {
                    color[j] = color[curr] == 1 ? 0 : 1;
                    q.add(j);
                }
            }
        }
        return true;
    }

}
//GFG Daily Problem 26-03-23

class Solution {
    public int unvisitedLeaves(int N, int leaves, int frogs[]) {
        // Code here
        int size = leaves + 1;
        int[] visited = new int[size];
        Arrays.fill(visited, 0);
        Arrays.sort(frogs);
        for (int i = 0; i < N; i++) {
            if (frogs[i] <= leaves && visited[frogs[i]] == 0) {
                int j = frogs[i];
                while (j <= leaves) {
                    if (visited[j] != 1) {
                        visited[j] = 1;
                        size--;
                    }
                    j += frogs[i];
                }
            }
            if (size == 1) {
                break;
            }
        }
        return size - 1;
    }
}
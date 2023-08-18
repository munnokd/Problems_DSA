import java.util.*;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<Set<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];
        
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        
        for (int[] edge : roads) {
            int v = edge[0], w = edge[1];
            indegree[v]++;
            indegree[w]++;
            adj.get(v).add(w);
            adj.get(w).add(v);
        }
        
        int maxdegree = 0;
        for (int i = 0; i < n; i++) {
            maxdegree = Math.max(maxdegree, indegree[i]);
        }
        
        List<Integer> maxindex = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == maxdegree) {
                maxindex.add(i);
            }
        }
        
        int samemaxdegree = maxindex.size();
        if (samemaxdegree > 1) {
            for (int i = 1; i < samemaxdegree; i++) {
                for (int j = 0; j < i; j++) {
                    if (!adj.get(maxindex.get(i)).contains(maxindex.get(j))) {
                        System.out.println(maxindex.get(i) + " " + maxindex.get(j));
                        return 2 * maxdegree;
                    }
                }
            }
            return 2 * maxdegree - 1;
        }
        
        int mxid = maxindex.get(0);
        int max_rank = 0;
        for (int j = 0; j < n; j++) {
            if (j == mxid) {
                continue;
            }
            int rank = maxdegree + indegree[j] - (adj.get(mxid).contains(j) ? 1 : 0);
            max_rank = Math.max(max_rank, rank);
            System.out.println(mxid);
        }
        
        return max_rank;
    }
}

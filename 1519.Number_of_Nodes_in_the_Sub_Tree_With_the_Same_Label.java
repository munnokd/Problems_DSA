class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ArrayList<Integer> graph[]=new ArrayList[n];
        int i;
        for(i=0;i<n;i++)
        graph[i]=new ArrayList<>();
        for(i=0;i<edges.length;i++)
        {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        int ans[]=new int[n];
        int freq[]=new int[26];
        boolean dp[]=new boolean[n];
        dfs(0,ans,freq,dp,labels,graph);
        return ans;
    }
public void dfs(int i,int ans[],int freq[],boolean dp[],String s,ArrayList<Integer> graph[])
{
    if(dp[i]) return;
    dp[i]=true;
    int c=s.charAt(i)-'a';
    int tmp=freq[c];
    freq[c]=1;
    for(int it:graph[i])
        dfs(it,ans,freq,dp,s,graph);
    ans[i]=freq[c];
    freq[c]+=tmp;
}
}
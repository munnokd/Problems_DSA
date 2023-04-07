class Solution 
{
    public int dfs(int[][] grid, int i, int j, int[] ar)
    {
        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0)
            return 0;
        if(grid[i][j] == 0)
            return 1;

        grid[i][j] = 0;
        ar[0]++;
        
        return dfs(grid, i + 1, j, ar) * dfs(grid, i - 1, j, ar) * dfs(grid, i, j + 1, ar) * dfs(grid, i, j - 1, ar);
    }

    public int numEnclaves(int[][] grid)
    {
        int[] ar = {0};
        int ans = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    if(dfs(grid, i, j, ar) > 0)
                        ans += ar[0];
                    ar[0] = 0;
                }
            }
        }
        return ans;
    }
}

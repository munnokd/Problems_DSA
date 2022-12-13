class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int dp[][]=new int[matrix.length][matrix.length];
        int ans=Integer.MAX_VALUE;

        for(int i=0;i<matrix.length;i++) dp[0][i]=matrix[0][i];

        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(j==0) dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);

                else if(j==matrix[0].length-1) dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j-1]);

                else dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i-1][j+1]));
            }
        }

        for(int i=0;i<dp.length;i++) 
            if(dp[dp.length-1][i]<ans) ans=dp[dp.length-1][i];

        return ans;
    }
}
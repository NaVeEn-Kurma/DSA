class Solution {
    int f(int m,int n,int[][] dp,int [][]grid){
        if(m==0 && n==0)    return grid[m][n];
        if(m<0 || n<0)  return (int)Math.pow(10,9);
        if(dp[m][n]!=-1)    return dp[m][n];
        int left=grid[m][n]+f(m-1,n,dp,grid);
        int top=grid[m][n]+f(m,n-1,dp,grid);
        return dp[m][n]=Math.min(left,top);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return f(m-1,n-1,dp,grid);
    }
}
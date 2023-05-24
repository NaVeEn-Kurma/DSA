class Solution {
    int f(int m,int n,int end,int[][] mat,int[][] dp){
        if(n<0 || n>end-1 ) return (int)Math.pow(10,9);
        if(m==end-1)    return mat[m][n];
        if(dp[m][n]!=-1)    return dp[m][n];
        int same=mat[m][n]+f(m+1,n,end,mat,dp);
        int left=mat[m][n]+f(m+1,n-1,end,mat,dp);
        int right=mat[m][n]+f(m+1,n+1,end,mat,dp);
        return dp[m][n]=Math.min(same,Math.min(left,right));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int dp[][]=new int[n][n];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int ans=f(0,i,n,matrix,dp);
            min=Math.min(min,ans);
        }
        return min;
    }
}
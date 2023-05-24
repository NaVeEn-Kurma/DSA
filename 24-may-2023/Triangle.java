class Solution {
    int f(int m,int n,int end,List<List<Integer>> triangle,int[][] dp)    {
        if(dp[m][n]!=-1)    return dp[m][n];
        if(m==end-1)
            return triangle.get(m).get(n);
        int cur=triangle.get(m).get(n)+f(m+1,n,end,triangle,dp);
        int next=triangle.get(m).get(n)+f(m+1,n+1,end,triangle,dp);

        return dp[m][n]=Math.min(cur,next);
        
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int dp[][]=new int[n][n];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return f(0,0,n,triangle,dp);
    }
}
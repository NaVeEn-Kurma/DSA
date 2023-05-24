class Solution {
    int f(int m,int n,int [][]dp,int [][]ob){
        if(m==0 && n==0 && ob[m][n]!=1)    return 1;
        if(m<0 || n<0 || ob[m][n]==1)  return 0;
        if(dp[m][n]!=-1)    return dp[m][n];
        int left=f(m-1,n,dp,ob);
        int top=f(m,n-1,dp,ob);
        return dp[m][n]=left+top;
    }
    public int uniquePathsWithObstacles(int[][] ob) {
        int m=ob.length,n=ob[0].length;
        int dp[][]=new int[m][n];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        return f(m-1,n-1,dp,ob);
    }
}
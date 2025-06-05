class  MinInsertions{
    public int minInsertions(String s) {
         return s.length() - lcs(s, new StringBuilder(s).reverse().toString());
    }
    
    int lcs(String s1, String s2) {
        char[] arr1 = s1.toCharArray(), arr2 = s2.toCharArray();
        int m = arr1.length, n = arr2.length, dp[][] = new int[m+1][n+1];
        
        Arrays.fill(dp[0], 0);
        for(int i=1; i<=m; i++) {
            dp[i][0] = 0;
        }
        
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(arr1[i-1] == arr2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[m][n];
    }
}
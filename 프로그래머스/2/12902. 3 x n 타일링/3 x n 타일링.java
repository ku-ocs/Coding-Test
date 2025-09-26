class Solution {
    static long MODULER = 1_000_000_007;
    static long[] dp = new long[5001];
    public int solution(int n) {
        if (n % 2 == 1) return 0;
        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= 5000; i += 2) {
            long val = dp[i-2] * dp[2];
            for (int j = i-4; j >= 0; j -= 2) val += dp[j] * 2;
            dp[i] = val % MODULER;
        }
        
        return (int) dp[n];
    }
}
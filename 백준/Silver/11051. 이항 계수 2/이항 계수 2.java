import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(stz.nextToken());
        int k = Integer.parseInt(stz.nextToken());
        dp = new int[n+1][k+1];
        if (k == 0 || k == n) {
            System.out.println(1);
            return;
        }

        for (int i = 1; i <= n; i++) {
            dp[i][1] = i;
            for (int j = 2; j <= i && j <= k; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % 10007;
            }
        }

        System.out.println(dp[n][k]);
        br.close();
    }
}
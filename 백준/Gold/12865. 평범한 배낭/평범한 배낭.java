import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] W, V;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        K = Integer.parseInt(stz.nextToken());
        W = new int[N+1];
        V = new int[N+1];
        dp = new int[K+1][N+1];

        for (int i = 1; i <= N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            W[i] = Integer.parseInt(stz.nextToken());
            V[i] = Integer.parseInt(stz.nextToken());
        }

        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if (W[j] > i) {
                    dp[i][j] = dp[i][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], V[j] + dp[i-W[j]][j-1]);
                }
            }
        }

        bw.write(dp[K][N] + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
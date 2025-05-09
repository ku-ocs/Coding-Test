import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] T, P;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N+1];
        P = new int[N+1];

        StringTokenizer stz;
        for (int i = 1; i <= N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(stz.nextToken());
            int p = Integer.parseInt(stz.nextToken());
            T[i] = t;
            P[i] = p;
        }

        dp = new long[N+2];
        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i], dp[i-1]);
            if (i + T[i] > N+1) {
                continue;
            }
            dp[i+T[i]] = Math.max(Math.max(dp[i+T[i]], dp[i] + P[i]),dp[i+T[i]-1]);
        }
        System.out.println(Math.max(dp[N+1], dp[N]));
    }
}

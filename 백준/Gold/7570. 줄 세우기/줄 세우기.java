import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, cnt;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N+1];

        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int j = Integer.parseInt(stz.nextToken());
            dp[j] = dp[j-1] + 1;
            cnt = Math.max(cnt, dp[j]);
        }

        System.out.println(N - cnt);
    }
}
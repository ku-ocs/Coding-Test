import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M = Integer.MIN_VALUE;
    static int[] arr;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stz.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(stz.nextToken());
            arr[i] = num;
            M = Math.max(M, num);
        }

        dp = new long[M+1];
        dp[1] = 1;
        if (M >= 2) {
            dp[2] = 1;
        }

        for (int i = 3; i <= M; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }

        for (int i : arr) {
            System.out.println(dp[i]);
        }
    }
}

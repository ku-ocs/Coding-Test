import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, answer = Integer.MIN_VALUE;
    static int[] dp, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        arr = new int[N];
        dp = new int[N];
        stz = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stz.nextToken());
            arr[i] = num;
            dp[i] = num;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            answer = Math.max(dp[i], answer);
        }

        System.out.println(answer);
    }
}

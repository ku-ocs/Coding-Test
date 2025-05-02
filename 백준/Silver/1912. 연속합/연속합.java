import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long answer;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        arr = new int[N];
        dp = new int[N];

        stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0 ; i < N; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }

        dp[0] = arr[0];
        answer = arr[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            answer = Math.max(answer, dp[i]);
        }
        bw.write(answer+"");
        bw.flush();

        br.close();
        bw.close();
    }
}
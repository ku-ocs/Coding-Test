import java.io.*;

public class Main {
    static int N, answer, tempAnswer;
    static int[] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N][2];

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
        }

        if (N == 1) {
            System.out.println(arr[0]);
            return;
        }
        
        if (N >= 2) {
            dp[0][0] = arr[0];
            dp[1][0] = arr[1];
            dp[1][1] = arr[1] + dp[0][0];
            answer = dp[1][1];
        }

        if (N >= 3) {
            dp[2][0] = dp[0][0] + arr[2];
            dp[2][1] = dp[1][0] + arr[2];
            tempAnswer = Math.max(dp[2][0], dp[2][1]);
            answer = Math.max(answer, tempAnswer);
        }

        for (int i = 3; i < N; i++) {
            dp[i][0] = Math.max(Math.max(dp[i-2][0], dp[i-2][1]), Math.max(dp[i-3][0], dp[i-3][1])) + arr[i];
            dp[i][1] = dp[i-1][0] + arr[i];
            tempAnswer = Math.max(dp[i][0], dp[i][1]);
            answer = Math.max(answer, tempAnswer);
        }

        System.out.println(answer);
    }
}

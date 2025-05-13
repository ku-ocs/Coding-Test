import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int T, W, answer;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        T = Integer.parseInt(stz.nextToken());
        W = Integer.parseInt(stz.nextToken());
        arr = new int[T+1];
        dp = new int[T+1][W+1];

        for (int i = 1; i <= T; i++) {
            int p = Integer.parseInt(br.readLine());
            arr[i] = p;

            if (p == 1) {
                dp[i][0] = dp[i-1][0] + 1;
            } else {
                dp[i][0] = dp[i-1][0];
            }

            for (int j = 1; j <= W; j++) {
                    // j 가 짝수일 때는 위치 1 - 1에서 먹을 경우
                    // j 가 홀수일 때는 위치 2 - 2에서 먹을 경우
                if ((p == 1 && j % 2 == 0) || (p == 2 && j % 2 == 1)) {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }

        for(int i : dp[T]) {
            answer = Math.max(answer, i);
        }

        System.out.println(answer);

        br.close();
    }
}

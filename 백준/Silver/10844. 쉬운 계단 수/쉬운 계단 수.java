import java.io.*;

public class Main {
    static int N;
    static long answer;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 끝 자릿수 에 따라 dp 배열 (0 ~ 9)
        dp = new long[N+1][10];

        // 길이가 1일 때 1 ~ 9 만 존재
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        // 0 과 9를 제외한 수는 일정한 규칙
        // 같이 묶어서 if 문으로 제어하는 게 더 좋았으려나?
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][1];
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
            dp[i][9] = dp[i-1][8];
        }

        for (long l : dp[N]) {
            answer = (answer + l) % 1000000000;
        }

        System.out.println(answer);
    }
}

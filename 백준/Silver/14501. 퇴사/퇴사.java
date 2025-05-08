import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static int[] t, p, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        t = new int[N+1];
        p = new int[N+1];
        dp = new int[N+2]; // N+1 일이 누적합의 최대

        StringTokenizer stz;

        for (int i = 1; i <= N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int day = Integer.parseInt(stz.nextToken());
            int price = Integer.parseInt(stz.nextToken());
            t[i] = day;
            p[i] = price;
        }

        for (int i = 1; i <= N; i++) {
            // 전날과 오늘을 비교하여 오늘의 최대수익 입력
            dp[i] = Math.max(dp[i], dp[i-1]);
            // N+1 날의 최대수익을 구하기위해서 이므로 N+1 을 초과할경우 넘긴다.
            if (i + t[i] > N+1) {
                continue;
            }
            // 1일차부터 진행
            // i + t[i] 날이 수입이 들어오는 날.
            // i 날은 i-1 날까지 종료된 상담의 최대수익이 기입되어 있음.
            dp[i + t[i]] = Math.max(dp[i+t[i]], Math.max(dp[i] + p[i], dp[i+t[i]-1]));
        }

        // 위 로직대로면 N+1 일이 비어있을 수도 있음. - 전날과 비교하여 최대값이 최대 수익
        System.out.println(Math.max(dp[N+1], dp[N]));
    }
}

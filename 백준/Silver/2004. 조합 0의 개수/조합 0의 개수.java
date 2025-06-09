import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());

        int sum2 = cnt(N, 2) - cnt(N-M, 2) - cnt(M, 2);
        int sum5 = cnt(N, 5) - cnt(N-M, 5) - cnt(M, 5);

        answer = Math.min(sum2, sum5);

        System.out.println(answer);
    }

    public static int cnt(int num, int i) {
        int cnt = 0;

        while (num >= i) {
            num /= i;
            cnt += num;
        }

        return cnt;
    }
}
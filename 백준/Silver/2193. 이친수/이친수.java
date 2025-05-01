import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long answer;
    static long[][] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        D = new long[N+1][2];

        D[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            D[i][0] = D[i-1][0] + D[i-1][1];
            D[i][1] = D[i-1][0];
        }

        answer = D[N][0] + D[N][1];

        System.out.println(answer);
    }
}
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, D, K, C, length, cnt, answer;
    static int[] sushiArr;
    static int[] eat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stz.nextToken());
        D = Integer.parseInt(stz.nextToken());
        K = Integer.parseInt(stz.nextToken());
        C = Integer.parseInt(stz.nextToken());
        sushiArr = new int[2*N];
        eat = new int[D+1];

        for (int i = 0; i < N; i++) {
            int sushi = Integer.parseInt(br.readLine());
            sushiArr[i] = sushi;
            sushiArr[i+N] = sushi;
        }

        int s = 0;
        int e = 0;

        while (s < N && e < 2*N) {
            while (length < K) {
                if (eat[sushiArr[e]] == 0) {
                    cnt++;
                }
                eat[sushiArr[e]] += 1;
                length++;
                e++;
            }

            if (length == K) {
                if (eat[C] == 0) {
                    answer = Math.max(answer, cnt+1);
                } else {
                    answer = Math.max(answer, cnt);
                }
            }

            if (answer == K+1) {
                System.out.println(answer);
                return;
            }

            length--;
            eat[sushiArr[s]] -= 1;
            if (eat[sushiArr[s++]] == 0) {
                cnt--;
            }
        }

        System.out.println(answer);
    }
}
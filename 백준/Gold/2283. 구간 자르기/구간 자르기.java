import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, K, length, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] len = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stz.nextToken());
        K = Integer.parseInt(stz.nextToken());

        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(stz.nextToken());
            int e = Integer.parseInt(stz.nextToken());
            max = Math.max(max, e);
            min = Math.min(min, s);
            len[s]++;
            len[e]--;
        }

        for (int i = min+1; i <= max; i++) {
            len[i] += len[i-1];
        }

        int[] prefixSum = new int[max+1];
        for (int i = min+1; i <= max; i++) {
            prefixSum[i] = prefixSum[i-1] + len[i-1];
        }

        int s = 0;
        int e = 0;
        int answerS = 0;
        int answerE = 0;
        while (e <= max) {
            length = prefixSum[e] - prefixSum[s];
            if (length == K) {
                answerS = s;
                answerE = e;
                break;
            } else if(length < K) {
                e++;
            } else {
                s++;
            }
        }

        System.out.printf("%d %d", answerS, answerE);
    }
}

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, K, length, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[][] arr;
    static int[] answerArr = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stz.nextToken());
        K = Integer.parseInt(stz.nextToken());
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(stz.nextToken());
            int end = Integer.parseInt(stz.nextToken());
            min = Math.min(start, min);
            max = Math.max(end, max);
            arr[i] = new int [] {start, end};
        }

        int s = 0;
        int e = 0;
        for (int i = 0; i < N; i++) {
            int lineS = arr[i][0];
            if (lineS >= e) {
                continue;
            }
            length++;
        }

        while (s <= e && e <= max) {
            if (length == K) {
                answerArr = new int[] {s, e};
                break;
            } else if (length < K) {
                e++;
                for (int i = 0; i < N; i++) {
                    int lineS = arr[i][0];
                    int lineE = arr[i][1];
                    if (e > lineS && e <= lineE) {
                        length++;
                    }
                }
            } else {
                s++;
                for (int i = 0; i < N; i++) {
                    int lineS = arr[i][0];
                    int lineE = arr[i][1];
                    if (s > lineS && s <= lineE) {
                        length--;
                    }
                }
            }
        }

        System.out.println(answerArr[0] + " " + answerArr[1]);
    }
}

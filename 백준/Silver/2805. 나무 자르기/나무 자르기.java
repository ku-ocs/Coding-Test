import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        arr = new int[N];
        long max = 0;

        stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stz.nextToken());
            arr[i] = num;
            max = Math.max(max, num);
        }

        long s = 0;
        long e = max;
        while (s <= e) {
            long m = (s + e) / 2;
            long sum = 0;
            for (int i : arr) {
                long val = i - m;
                if (val > 0) {
                    sum += val;
                }
            }

            if (sum >= M) {
                answer = m;
                s = m+1;
            } else {
                e = m-1;
            }
        }

        System.out.println(answer);
    }
}
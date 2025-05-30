import java.io.*;
import java.util.Arrays;
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

        stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }

        Arrays.sort(arr);

        long s = 0;
        long e = arr[N-1];
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
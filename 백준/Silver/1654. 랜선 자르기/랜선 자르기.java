import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        K = Integer.parseInt(stz.nextToken());
        N = Integer.parseInt(stz.nextToken());
        arr = new long[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        long s = arr[K-1] / N;
        long e = arr[K-1] + 1;

        while (s < e) {
            long m = (s+e) / 2;
            m = m == 0 ? 1 : m;
            long cnt = 0;
            for (long l : arr) {
                cnt += l / m;
            }
            if (cnt >= N) s = m+1;
            else e = m;
        }

        System.out.println(s-1);
    }
}
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int M, N, cnt, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(stz.nextToken());
        N = Integer.parseInt(stz.nextToken());
        arr = new int[N];

        stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }

        Arrays.sort(arr);
        int s = 1;
        int e = arr[N-1];

        while (s <= e) {
            int m = (s+e) / 2;
            cnt = 0;

            for (int i = 0; i < N; i++) {
                cnt += arr[i] / m;
            }

            if (cnt >= M) {
                answer = m;
                s = m+1;
            } else {
                e = m-1;
            }
        }

        System.out.println(answer);
    }
}
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stz.nextToken());
        C = Integer.parseInt(stz.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int s = 1;
        int e = arr[N-1];

        while (s <= e) {
            int m = (s + e) / 2; // 최소 거리 m;
            int cnt = 1;

            int temp = arr[0];
            for (int i = 1; i < N; i++) {
                if (arr[i] - temp < m) continue;
                cnt++;
                temp = arr[i];
            }

            if (cnt >= C) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        System.out.println(s-1);
    }
}

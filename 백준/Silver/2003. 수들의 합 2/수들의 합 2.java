import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cnt;
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

        int s = 0;
        int e = 0;
        int sum = 0;

        while (true) {
            if (e == N && sum < M) {
                break;
            } else {
                if (sum > M) {
                    sum -= arr[s++];
                } else if (sum < M) {
                    sum += arr[e++];
                } else {
                    cnt++;
                    sum -= arr[s++];
                }
            }
        }

        System.out.println(cnt);
    }
}
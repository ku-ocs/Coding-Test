import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, S, sum, length, answer = Integer.MAX_VALUE;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stz.nextToken());
        S = Integer.parseInt(stz.nextToken());
        arr = new int[N];

        stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }

        int s = 0;
        int e = 0;
        sum = 0;
        length = 0;

        while (true) {
            if (sum < S) {
                if (e == N) {
                    break;
                }
                sum += arr[e++];
                length++;
            } else {
                answer = Math.min(answer, length);
                sum -= arr[s++];
                length--;
            }
        }

        if (answer == Integer.MAX_VALUE) answer = 0;

        System.out.println(answer);
    }
}
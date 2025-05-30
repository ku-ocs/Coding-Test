import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, max;
    static long answer;
    static int[] arr;
    static boolean[] B = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stz.nextToken());
        arr = new int[N];

        stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stz.nextToken());
            arr[i] = num;
            max = Math.max(max, num);
        }

        int s = 0;
        int e = 0;
        B = new boolean[max+1];

        while (s < N) {
            if (e < N && !B[arr[e]]) {
                B[arr[e++]] = true;
                continue;
            }
            answer += e - s;
            B[arr[s++]] = false;
        }

        System.out.println(answer);
    }
}
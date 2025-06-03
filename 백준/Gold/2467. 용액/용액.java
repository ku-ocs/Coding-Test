import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, sum = Integer.MAX_VALUE;
    static int[] arr, answer = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }
        int s = 0;
        int e = N-1;
        while (s < e) {
            int tempSum = arr[s] + arr[e];
            if (sum > Math.abs(tempSum)) {
                answer[0] = arr[s];
                answer[1] = arr[e];
                if (tempSum == 0) break;
                sum = Math.abs(tempSum);
            }

            if (tempSum > 0) {
                e--;
            } else {
                s++;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
        br.close();
    }
}
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long answer = Long.MAX_VALUE;
    static long[] arr, answerArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stz.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            int s = i+1;
            int e = arr.length-1;
            while (s < e) {
                if (e == i) e--;

                long sum = arr[i] + arr[s] + arr[e];
                if (answer > Math.abs(sum)) {
                    answer = Math.abs(sum);
                    answerArr = new long[] {arr[i], arr[s], arr[e]};
                }

                if (sum == 0) {
                    break;
                } else if (sum > 0) {
                    e--;
                } else {
                    s++;
                }
            }
        }

        for (long i : answerArr) {
            bw.write(i+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

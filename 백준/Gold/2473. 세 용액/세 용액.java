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
            for (int j = 0; j < N; j++) {
                if (j == i) {
                    continue;
                }
                long f1 = arr[i];
                long f2 = arr[j];

                int s = 0;
                int e = arr.length-1;

                while (s <= e) {
                    int m = (s + e) / 2;
                    long sum = f1 + f2 + arr[m];
                    long absSum = Math.abs(sum);

                    if (m != i && m != j && answer > absSum) {
                        answer = absSum;
                        answerArr = new long[] {f1, f2, arr[m]};
                    }

                    if (sum > 0) {
                        e = m-1;
                    } else {
                        s = m+1;
                    }
                }
            }
        }

        Arrays.sort(answerArr);

        for (long i : answerArr) {
            bw.write(i+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

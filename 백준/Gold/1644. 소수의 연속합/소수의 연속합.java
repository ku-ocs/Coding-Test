import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    static int N, answer, sum;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        Arrays.fill(arr, 1);

        for (int i = 2; i <= N; i++) {
            if (arr[i] == 0) continue;
            int n = 2;
            while (i*n <= N) {
                arr[i*n++] = 0;
            }
        }

        arr = IntStream.rangeClosed(2, N).filter(i -> arr[i] == 1).toArray();

        int s = 0;
        int e = 0;
        while (true) {
            if (e == arr.length) {
                if (sum == N) {
                    answer++;
                }

                if (sum >= N) {
                    sum -= arr[s++];
                    continue;
                }

                break;
            }

            if (sum == N) {
                answer++;
                sum -= arr[s++];
            } else if (sum > N) {
                sum -= arr[s++];
            } else {
                sum += arr[e++];
            }
        }

        System.out.println(answer);
    }
}
import java.io.*;
import java.util.Arrays;

public class Main {
    static int T, N;
    static boolean[] arr = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        Arrays.fill(arr, true);

        for (int i = 2; i <= 10000; i++) {
            if (!arr[i]) continue;
            for (int j = 2; i*j <= 10000; j++) {
                arr[i*j] = false;
            }
        }

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            int num1 = 0;
            int num2 = 0;

            for (int j = 2; j <= N/2; j++) {
                if (arr[j] && arr[N-j]) {
                    num1 = j;
                    num2 = N-j;
                }
            }

            bw.write(num1 + " " + num2 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
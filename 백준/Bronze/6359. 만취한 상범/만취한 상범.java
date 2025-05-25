import java.io.*;
import java.util.Arrays;

public class Main {
    static int T, cnt;
    static boolean[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            cnt = 0;
            arr = new boolean[n+1];
            Arrays.fill(arr, true);

            for (int j = 2; j <= n; j++) {
                int k = 1;
                while (j*k <= n) {
                    arr[j*k] = !arr[j*k];
                    k++;
                }
            }

            for (boolean b : arr) {
                if (b) cnt++;
            }

            bw.write(cnt-1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.*;
import java.util.Arrays;

public class Main {
    static int T;
    static boolean[] arr = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        Arrays.fill(arr, true);

        for (int i = 2; i <= 500000; i++) {
            if (!arr[i]) {
                continue;
            }
            for (int j = 2; i*j <= 1000000; j++) {
                arr[i*j] = false;
            }
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int answer = 0;

            for (int j = 2; j <= n/2; j++) {
                if(arr[j] && arr[n-j]) answer++;
            }
            bw.write(answer+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
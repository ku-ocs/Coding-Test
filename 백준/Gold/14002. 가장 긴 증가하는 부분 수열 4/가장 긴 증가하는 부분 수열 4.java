import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, idx, L;
    static int[] arr;
    static int[] dp;
    static String[] dpStr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N];
        dpStr = new String[N];

        StringTokenizer stz = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stz.nextToken());
            arr[i] = num;
            dp[i] = 1;
            dpStr[i] = arr[i] + " ";
        }

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (arr[j] > arr[i] && dp[i] + 1 > dp[j]) {
                    dp[j] = dp[i] + 1;
                    dpStr[j] = dpStr[i] + arr[j] + " ";
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dp[i] > L) {
                L = dp[i];
                idx = i;
            }
        }
        
        bw.write(L + "\n");
        bw.write(dpStr[idx]);

        bw.flush();
        bw.close();
        br.close();
    }
}
